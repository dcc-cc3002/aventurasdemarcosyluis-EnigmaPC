package com.aventurasdemarcoyluis.attacks;

import com.aventurasdemarcoyluis.abstract_classes.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HammerAttackTest extends BaseTest {

    @BeforeEach
    void setUp() {
        hammer = new HammerAttack();
    }

    @Test
    void attackFailed() {
        int counterFailed = 0;
        int counter = 0;
        while (counter <= 10000) {
            if (hammer.attackFailed()) {
                counterFailed += 1;
            } counter += 1;
        }
        double probability = counterFailed/10000.0;
        assertTrue(probability < 0.28 && probability > 0.22);
    }

    @Test
    void hurtsBoo() {
        // Martillo no puede herir a Boo (boolean)
        assertFalse(hammer.hurtsBoo());
    }

    @Test
    void hurtsSpiny() {
        // Martillo puede herir a Spiny (boolean)
        assertTrue(hammer.hurtsSpiny());
    }
}