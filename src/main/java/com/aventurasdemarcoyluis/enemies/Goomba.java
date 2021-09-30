package com.aventurasdemarcoyluis.enemies;

import com.aventurasdemarcoyluis.interfaces.IAttacks;
import com.aventurasdemarcoyluis.interfaces.IAttackedByLuis;
import com.aventurasdemarcoyluis.interfaces.IPlayer;
import com.aventurasdemarcoyluis.abstract_classes.AbstractEnemy;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;


public class Goomba extends AbstractEnemy implements IAttackedByLuis {

    public Goomba(int level, int attack, int defense, int healPoints) {
        super(level, attack, defense, healPoints, 0, "Goomba");
    }

    public void attack(IPlayer player) {
        if (this.isNotDead() && player.isNotDead()) {
            player.attackedByGoomba(this);
        }
    }

    @Override
    public void attackedByLuis(Luis luis, IAttacks attack) {
        luis.useFPtoAttack(attack);
        attack.hurts(this, this.damageToHurt(luis, attack));
    }

    @Override
    public void attackedByMarco(Marco marco, IAttacks attack) {
        marco.useFPtoAttack(attack);
        attack.hurts(this, this.damageToHurt(marco, attack));
    }
}
