package com.aventurasdemarcoyluis.attacks;

import com.aventurasdemarcoyluis.abstract_classes.AbstractAttackType;
import com.aventurasdemarcoyluis.interfaces.IEnemy;

public class JumpAttack extends AbstractAttackType {
    public JumpAttack() {
        this.FPCost = 1;
        this.K = 1;
    }

    @Override
    public boolean hurtsBoo() {
        return true;
    }

    @Override
    public boolean hurtsSpiny() {
        return false;
    }

    @Override
    public void hurts(IEnemy enemy, double damageToHurt) {
        enemy.getDamage(damageToHurt);
    }
}
