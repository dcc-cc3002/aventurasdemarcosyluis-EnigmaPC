package com.aventurasdemarcoyluis;

public class HoneySyrup extends Item {

    @Override
    public void use(Player player) {
        int newFP = player.getFP()+3;
        player.setFP(newFP);
    }
}
