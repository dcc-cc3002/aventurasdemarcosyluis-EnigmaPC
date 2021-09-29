package com.aventurasdemarcoyluis.interfaces;

import com.aventurasdemarcoyluis.players.Luis;

public interface IAttackedByLuis extends IEntities {
    void attackedByLuis(Luis luis, IAttacks attack);
}
