package com.aventurasdemarcoyluis.model.enemies;

import com.aventurasdemarcoyluis.model.abstract_classes.BaseTest;
import com.aventurasdemarcoyluis.model.players.Luis;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooTest extends BaseTest {

    @BeforeEach
    void setUp() {
        boo = new Boo(20,23,17,60);

        // Jugadores
        luis = new Luis(13,6,15,20,7);
    }

    @Test
    void attackTest() {
        // Boo solo ataca a luis
        // El daño que hace boo a luis es 23
        boo.attack(luis);
        assertEquals(luis.getHP(),0);
        // Si está muerto luis ya no le hace más daño
        boo.attack(luis);
        assertEquals(luis.getHP(),0);
    }
}