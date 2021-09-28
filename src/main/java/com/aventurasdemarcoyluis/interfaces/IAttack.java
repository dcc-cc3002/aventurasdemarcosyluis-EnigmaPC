package com.aventurasdemarcoyluis.interfaces;

import com.aventurasdemarcoyluis.enemies.Boo;

public interface IAttack {
    int getFPCost();
    double getK();

    void hurtsBoo(Boo boo, double damageDeal);
}
