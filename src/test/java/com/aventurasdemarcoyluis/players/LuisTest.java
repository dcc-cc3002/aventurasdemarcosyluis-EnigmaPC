package com.aventurasdemarcoyluis.players;

import com.aventurasdemarcoyluis.abstract_classes.BaseTest;
import com.aventurasdemarcoyluis.attacks.HammerAttack;
import com.aventurasdemarcoyluis.attacks.JumpAttack;
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

        // Ataques
        hammer = new HammerAttack();
        jump = new JumpAttack();
    }

    @Test
    void attackTest() {
        // El daño del ataque se calcula con la fórmula entregada en el enunciado
        // Probemos que también se van gastando los FP
        luis.attack(goomba,hammer);

    }

    @Test
    void attackedByBooTest() {
    }

    @Test
    void attackedByGoombaTest() {
    }

    @Test
    void attackedBySpinyTest() {
    }
}