package com.aventurasdemarcoyluis.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    private GameController controller;

    @BeforeEach
    void setUp() {
        controller = new GameController();
        controller.setSeedRandomEnemy(15);
        controller.setSeedRandom(20);
        controller.setSeedAttack(30);
    }

    @Test
    void escenarioWinnable() {
        checkEscenario();
        // Nivel Batalla 1:
        // 1 Boo | nivel: 14, ataque: 18, defensa: 14, vida: 37
        // 2 Spiny | nivel: 15, ataque: 17, defensa: 15, vida: 36
        // 3 Goomba | nivel: 16, ataque: 16, defensa: 16, vida: 35
        // Nivel Batalla 2:
        // 1 Boo | nivel: 16, ataque: 19, defensa: 18, vida: 41
        // 2 Goomba | nivel: 15, ataque: 20, defensa: 17, vida: 42
        // 3 Spiny | nivel: 15, ataque: 20, defensa: 17, vida: 42
        // Nivel Batalla 3:
        // 1 Spiny | nivel: 13, ataque: 23, defensa: 26, vida: 39
        // 2 Goomba | nivel: 14, ataque: 22, defensa: 25, vida: 40
        // 3 Spiny | nivel: 13, ataque: 23, defensa: 26, vida: 39
        // 4 Goomba | nivel: 12, ataque: 23, defensa: 26, vida: 38
        // 5 Goomba | nivel: 12, ataque: 23, defensa: 26, vida: 38
        // Nivel Batalla 4:
        // 1 Goomba | nivel: 15, ataque: 24, defensa: 25, vida: 47
        // 2 Spiny | nivel: 14, ataque: 25, defensa: 24, vida: 46
        // 3 Spiny | nivel: 15, ataque: 24, defensa: 25, vida: 47
        // 4 Boo | nivel: 14, ataque: 25, defensa: 24, vida: 46
        // 5 Spiny | nivel: 15, ataque: 24, defensa: 25, vida: 47
        // Nivel Batalla 5:
        // 1 Goomba | nivel: 15, ataque: 28, defensa: 28, vida: 54
        // 2 Goomba | nivel: 16, ataque: 27, defensa: 29, vida: 55
        // 3 Goomba | nivel: 14, ataque: 28, defensa: 28, vida: 53
        // 4 Goomba | nivel: 14, ataque: 28, defensa: 28, vida: 53
        // 5 Boo | nivel: 12, ataque: 29, defensa: 27, vida: 51
        // 6 Boo | nivel: 14, ataque: 28, defensa: 28, vida: 53
        // Combinación de numeros:
        // Primer número: 0 ataque, 1 seleccion de item, 2 pasar
        // Si primer número 0:
        // Segundo número: Se elige el enemigo según el número (los enemigos se eliminan a medida que mueren)
        // Si primer número es 1:
        // Segundo número: 1 para HoneySyrup, 2 para RedMushroom
        // Si primer número es 2:
        // Se pasa

        // Números:
        // Batalla 1
        // 0 - 1 - 2
        // 0 - 2 - 1
        // 0 - 1 - 2
        // 0 - 2 - 1
        // 0 - 1 - 2
        // 0 - 1 - 1
        // 0 - 1 - 1
        // 0 - 1 - 1

        // Batalla 2
        // 0 - 1 - 2
        // 0 - 2 - 1
        // 0 - 1 - 2
        // 0 - 2 - 1
        // 0 - 1 - 2
        // 0 - 1 - 1
        // 0 - 1 - 1
        // 0 - 1 - 1
        // 
        assertTrue(controller.winGame());



    }

    // Creado para checkear escenario
    public void checkEscenario(String stringNum) {
        controller.escenario(NullOutputStream,new BufferedReader(new StringReader(stringNum)));
    }

}