package com.aventurasdemarcoyluis.players;

import com.aventurasdemarcoyluis.abstract_classes.AbstractPlayer;
import com.aventurasdemarcoyluis.enemies.Goomba;
import com.aventurasdemarcoyluis.enemies.Spiny;
import com.aventurasdemarcoyluis.interfaces.IAttacks;
import com.aventurasdemarcoyluis.interfaces.IEnemy;

public class Marco extends AbstractPlayer {
    public Marco(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints, "Marco");
    }

    public void attack(IEnemy enemy, IAttacks attack) {
        if (this.canAttack() && this.isNotDead() && enemy.isNotDead()) {
            enemy.attackedByMarco(this, attack);
        }
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