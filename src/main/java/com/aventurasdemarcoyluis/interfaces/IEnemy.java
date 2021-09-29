package com.aventurasdemarcoyluis.interfaces;

import com.aventurasdemarcoyluis.players.Marco;

public interface IEnemy {
    int getATK();
    int getLVL();
    void dodge();
    void getDamage(double damageToHurt);

    void attackedByMarco(Marco marco, IAttacks attack);
}
