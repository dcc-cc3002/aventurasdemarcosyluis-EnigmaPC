package com.aventurasdemarcoyluis.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.StringReader;

public class PhasesTest {
    private GameController controller;

    @BeforeEach
    void setUp() {
        controller = new GameController();
        controller.setSeedRandomEnemy(15);
        controller.setSeedRandom(20);
        controller.setSeedAttack(30);
    }
}
