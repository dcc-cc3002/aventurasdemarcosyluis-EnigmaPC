package com.aventurasdemarcoyluis.model.enemies;

import com.aventurasdemarcoyluis.model.abstract_classes.BaseTest;
import com.aventurasdemarcoyluis.model.players.Luis;
import com.aventurasdemarcoyluis.model.players.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpinyTest extends BaseTest {

    @BeforeEach
    void setUp() {
        spiny = new Spiny(20,25,10,16);

        // Jugadores
        marco = new Marco(25,27,30,50,19);
        luis = new Luis(10,6,15,20,7);
    }

    @Test
    void attack() {
        // A Luis le hace 25 de daño
        spiny.attack(luis);
        assertEquals(luis.getHP(),0);
        // Si luis muere, ya no le hace daño
        spiny.attack(luis);
        assertEquals(luis.getHP(),0);

        // A Marco le hace 13 de daño
        spiny.attack(marco);
        assertEquals(marco.getHP(),37);
        spiny.attack(marco);
        assertEquals(marco.getHP(),24);
        spiny.attack(marco);
        assertEquals(marco.getHP(),11);
        spiny.attack(marco);
        assertEquals(marco.getHP(),0);
        spiny.attack(marco);
        assertEquals(marco.getHP(),0);
    }
}