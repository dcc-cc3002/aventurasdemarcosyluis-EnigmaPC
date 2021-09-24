package com.aventurasdemarcoyluis;

public abstract class Entities {
    private int LVL;
    private int ATK;
    private int DEF;
    private int HP;
    private int FP;

    public abstract Entities(int level, int attack, int defense, int healthPoints, int fightPoints){
        this.LVL = level;
        this.ATK = attack;
        this.DEF = defense;
        this.HP = healthPoints;
        this.FP = fightPoints;
    }

    public abstract void attack();

    public int getLVL() {
        return LVL;
    }

    public void setLVL(int LVL) {
        this.LVL = LVL;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getFP() {
        return FP;
    }

    public void setFP(int FP) {
        this.FP = FP;
    }


}
