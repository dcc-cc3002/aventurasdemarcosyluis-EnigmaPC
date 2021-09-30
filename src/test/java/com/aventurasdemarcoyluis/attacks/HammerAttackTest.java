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

    @Test
    void hurtsTest() {
        // Recordemos que Martillo no hace daño a Spiny
        // goomba : HP = 12
        // spiny : HP = 50
        hammer.hurts(goomba, 5);
        assertTrue(goomba.getHP() == 7 || goomba.getHP() == 12);
        hammer.hurts(goomba, 11);
        assertTrue(goomba.getHP() == 0 || goomba.getHP() == 1
                || goomba.getHP() == 12 || goomba.getHP() == 7);
        hammer.hurts(goomba, 50);
        assertTrue(goomba.getHP() == 0 || goomba.getHP() == 1
                || goomba.getHP() == 12 || goomba.getHP() == 7);
        // Ya no hace reduce daño si el enemigo está KO
        // (Pero esta no es la aplicación real, lo real está
        // en el método attack de cada Player)
        hammer.hurts(spiny, 11);
        assertTrue(spiny.getHP() == 39 || spiny.getHP() == 50);
        hammer.hurts(spiny, 5);
        assertTrue(spiny.getHP() == 34 || spiny.getHP() == 45
                || spiny.getHP() == 39 || spiny.getHP() == 50);
    }
}