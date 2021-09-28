package com.aventurasdemarcoyluis.interfaces;

public interface IPlayer {
    int getHP();
    int getATK();
    int getLVL();
    int getFP();

    void setInvincible(boolean b);
    void setFP(int nuevoFP);
    void isAttacked(IEnemy enemy);
    void thornsSpiny(IPlayer player);
    void useHoneySyrup();
    void useRedMushroom();
    void useStar();
}
