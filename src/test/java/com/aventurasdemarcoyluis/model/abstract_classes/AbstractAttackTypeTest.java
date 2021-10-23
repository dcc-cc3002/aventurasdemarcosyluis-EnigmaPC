package com.aventurasdemarcoyluis.model.abstract_classes;

import com.aventurasdemarcoyluis.model.attacks.HammerAttack;
import com.aventurasdemarcoyluis.model.attacks.JumpAttack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractAttackTypeTest extends BaseTest {

    @BeforeEach
    void setUp() {
        // Ataques
        hammer = new HammerAttack();
        jump = new JumpAttack();
    }

    @Test
    void testEquals() {
        assertFalse(hammer.equals(jump));
        assertFalse(jump.equals(hammer));
        assertTrue(hammer.equals(hammer));
        assertTrue(jump.equals(jump));
    }

    @Test
    void testHashCode() {
        assertNotEquals(hammer.hashCode(),jump.hashCode());
        assertNotEquals(jump.hashCode(),hammer.hashCode());
        assertEquals(hammer.hashCode(),hammer.hashCode());
        assertEquals(jump.hashCode(),jump.hashCode());
    }

    /**
     * Creado para revisar que la probabilidad de fallo sea de un 25%.
     * Siguiendo la ley de los grandes números
     */
    @Test
    void attackFailedTest() {
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
}