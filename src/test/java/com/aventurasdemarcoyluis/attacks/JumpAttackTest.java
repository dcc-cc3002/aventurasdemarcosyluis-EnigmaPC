package com.aventurasdemarcoyluis.attacks;

import com.aventurasdemarcoyluis.abstract_classes.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpAttackTest extends BaseTest {

    @BeforeEach
    void setUp() {
        jump = new JumpAttack();
    }

    @Test
    void hurtsBoo() {
        // Salto hiere a Boo (boolean)
        assertFalse(jump.hurtsBoo());
    }

    @Test
    void hurtsSpiny() {
        // Salto no puede herir a Spiny (boolean)
        assertFalse(jump.hurtsSpiny());
    }
}