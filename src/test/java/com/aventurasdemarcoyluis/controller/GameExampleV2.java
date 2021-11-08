package com.aventurasdemarcoyluis.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameExampleV2 {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.escenario(System.out, new BufferedReader(new InputStreamReader(System.in)));
    }
}
