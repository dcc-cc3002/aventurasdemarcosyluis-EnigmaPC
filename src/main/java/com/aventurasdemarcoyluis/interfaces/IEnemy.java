package com.aventurasdemarcoyluis.interfaces;

import com.aventurasdemarcoyluis.players.Marco;

public interface IEnemy {
    void attackedByMarco(Marco marco, IAttack attack);
}
