package com.aventurasdemarcoyluis;

public class Goomba extends Enemy {
    public Goomba(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(Player player) {
        if (this.isDead() == false) {
            player.enemyAttack(this);
        }
    }
}
