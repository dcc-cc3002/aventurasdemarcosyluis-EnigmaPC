package com.aventurasdemarcoyluis.enemies;

import com.aventurasdemarcoyluis.interfaces.IAttack;
import com.aventurasdemarcoyluis.interfaces.IAttackedByLuis;
import com.aventurasdemarcoyluis.interfaces.IEnemy;
import com.aventurasdemarcoyluis.interfaces.IPlayer;
import com.aventurasdemarcoyluis.abstract_classes.AbstractEnemy;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;


public class Goomba extends AbstractEnemy implements IAttackedByLuis, IEnemy {

    public Goomba(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(IPlayer player) {
        if (this.isDead() == false) {
            player.attackedByGoomba(this);
        }
    }

    @Override
    public void attackedByLuis(Luis luis, IAttack attack) {

    }

    @Override
    public void attackedByMarco(Marco marco, IAttack attack) {

    }
}
