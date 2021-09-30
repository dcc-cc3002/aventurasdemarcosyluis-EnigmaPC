package com.aventurasdemarcoyluis.enemies;

import com.aventurasdemarcoyluis.interfaces.IAttacks;
import com.aventurasdemarcoyluis.interfaces.IAttackedByLuis;
import com.aventurasdemarcoyluis.interfaces.IPlayer;
import com.aventurasdemarcoyluis.abstract_classes.AbstractEnemy;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;

public class Spiny extends AbstractEnemy implements IAttackedByLuis {

    public Spiny(int level, int attack, int defense, int healPoints) {
        super(level, attack, defense, healPoints, 0, "Spiny");
    }

    public void attack(IPlayer player) {
        if (this.isNotDead() && player.isNotDead()) {
            player.attackedBySpiny(this);
        }
    }

    public void attackedByLuis(Luis luis, IAttacks attack) {
        luis.useFPtoAttack(attack);
        if (attack.hurtsSpiny()) {
            attack.hurts(this, this.damageToHurt(luis, attack));
        } else {
            luis.getDamage(luis.damageThornsSpiny());
        }
    }

    @Override
    public void attackedByMarco(Marco marco, IAttacks attack) {
        marco.useFPtoAttack(attack);
        if (attack.hurtsSpiny()) {
            attack.hurts(this, this.damageToHurt(marco, attack));
        } else {
            marco.getDamage(marco.damageThornsSpiny());
        }
    }
}
