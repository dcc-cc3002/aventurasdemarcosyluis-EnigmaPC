package com.aventurasdemarcoyluis.model.abstract_classes;

import com.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.aventurasdemarcoyluis.model.items.RedMushroom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractItemTest extends BaseTest {

    @BeforeEach
    void setUp() {
        honeySyrup = new HoneySyrup();
        redMushroom = new RedMushroom();
    }

    @Test
    void getNameTest() {
        assertEquals(honeySyrup.getName(),honeySyrup.getName());
        assertNotEquals(honeySyrup.getName(),redMushroom.getName());
        assertEquals(redMushroom.getName(),redMushroom.getName());
        assertEquals(redMushroom.getName(),"RedMushroom");
        assertEquals(honeySyrup.getName(),"HoneySyrup");
    }

    @Test
    void testEquals() {
        assertFalse(honeySyrup.equals(redMushroom));
        assertTrue(honeySyrup.equals(honeySyrup));
        assertTrue(redMushroom.equals(redMushroom));
    }

    @Test
    void testHashCode() {
        assertEquals(honeySyrup.hashCode(),honeySyrup.hashCode());
        assertEquals(redMushroom.hashCode(),redMushroom.hashCode());
        assertNotEquals(honeySyrup.hashCode(),redMushroom.hashCode());
    }
}