package com.aventurasdemarcoyluis;

public class Luis extends Player {

    public Luis(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    @Override
    public void attack(Enemy enemy, AttackType attack) {
        if (this.getFP() != 0 || this.isDead() == false) {
            if ((enemy instanceof Boo) == false) {
                enemy.playerAttack(this, attack);
            }
        }
    }
}
