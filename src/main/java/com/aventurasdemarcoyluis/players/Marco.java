package com.aventurasdemarcoyluis.players;

import com.aventurasdemarcoyluis.attacks.AttackType;
import com.aventurasdemarcoyluis.abstract_classes.AbstractPlayer;
import com.aventurasdemarcoyluis.interfaces.IEnemy;

public class Marco extends AbstractPlayer {
    public Marco(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(IEnemy enemy, AttackType attack) {
        if (this.getFP() != 0) {
            enemy.attackedByMarco(this, attack);
        }
    }
}