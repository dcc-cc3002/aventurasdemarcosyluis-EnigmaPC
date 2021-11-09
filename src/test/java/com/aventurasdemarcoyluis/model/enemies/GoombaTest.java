package com.aventurasdemarcoyluis.model.enemies;

import com.aventurasdemarcoyluis.model.abstract_classes.BaseTest;
import com.aventurasdemarcoyluis.model.players.Luis;
import com.aventurasdemarcoyluis.model.players.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoombaTest extends BaseTest {

    @BeforeEach
    void setUp() {
        goomba = new Goomba(15,17,10,16);

        // Jugadores
        marco = new Marco(25,27,30,50,19);
        luis = new Luis(10,6,15,20,7);
    }

    @Test
    void attackTest() {
        // A Luis le hace 13 de daño
        goomba.attack(luis);
        assertEquals(luis.getHP(),7);
        goomba.attack(luis);
        assertEquals(luis.getHP(),0);
        // Si luis muere ya no le hace daño
        goomba.attack(luis);
        assertEquals(luis.getHP(),0);

        // A Marco le hace 7 de daño
        goomba.attack(marco);
        assertEquals(marco.getHP(),43);
        goomba.attack(marco);
        assertEquals(marco.getHP(),36);
        goomba.attack(marco);
        assertEquals(marco.getHP(),29);
    }

    @Test
    void isBoo() {
        assertFalse(goomba.isBoo());
    }

    @Test
    void isSpiny() {
        assertFalse(goomba.isSpiny());
    }
}