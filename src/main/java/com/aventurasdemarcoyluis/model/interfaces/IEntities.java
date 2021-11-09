package com.aventurasdemarcoyluis.model.interfaces;

/**
 * Interfaz para las entidades.
 */
public interface IEntities {
    int getATK();
    int getLVL();
    boolean isNotDead();

    boolean isPlayer();

    String getName();

    int getDEF();

    int getHP();
}
