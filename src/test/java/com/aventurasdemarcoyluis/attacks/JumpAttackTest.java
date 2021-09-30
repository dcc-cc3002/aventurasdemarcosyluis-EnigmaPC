package com.aventurasdemarcoyluis.attacks;

import com.aventurasdemarcoyluis.abstract_classes.BaseTest;
import com.aventurasdemarcoyluis.enemies.Boo;
import com.aventurasdemarcoyluis.enemies.Goomba;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpAttackTest extends BaseTest {

    @BeforeEach
    void setUp() {
        jump = new JumpAttack();

        // Enemigos
        goomba = new Goomba(5, 9, 11, 12);
        boo = new Boo(16, 24, 35, 50);
    }

    @Test
    void hurtsBooTest() {
        // Salto hiere a Boo (boolean)
        assertTrue(jump.hurtsBoo());
    }

    @Test
    void hurtsSpinyTest() {
        // Salto no puede herir a Spiny (boolean)
        assertFalse(jump.hurtsSpiny());
    }

    @Test
    void hurts() {
        // Recordemos que Salto no puede herir a Spiny
        // goomba : HP = 12
        // boo : HP = 50
        jump.hurts(goomba, 5);
        assertTrue(goomba.getHP() == 7);
        jump.hurts(goomba, 11);
        assertTrue(goomba.getHP() == 0);
        jump.hurts(goomba, 50);
        assertTrue(goomba.getHP() == 0);
        // Ya no hace reduce daño si el enemigo está KO
        // (Pero esta no es la aplicación real, lo real está
        // en el método attack de cada Player)
        jump.hurts(boo, 11);
        assertTrue(boo.getHP() == 39);
        jump.hurts(boo, 5);
        assertTrue(boo.getHP() == 34);
    }
}