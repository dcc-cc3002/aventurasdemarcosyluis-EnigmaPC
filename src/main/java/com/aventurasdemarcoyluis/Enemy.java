package com.aventurasdemarcoyluis;

public class Enemy extends Entities {
    private double K;

    public Enemy(int level, int attack, int defense, int healPoints, int fightPoints, double K) {
        super(level, attack, defense, healPoints, fightPoints);
        this.K = K;
    }

    @Override
    public void attack(IEntities entities) {
        entities.enemyAttack(this);
    }

    @Override
    public void enemyAttack(Enemy enemy) {
        double damageDeal = K*enemy.getATK()*((double) enemy.getLVL()/this.getDEF());
        int nuevoHP = (int) (this.getHP() - damageDeal);
        this.setHP(nuevoHP);
    }

    @Override
    public void playerAttack(Player player) {

    }
}
