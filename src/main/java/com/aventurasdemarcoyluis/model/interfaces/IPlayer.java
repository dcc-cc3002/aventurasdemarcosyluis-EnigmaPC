package com.aventurasdemarcoyluis.model.interfaces;

import com.aventurasdemarcoyluis.model.enemies.Goomba;
import com.aventurasdemarcoyluis.model.enemies.Spiny;
import com.aventurasdemarcoyluis.model.items.Baul;

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
    void useItem(IObject item, Baul baul);
    void levelUP();
    int getMaxHP();
    void setHP(int maxHP);
}
