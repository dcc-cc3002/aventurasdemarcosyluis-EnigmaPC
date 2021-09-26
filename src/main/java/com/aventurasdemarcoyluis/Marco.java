package com.aventurasdemarcoyluis;

public class Marco extends Player {
    public Marco(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    @Override
    public void attack(Enemy enemy, AttackType attack) {
        if (this.getFP() != 0) {
            enemy.playerAttack(this, attack);
        }
    }
}