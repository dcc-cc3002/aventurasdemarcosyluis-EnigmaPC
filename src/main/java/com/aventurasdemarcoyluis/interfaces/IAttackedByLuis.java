package com.aventurasdemarcoyluis.interfaces;

import com.aventurasdemarcoyluis.attacks.AttackType;
import com.aventurasdemarcoyluis.players.Luis;

public interface IAttackedByLuis {
    void attackedByLuis(Luis luis, AttackType attack);
}
