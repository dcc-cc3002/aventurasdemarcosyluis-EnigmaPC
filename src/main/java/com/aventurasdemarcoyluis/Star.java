package com.aventurasdemarcoyluis;

public class Star extends AbstractItem {
    @Override
    public void use(IPlayer player) {
        player.setInvincible(true);
    }
}
