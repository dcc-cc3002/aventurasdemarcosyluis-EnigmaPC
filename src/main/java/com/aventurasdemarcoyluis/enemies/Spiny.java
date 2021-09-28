package com.aventurasdemarcoyluis.enemies;

import com.aventurasdemarcoyluis.attacks.AttackType;
import com.aventurasdemarcoyluis.interfaces.IAttackedByLuis;
import com.aventurasdemarcoyluis.interfaces.IPlayer;
import com.aventurasdemarcoyluis.abstract_classes.AbstractEnemy;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;

public class Spiny extends AbstractEnemy implements IAttackedByLuis {
    public Spiny(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(IPlayer player) {
        if (this.isDead() == false) {
            player.attackedBySpiny(this);
        }
    }

    public void attackedByLuis(Luis luis, AttackType attack) {

    }

    @Override
    public void attackedByMarco(Marco marco, AttackType attack) {

    }
}
