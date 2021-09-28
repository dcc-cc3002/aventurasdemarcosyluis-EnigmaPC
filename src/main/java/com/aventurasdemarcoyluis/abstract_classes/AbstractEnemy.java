package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.attacks.AttackType;
import com.aventurasdemarcoyluis.interfaces.IEnemy;
import com.aventurasdemarcoyluis.interfaces.IPlayer;
public abstract class AbstractEnemy extends AbstractEntities implements IEnemy {

    public AbstractEnemy(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public double getK() {
        return K;
    }

    public void isAttacked(IPlayer player, AttackType attack) {
        double damageDeal = attack.getK()*player.getATK()*((double) player.getLVL()/this.getDEF());
        if (attack.equals(AttackType.MARTILLO)) {
            int dado = (int) (Math.random()*4);
            if (dado != 1) {
                damageDeal = 0;
                this.dodge();
            }
        }
        int nuevoHP = (int) (this.getHP() - damageDeal);
        this.setHP(nuevoHP);
        int nuevoFP = player.getFP() - attack.getFPCost();
        player.setFP(nuevoFP);
    }
}
