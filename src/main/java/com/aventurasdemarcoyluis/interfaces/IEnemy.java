package com.aventurasdemarcoyluis.interfaces;

import com.aventurasdemarcoyluis.attacks.AttackType;
import com.aventurasdemarcoyluis.players.Marco;

public interface IEnemy {
    double getK();
    int getATK();
    int getLVL();

    void marcoAttack(Marco marco, AttackType attack);
}
