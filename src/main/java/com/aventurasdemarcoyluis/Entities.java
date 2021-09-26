package com.aventurasdemarcoyluis;

public abstract class Entities implements IEntities {
    private int LVL;
    private int ATK;
    private int DEF;
    private int maxHP;
    private int maxFP;
    private int HP;
    private int FP;

    public Entities(int level, int attack, int defense, int healPoints, int fightPoints) {
        this.LVL = level;
        this.ATK = attack;
        this.DEF = defense;
        this.maxHP = healPoints;
        this.HP = healPoints;
        this.maxFP = fightPoints;
        this.FP = fightPoints;
    }

    protected boolean isDead() {
        if (this.getHP() == 0) {
            return true;
        } else {
            return false;
        }
    }

    protected void setFP(int nuevoFP) {
        if (nuevoFP <= 0) {
            this.FP = 0;
        } else {
            if (nuevoFP > this.getMaxFP()) {
                this.FP = this.getMaxFP();
            } else {
                this.FP = nuevoFP;
            }
        }
    }

    protected int getFP() {
        return this.FP;
    }

    public void setHP(int nuevoHP) {
        if (nuevoHP <= 0) {
            this.HP = 0;
        } else {
            if (nuevoHP > this.getMaxHP()) {
                this.HP = this.getMaxHP();
            } else {
                this.HP = nuevoHP;
            }
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

    public void setMaxHP(int mHP) {
        this.maxHP = mHP;
    }

    public int getMaxFP() {
        return maxFP;
    }

    public void setMaxFP(int mFP) {
        this.maxFP = mFP;
    }
}
