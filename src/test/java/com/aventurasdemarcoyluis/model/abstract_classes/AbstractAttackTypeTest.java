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
    void getNameTest() {
        assertEquals(hammer.getName(),hammer.getName());
        assertEquals(hammer.getName(),"Martillo");
        assertNotEquals(hammer.getName(),jump.getName());
        assertEquals(jump.getName(),jump.getName());
        assertEquals(jump.getName(),"Salto");
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
}