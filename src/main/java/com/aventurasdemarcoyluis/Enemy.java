package com.aventurasdemarcoyluis;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Enemy extends Entities {
    private double K;

    public Enemy(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
        this.K = 0.75;
    }

    public double getK() {
        return K;
    }

    public abstract void attack(Player player);

    @Override
    public void enemyAttack(Enemy enemy) {

    }

    @Override
    public void playerAttack(Player player, AttackType attack) {
        double damageDeal = attack.getK()*player.getATK()*((double) player.getLVL()/this.getDEF());
        if (attack.equals(AttackType.MARTILLO)) {
            int dado = (int) (Math.random()*4);
            if (dado != 1) {
                damageDeal = 0;
            }
        }
        int nuevoHP = (int) (this.getHP() - damageDeal);
        this.setHP(nuevoHP);
        int nuevoFP = player.getFP() - attack.getFPCost();
        player.setFP(nuevoFP);
    }
}
