package com.aventurasdemarcoyluis;

public class HoneySyrup extends AbstractItem {

    @Override
    public void use(IPlayer player) {
        int newFP = player.getFP()+3;
        player.setFP(newFP);
    }
}
