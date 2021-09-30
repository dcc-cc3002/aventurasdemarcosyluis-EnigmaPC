package com.aventurasdemarcoyluis.interfaces;

/**
 * Interfaz para ataques. Estos pueden herir o no a ciertos enemigos.
 */
public interface IAttacks {
    int getFPCost();
    double getK();

    boolean hurtsBoo();
    boolean hurtsSpiny();
    void hurts(IEnemy enemy, double damageToHurt);
}
