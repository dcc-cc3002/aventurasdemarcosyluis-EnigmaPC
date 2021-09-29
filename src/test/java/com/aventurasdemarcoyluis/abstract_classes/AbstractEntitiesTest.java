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

        marco2 = new Marco(7, 8, 15, 0, 4);
        luis2 = new Luis(9, 10, 6, 51, 6);
        goomba2 = new Goomba(8, 9, 11, 40, 23);
        spiny2 = new Spiny(16, 24, 35, 50, 0);
        boo2 = new Boo(3, 6, 6, 35, 0);
    }

    @Test
    void isNotDead() {
        // Actualmente marco esta vivo
        // Actualmente merco2 esta muerto
        assertTrue(marco.isNotDead());
        assertFalse(marco2.isNotDead());
    }

    @Test
    void getDamage() {
        // La vida de marco es 40, si obtiene 3.5 de daño,
        // este se aproxima y termina recibiendo 4. Su próxima vida es 36.
        marco.getDamage(3.5);
        assertEquals(marco.getHP(),36);

        // La vida de boo es 35, si obtiene 50.3 de daño,
        // este se aproxima y termina recibiendo 50. Su próxima vida es 0.
        boo.getDamage(50.3);
        assertEquals(boo.getHP(),0);
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
        assertFalse(marco.equals(marco2)); // Diferentes estadísticas
        assertFalse(marco.equals(luis)); // Diferentes estadísticas
        assertTrue(marco.equals(goomba2)); // Mismas estadísticas
        assertFalse(luis.equals(boo)); // Diferentes estadísticas
        assertTrue(boo.equals(boo)); // Mismas estadísticas
        assertFalse(spiny.equals(spiny2)); // Diferentes estadísticas
    }

    @Test
    void testHashCode() {
        assertNotEquals(marco.hashCode(),marco2.hashCode()); // Diferentes estadísticas
        assertNotEquals(marco.hashCode(),luis.hashCode()); // Diferentes estadísticas
        assertEquals(marco.hashCode(),goomba2.hashCode()); // Mismas estadísticas
        assertNotEquals(luis,boo); // Diferentes estadísticas
        assertEquals(boo,boo); // Mismas estadísticas
        assertNotEquals(spiny,spiny2); // Diferentes estadísticas
    }
}