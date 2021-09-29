package com.aventurasdemarcoyluis.interfaces;

import com.aventurasdemarcoyluis.players.Marco;

public interface IEnemy extends IEntities {
    void dodge();
    void getDamage(double damageToHurt);

    void attackedByMarco(Marco marco, IAttacks attack);
}
