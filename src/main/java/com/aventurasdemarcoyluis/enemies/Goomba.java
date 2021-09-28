package com.aventurasdemarcoyluis.enemies;

import com.aventurasdemarcoyluis.attacks.AttackType;
import com.aventurasdemarcoyluis.interfaces.IAttackedByLuis;
import com.aventurasdemarcoyluis.interfaces.IPlayer;
import com.aventurasdemarcoyluis.abstract_classes.AbstractEnemy;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;


public class Goomba extends AbstractEnemy implements IAttackedByLuis {

    public Goomba(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(IPlayer player) {
        if (this.isDead() == false) {
            player.isAttacked(this);
        }
    }

    @Override
    public void attackedByMarco(Marco marco, AttackType attack) {
        this.isAttacked(marco, attack);
    }

    @Override
    public void attackedByLuis(Luis luis, AttackType attack) {

    }
}
