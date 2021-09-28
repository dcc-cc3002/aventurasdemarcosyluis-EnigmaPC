package com.aventurasdemarcoyluis;

public class RedMushroom extends AbstractItem {
    @Override
    public void use(IPlayer player) {
        double amountOfHeal = player.getMaxHP()*0.1;
        int HP = player.getHP();
        int newHP = (int) (HP + amountOfHeal);
        player.setHP(newHP);
    }
}
