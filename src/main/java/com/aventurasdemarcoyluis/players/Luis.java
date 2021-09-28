package com.aventurasdemarcoyluis.players;

import com.aventurasdemarcoyluis.attacks.AttackType;
import com.aventurasdemarcoyluis.abstract_classes.AbstractPlayer;

import com.aventurasdemarcoyluis.enemies.Boo;
import com.aventurasdemarcoyluis.interfaces.IAttackedByBoo;
import com.aventurasdemarcoyluis.interfaces.IAttackedByLuis;


public class Luis extends AbstractPlayer implements IAttackedByBoo {

    public Luis(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(IAttackedByLuis enemy, AttackType attack) {
        enemy.attackedByLuis(this,attack);
    }

    @Override
    public void attackedByBoo(Boo boo) {

    }
}
