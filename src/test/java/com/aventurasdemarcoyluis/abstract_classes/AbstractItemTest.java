package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.items.HoneySyrup;
import com.aventurasdemarcoyluis.items.RedMushroom;
import com.aventurasdemarcoyluis.items.Star;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractItemTest extends BaseTest {

    @BeforeEach
    void setUp() {
        honeySyrup = new HoneySyrup();
        star = new Star();
        redMushroom = new RedMushroom();
    }

    @Test
    void testEquals() {
        assertFalse(honeySyrup.equals(star));
        assertFalse(honeySyrup.equals(redMushroom));
        assertFalse(redMushroom.equals(star));
        assertTrue(star.equals(star));
        assertTrue(honeySyrup.equals(honeySyrup));
        assertTrue(redMushroom.equals(redMushroom));
    }

    @Test
    void testHashCode() {
        assertEquals(honeySyrup.hashCode(),honeySyrup.hashCode());
        assertEquals(star.hashCode(),star.hashCode());
        assertEquals(redMushroom.hashCode(),redMushroom.hashCode());
        assertNotEquals(honeySyrup.hashCode(),star.hashCode());
        assertNotEquals(honeySyrup.hashCode(),redMushroom.hashCode());
        assertNotEquals(star.hashCode(),redMushroom.hashCode());
    }
}