package com.aventurasdemarcoyluis.enemies;

import com.aventurasdemarcoyluis.interfaces.IAttacks;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;
import com.aventurasdemarcoyluis.abstract_classes.AbstractEnemy;


public class Boo extends AbstractEnemy {

    public Boo(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(Luis luis) {
        if (this.isNotDead()) {
            luis.attackedByBoo(this);
        }
    }

    @Override
    public void attackedByMarco(Marco marco, IAttacks attack) {
        marco.attackCost(attack);
        if (attack.hurtsBoo()) {
            attack.hurts(this, this.damageToHurt(marco, attack));
        } else {
            this.dodge();
        }
    }
}
