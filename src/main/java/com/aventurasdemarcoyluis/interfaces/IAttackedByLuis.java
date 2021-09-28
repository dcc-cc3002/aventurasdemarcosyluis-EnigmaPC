package com.aventurasdemarcoyluis.interfaces;

import com.aventurasdemarcoyluis.attacks.AttackType;
import com.aventurasdemarcoyluis.players.Luis;

public interface IAttackedByLuis {
    void luisAttack(Luis luis, AttackType attack);
}
