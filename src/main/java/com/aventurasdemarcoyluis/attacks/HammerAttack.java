package com.aventurasdemarcoyluis.attacks;

import com.aventurasdemarcoyluis.abstract_classes.AbstractAttackType;
import com.aventurasdemarcoyluis.interfaces.IEnemy;

public class HammerAttack extends AbstractAttackType {
    public HammerAttack() {
        this.FPCost = 2;
        this.K = 1.5;
    }


    public boolean attackFailed() {
        int dado = (int) (Math.random()*4);
        return dado != 0;
    }

    @Override
    public boolean hurtsBoo() {
        return false;
    }

    @Override
    public boolean hurtsSpiny() {
        return true;
    }

    @Override
    public void hurts(IEnemy enemy, double damageToHurt) {
        if (attackFailed()) {
            enemy.dodge();
        } else {
            enemy.getDamage(damageToHurt);
        }
    }
}
