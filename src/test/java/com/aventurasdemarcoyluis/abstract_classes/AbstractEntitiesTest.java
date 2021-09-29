package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.BaseTest;
import com.aventurasdemarcoyluis.enemies.Boo;
import com.aventurasdemarcoyluis.enemies.Goomba;
import com.aventurasdemarcoyluis.enemies.Spiny;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractEntitiesTest extends BaseTest {

    @BeforeEach
    void setUp() {
        // Entidades
        marco = new Marco(8, 9, 11, 40, 23);
        luis = new Luis(10, 11, 6, 51, 6);
        goomba = new Goomba(2, 3, 4, 7, 0);
        spiny = new Spiny(17, 25, 20, 90, 0);
        boo = new Boo(9, 13, 11, 35, 0);

        marco2 = new Marco(7, 8, 15, 0, 3);
        luis2 = new Luis(9, 10, 6, 51, 6);
        goomba2 = new Goomba(1, 2, 7, 7, 0);
        spiny2 = new Spiny(16, 24, 35, 50, 0);
        boo2 = new Boo(3, 6, 6, 35, 0);
    }

    @Test
    void isNotDead() {
        assertEquals(marco.isNotDead(),true);
        assertEquals(marco2.isNotDead(),false);

    }

    @Test
    void canAttack() {
    }

    @Test
    void getDamage() {
    }

    @Test
    void setFP() {
    }

    @Test
    void getFP() {
    }

    @Test
    void setHP() {
    }

    @Test
    void getHP() {
    }

    @Test
    void getLVL() {
    }

    @Test
    void setLVL() {
    }

    @Test
    void getATK() {
    }

    @Test
    void setATK() {
    }

    @Test
    void getDEF() {
    }

    @Test
    void setDEF() {
    }

    @Test
    void getMaxHP() {
    }

    @Test
    void setMaxHP() {
    }

    @Test
    void getMaxFP() {
    }

    @Test
    void setMaxFP() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }
}