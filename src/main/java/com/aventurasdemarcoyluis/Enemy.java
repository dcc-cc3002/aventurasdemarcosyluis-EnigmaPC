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

    public void attack(IEntities entities) {
        if (this.isDead() == false) {
            entities.enemyAttack(this);
        }
    }

    @Override
    public void enemyAttack(Enemy enemy) {

    }

    @Override
    public void playerAttackSalto(Player player) {

    }

    @Override
    public void playerAttackMartillo(Player player) {

    }
}
