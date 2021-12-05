package com.aventurasdemarcoyluis.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Ejemplo de juego para jugar uwu
 */
public class GameExample {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.escenaryToPlay(System.out, new BufferedReader(new InputStreamReader(System.in)));
    }
}
