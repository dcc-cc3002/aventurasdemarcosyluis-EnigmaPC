package com.aventurasdemarcoyluis.controller;

import com.aventurasdemarcoyluis.controller.phases.WaitSelectItem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Ejemplo de juego para jugar uwu
 */
public class GameExample {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.setSeedRandomEnemy(10);
        controller.setSeedRandom(12);
        controller.setSeedAttack(8);
        controller.escenaryTestAttack(System.out, new BufferedReader(new InputStreamReader(System.in)));
    }
}
