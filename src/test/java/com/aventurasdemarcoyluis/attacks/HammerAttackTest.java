package com.aventurasdemarcoyluis.attacks;

import com.aventurasdemarcoyluis.abstract_classes.BaseTest;
import com.aventurasdemarcoyluis.enemies.Goomba;
import com.aventurasdemarcoyluis.enemies.Spiny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HammerAttackTest extends BaseTest {

    @BeforeEach
    void setUp() {
        hammer = new HammerAttack();

        // Enemigos
        goomba = new Goomba(5, 9, 11, 12);
        spiny = new Spiny(16, 24, 35, 50);
    }

    @Test
    void hurtsBooTest() {
        // Martillo no puede herir a Boo (boolean)
        assertFalse(hammer.hurtsBoo());
    }

    @Test
    void hurtsSpinyTest() {
        // Martillo puede herir a Spiny (boolean)
        assertTrue(hammer.hurtsSpiny());
    }
}