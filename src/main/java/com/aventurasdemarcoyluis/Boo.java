package com.aventurasdemarcoyluis;

public class Boo extends Enemy {
    public Boo(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    @Override
    public void attack(Player player) {
        if (this.isDead() == false) {
            if (player instanceof Marco) {
                player.enemyAttack(this);
            }
        }
    }
}
