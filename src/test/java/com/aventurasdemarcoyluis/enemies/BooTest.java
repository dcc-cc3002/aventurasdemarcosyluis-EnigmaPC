package com.aventurasdemarcoyluis.enemies;

import com.aventurasdemarcoyluis.abstract_classes.BaseTest;
import com.aventurasdemarcoyluis.attacks.HammerAttack;
import com.aventurasdemarcoyluis.attacks.JumpAttack;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooTest extends BaseTest {

    @BeforeEach
    void setUp() {
        boo = new Boo(20,23,17,60);

        // Jugadores
        marco = new Marco(25,27,30,50,19);
        luis = new Luis(13,6,15,20,7);
    }

    @Test
    void attack() {
    }

    @Test
    void attackedByMarco() {
    }
}