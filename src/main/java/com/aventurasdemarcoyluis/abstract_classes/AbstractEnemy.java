package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.interfaces.IAttacks;
import com.aventurasdemarcoyluis.interfaces.IEnemy;
import com.aventurasdemarcoyluis.interfaces.IPlayer;

public abstract class AbstractEnemy extends AbstractEntities implements IEnemy {

    public AbstractEnemy(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public double damageToHurt(IPlayer player, IAttacks attack) {
        return attack.getK()*this.preDamage(player);
    }
}
