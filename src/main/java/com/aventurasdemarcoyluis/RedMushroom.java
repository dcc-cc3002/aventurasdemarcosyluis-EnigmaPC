package com.aventurasdemarcoyluis;

public class RedMushroom extends Item {
    @Override
    public void useItem(Item item) {
    }

    @Override
    public void use(Player player) {
        double amountOfHeal = player.getMaxHP()*0.1;
        int HP = player.getHP();
        int newHP = (int) (HP + amountOfHeal);
        player.setHP(newHP);
    }
}
