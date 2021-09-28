package com.aventurasdemarcoyluis.enemies;

import com.aventurasdemarcoyluis.attacks.AttackType;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;
import com.aventurasdemarcoyluis.interfaces.IPlayer;
import com.aventurasdemarcoyluis.abstract_classes.AbstractEnemy;


public class Boo extends AbstractEnemy {
    public Boo(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(Luis luis) {
        luis.attackedByBoo(this);
    }

    @Override
    public void attackedByMarco(Marco marco, AttackType attack) {
        if (attack.equals(AttackType.MARTILLO)) {
            this.dodge();
        } else {
            this.isAttacked(marco, attack);
        }
    }
}
