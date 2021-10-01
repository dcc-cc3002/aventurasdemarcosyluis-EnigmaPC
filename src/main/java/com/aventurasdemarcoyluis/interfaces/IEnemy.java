package com.aventurasdemarcoyluis.interfaces;

import com.aventurasdemarcoyluis.players.Marco;

/**
 * Interfaz para todos los enemigos. Todos los enemigos pueden ser dañados
 * por Marco.
 */
public interface IEnemy extends IEntities {
    void attackedByMarco(Marco marco, IAttacks attack);
}
