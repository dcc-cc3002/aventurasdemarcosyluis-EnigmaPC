package com.aventurasdemarcoyluis.attacks;

import com.aventurasdemarcoyluis.abstract_classes.AbstractAttackType;
import com.aventurasdemarcoyluis.enemies.Boo;
import com.aventurasdemarcoyluis.interfaces.IEnemy;

public class JumpAttack extends AbstractAttackType {
    public JumpAttack() {
        this.FPCost = 1;
        this.K = 1;
    }

    @Override
    public void hurtsBoo(Boo boo, double damageDeal) {

    }
}
