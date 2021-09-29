package com.aventurasdemarcoyluis.interfaces;

import com.aventurasdemarcoyluis.enemies.Goomba;
import com.aventurasdemarcoyluis.enemies.Spiny;

public interface IPlayer {
    int getATK();
    int getLVL();

    void setInvincible(boolean b);
    void useHoneySyrup();
    void useRedMushroom();
    void useStar();

    void attackedByGoomba(Goomba goomba);
    void attackedBySpiny(Spiny spiny);
}
