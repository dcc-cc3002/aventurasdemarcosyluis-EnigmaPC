package com.aventurasdemarcoyluis;

public class Enemy extends Entities {
    private double K;

    public Enemy(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
        this.K = 0.75;
    }

    public double getK() {
        return K;
    }

    @Override
    public void attack(IEntities entities) {
        entities.enemyAttack(this);
    }

    @Override
    public void enemyAttack(Enemy enemy) {

    }

    @Override
    public void playerAttack(Player player) {

    }

}
