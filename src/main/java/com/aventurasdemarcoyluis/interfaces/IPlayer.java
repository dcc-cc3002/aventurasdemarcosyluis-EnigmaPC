package com.aventurasdemarcoyluis.interfaces;

import com.aventurasdemarcoyluis.enemies.Goomba;
import com.aventurasdemarcoyluis.enemies.Spiny;

/**
 * Interfaz para los Players. Todos los jugadores pueden ser atacados
 * tanto por Goomba como por Spiny. También pueden utilizar los items Honey Syrup,
 * Red Mushroom y Star.
 */
public interface IPlayer extends IEntities {
    void useHoneySyrup();
    void useRedMushroom();
    String getName();

    void attackedByGoomba(Goomba goomba);
    void attackedBySpiny(Spiny spiny);
}
