package com.aventurasdemarcoyluis;

public class HoneySyrup extends Item {

    @Override
    public void use(Player player) {
        int playerFP = player.getFP();
        int newFP = 3 + playerFP;
        player.setFP(newFP);
    }
}
