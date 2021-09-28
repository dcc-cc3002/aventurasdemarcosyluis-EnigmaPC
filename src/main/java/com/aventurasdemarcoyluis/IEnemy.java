package com.aventurasdemarcoyluis;

public interface IEnemy {
    double getK();

    int getATK();

    int getLVL();

    void playerAttack(IPlayer player, AttackType attack);
}
