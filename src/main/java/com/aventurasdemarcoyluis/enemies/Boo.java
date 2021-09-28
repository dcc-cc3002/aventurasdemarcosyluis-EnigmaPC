package com.aventurasdemarcoyluis.enemies;

import com.aventurasdemarcoyluis.interfaces.IAttack;
import com.aventurasdemarcoyluis.interfaces.IEnemy;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;
import com.aventurasdemarcoyluis.abstract_classes.AbstractEnemy;


public class Boo extends AbstractEnemy implements IEnemy {

    public Boo(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(Luis luis) {
        luis.attackedByBoo(this);
    }

    @Override
    public void attackedByMarco(Marco marco, IAttack attack) {
        double damageDeal = attack.getK()*marco.getATK()*((double) marco.getLVL()/this.getDEF());
        marco.attackCost(attack);
        attack.hurtsBoo(this,damageDeal);
    }
}
