package com.aventurasdemarcoyluis.players;

import com.aventurasdemarcoyluis.attacks.AttackType;
import com.aventurasdemarcoyluis.abstract_classes.AbstractPlayer;

import com.aventurasdemarcoyluis.interfaces.IAttackedByLuis;


public class Luis extends AbstractPlayer {

    public Luis(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(IAttackedByLuis enemy, AttackType attack) {
        enemy.luisAttack(this,attack);
    }

}
