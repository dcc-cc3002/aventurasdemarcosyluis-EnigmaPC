package com.aventurasdemarcoyluis;

public class Spiny extends Enemy {
    public Spiny(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(Player player) {
        if (this.isDead() == false) {
            player.enemyAttack(this);
        }
    }
}
