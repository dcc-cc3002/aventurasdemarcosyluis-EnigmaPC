package com.aventurasdemarcoyluis.enemies;

import com.aventurasdemarcoyluis.interfaces.IAttacks;
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
        if (this.isDead()) {
            player.attackedBySpiny(this);
        }
    }

    public void attackedByLuis(Luis luis, IAttacks attack) {
        luis.attackCost(attack);
        if (attack.hurtsSpiny()) {
            attack.hurts(this, this.damageToHurt(luis, attack));
        } else {
            luis.getDamage(luis.damageThornsSpiny());
        }
    }

    @Override
    public void attackedByMarco(Marco marco, IAttacks attack) {
        marco.attackCost(attack);
        if (attack.hurtsSpiny()) {
            attack.hurts(this, this.damageToHurt(marco, attack));
        } else {
            marco.getDamage(marco.damageThornsSpiny());
        }
    }
}
