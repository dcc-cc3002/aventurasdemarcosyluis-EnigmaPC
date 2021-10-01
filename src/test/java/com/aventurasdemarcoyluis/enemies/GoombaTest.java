package com.aventurasdemarcoyluis.enemies;

import com.aventurasdemarcoyluis.abstract_classes.BaseTest;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoombaTest extends BaseTest {

    @BeforeEach
    void setUp() {
        goomba = new Goomba(20,23,17,60);

        // Jugadores
        marco = new Marco(25,27,30,50,19);
        luis = new Luis(13,6,15,20,7);
    }

    @Test
    void attack() {
    }
}