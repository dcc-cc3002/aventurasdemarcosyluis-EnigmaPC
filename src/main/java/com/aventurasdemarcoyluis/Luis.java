package com.aventurasdemarcoyluis;

public class Luis extends AbstractPlayer {

    public Luis(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    @Override
    public void attack(AbstractEnemy enemy, AttackType attack) {
        if (this.getFP() != 0 || this.isDead() == false) {
            if ((enemy instanceof Boo) == false) {   // Podría crear un método enemy.LuisAttack.
                enemy.playerAttack(this, attack);
            }
        }
    }

}
