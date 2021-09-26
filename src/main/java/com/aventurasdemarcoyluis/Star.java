package com.aventurasdemarcoyluis;

public class Star extends Item {
    @Override
    public void useItem(Item item) {

    }

    @Override
    public void use(Player player) {
        player.setInvincible(true);
    }
}
