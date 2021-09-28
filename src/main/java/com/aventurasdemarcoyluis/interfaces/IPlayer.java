package com.aventurasdemarcoyluis.interfaces;

import com.aventurasdemarcoyluis.enemies.Goomba;
import com.aventurasdemarcoyluis.enemies.Spiny;

public interface IPlayer {
    int getHP();
    int getATK();
    int getLVL();
    int getFP();

    void setInvincible(boolean b);
    void setFP(int nuevoFP);
    void useHoneySyrup();
    void useRedMushroom();
    void useStar();

    void attackedByGoomba(Goomba goomba);
    void attackedBySpiny(Spiny spiny);
}
