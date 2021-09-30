package com.aventurasdemarcoyluis.players;

import com.aventurasdemarcoyluis.abstract_classes.BaseTest;
import com.aventurasdemarcoyluis.attacks.HammerAttack;
import com.aventurasdemarcoyluis.attacks.JumpAttack;
import com.aventurasdemarcoyluis.enemies.Boo;
import com.aventurasdemarcoyluis.enemies.Goomba;
import com.aventurasdemarcoyluis.enemies.Spiny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuisTest extends BaseTest {

    @BeforeEach
    void setUp() {
        // Luis
        luis = new Luis(20,23,17,60,7);

        // Enemigos
        goomba = new Goomba(25,27,30,50);
        spiny = new Spiny(13,6,15,20);
        boo = new Boo(15,17,20,20);

        // Ataques
        hammer = new HammerAttack();
        jump = new JumpAttack();
    }

    @Test
    void attackTest() {
        // El daño del ataque se calcula con la fórmula entregada en el enunciado
        // Probemos que también se van gastando los FP
        luis.attack(goomba,hammer);
        assertTrue(goomba.getHP() == 50 || goomba.getHP() == 27);
        assertTrue(luis.getFP() == 7 || luis.getFP() == 5);
        luis.attack(goomba,hammer);
        assertTrue(goomba.getHP() == 50 || goomba.getHP() == 27
                || goomba.getHP() == 4);
        assertTrue(luis.getFP() == 7 || luis.getFP() == 5
                || luis.getFP() == 3);
        // Ahora con spiny
        luis.attack(spiny,hammer);
        assertTrue(spiny.getHP() == 0 || spiny.getHP() == 20);
        assertTrue(luis.getFP() == 7 || luis.getFP() == 5
                || luis.getFP() == 3 || luis.getFP() == 1);
    }

    @Test
    void attackedByBooTest() {
        luis = new Luis(20,23,17,60,7);
        // Con la fórmula del Daño sabemos que Boo hace 11 de daño por hit.
        luis.attackedByBoo(boo);
        assertEquals(luis.getHP(),49);
        luis.attackedByBoo(boo);
        assertEquals(luis.getHP(),38);
        luis.attackedByBoo(boo);
        assertEquals(luis.getHP(),27);
        luis.attackedByBoo(boo);
        assertEquals(luis.getHP(),16);
        luis.attackedByBoo(boo);
        assertEquals(luis.getHP(),5);
        luis.attackedByBoo(boo);
        assertEquals(luis.getHP(),0);
    }

    @Test
    void attackedByGoombaTest() {
        luis = new Luis(20,23,17,60,7);
        // Con la fórmula del Daño sabemos que Goomba hace 30 de daño por hit.
        luis.attackedByGoomba(goomba);
        assertEquals(luis.getHP(),30);
        luis.attackedByGoomba(goomba);
        assertEquals(luis.getHP(),0);
        luis.attackedByGoomba(goomba);
        assertEquals(luis.getHP(),0);
    }

    @Test
    void attackedBySpinyTest() {
        luis = new Luis(20,23,17,60,7);
        // Con la fórmula del Daño sabemos que Spiny hace 4 de daño por hit.
        luis.attackedBySpiny(spiny);
        assertEquals(luis.getHP(),56);
        luis.attackedBySpiny(spiny);
        assertEquals(luis.getHP(),52);
        luis.attackedBySpiny(spiny);
        assertEquals(luis.getHP(),48);
        luis.attackedBySpiny(spiny);
        assertEquals(luis.getHP(),44);
        luis.attackedBySpiny(spiny);
        assertEquals(luis.getHP(),40);
        luis.attackedBySpiny(spiny);
        assertEquals(luis.getHP(),36);
    }
}