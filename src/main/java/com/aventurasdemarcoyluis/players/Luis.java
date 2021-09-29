package com.aventurasdemarcoyluis.players;

import com.aventurasdemarcoyluis.abstract_classes.AbstractPlayer;

import com.aventurasdemarcoyluis.enemies.Boo;
import com.aventurasdemarcoyluis.enemies.Goomba;
import com.aventurasdemarcoyluis.enemies.Spiny;
import com.aventurasdemarcoyluis.interfaces.IAttacks;
import com.aventurasdemarcoyluis.interfaces.IAttackedByBoo;
import com.aventurasdemarcoyluis.interfaces.IAttackedByLuis;


public class Luis extends AbstractPlayer implements IAttackedByBoo {

    public Luis(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(IAttackedByLuis enemy, IAttacks attack) {
        enemy.attackedByLuis(this, attack);
    }

    @Override
    public void attackedByBoo(Boo boo) {
        double damageDeal = this.enemyDoDamage(boo);
        this.getDamage(damageDeal);
    }

    @Override
    public void attackedByGoomba(Goomba goomba) {
        double damageDeal = this.enemyDoDamage(goomba);
        this.getDamage(damageDeal);
    }

    @Override
    public void attackedBySpiny(Spiny spiny) {
        double damageDeal = this.enemyDoDamage(spiny);
        this.getDamage(damageDeal);
    }
}
