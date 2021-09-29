package com.aventurasdemarcoyluis.interfaces;

public interface IAttacks {
    int getFPCost();
    double getK();

    boolean hurtsBoo();
    boolean hurtsSpiny();
    void hurts(IEnemy enemy, double damageToHurt);
}
