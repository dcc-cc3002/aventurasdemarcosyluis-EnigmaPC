package com.aventurasdemarcoyluis;

public class Star extends Item {
    @Override
    public void use(AbstractPlayer player) {
        player.setInvincible(true);
    }
}
