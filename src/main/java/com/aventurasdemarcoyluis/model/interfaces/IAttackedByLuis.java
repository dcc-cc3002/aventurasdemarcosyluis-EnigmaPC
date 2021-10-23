package com.aventurasdemarcoyluis.model.interfaces;

import com.aventurasdemarcoyluis.model.players.Luis;

/**
 * Interfaz para los enemigos (Goomba y Spiny) que son atacados por Luis
 */
public interface IAttackedByLuis extends IEntities {
    void attackedByLuis(Luis luis, IAttacks attack);
}
