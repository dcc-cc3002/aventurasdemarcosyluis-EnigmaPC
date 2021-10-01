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
}