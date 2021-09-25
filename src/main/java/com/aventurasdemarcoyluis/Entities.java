package com.aventurasdemarcoyluis;

public abstract class Entities implements IEntities {
    private int LVL;
    private int ATK;
    private int DEF;
    private int maxHP;
    private int FP;
    private int HP;

    public Entities(int level, int attack, int defense, int healPoints, int fightPoints) {
        this.LVL = level;
        this.ATK = attack;
        this.DEF = defense;
        this.maxHP = healPoints;
        this.HP = healPoints;
        this.FP = fightPoints;
    }

    public abstract void attack(IEntities entities);

    public void setHP(int nuevoHP) {
        if (nuevoHP <= 0) {
            this.HP = 0;
        } else {
            this.HP = nuevoHP;
        }
    }

    public int getHP() {
        return this.HP;
    }

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

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int HP) {
        this.maxHP = HP;
    }

    public int getFP() {
        return FP;
    }

    public void setFP(int FP) {
        this.FP = FP;
    }
}
