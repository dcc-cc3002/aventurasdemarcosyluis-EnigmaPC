package com.aventurasdemarcoyluis.attacks;

import com.aventurasdemarcoyluis.abstract_classes.AbstractAttackType;
import com.aventurasdemarcoyluis.enemies.Boo;
import com.aventurasdemarcoyluis.interfaces.IEnemy;

public class HammerAttack extends AbstractAttackType {
    public HammerAttack() {
        this.FPCost = 2;
        this.K = 1.5;
    }

    @Override
    public void hurtsBoo(Boo boo, double damageDeal) {
        boo.dodge();
    }
}
