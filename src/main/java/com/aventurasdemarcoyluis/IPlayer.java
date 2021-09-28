package com.aventurasdemarcoyluis;

public interface IPlayer {
    int getHP();
    int getATK();
    int getLVL();
    int getMaxHP();
    void setHP(int newHP);
    void setInvincible(boolean b);
    int getFP();
    void setFP(int nuevoFP);
    void isAttacked(IEnemy enemy);
    void thornsSpiny(IPlayer player);
}
