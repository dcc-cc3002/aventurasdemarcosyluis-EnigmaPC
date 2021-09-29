package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.interfaces.IEntities;

public abstract class AbstractEntities implements IEntities{
    private int LVL;
    private int ATK;
    private int DEF;
    private int maxHP;
    private int maxFP;
    private int HP;
    private int FP;

    public AbstractEntities(int level, int attack, int defense, int healPoints, int fightPoints) {
        this.LVL = level;
        this.ATK = attack;
        this.DEF = defense;
        this.maxHP = healPoints;
        this.HP = healPoints;
        this.maxFP = fightPoints;
        this.FP = fightPoints;
    }

    public void dodge() {

    }

    public boolean isNotDead() {
        return this.getHP() != 0;
    }

    protected boolean canAttack() {
        return this.getFP() != 0;
    }

    public void getDamage(double damageDeal) {
        int nuevoHP = (int) (this.getHP() - damageDeal);
        this.setHP(nuevoHP);
    }

    public double preDamage(IEntities entities) {
        return entities.getATK()*((double) entities.getLVL()/this.getDEF());
    }

    void setFP(int nuevoFP) {
        if (nuevoFP <= 0) {
            this.FP = 0;
        } else {
            this.FP = Math.min(nuevoFP, this.getMaxFP());
        }
    }

    int getFP() {
        return this.FP;
    }

    void setHP(int nuevoHP) {
        if (nuevoHP <= 0) {
            this.HP = 0;
        } else {
            this.HP = Math.min(nuevoHP, this.getMaxHP());
        }
    }

    int getHP() {
        return this.HP;
    }

    public int getLVL() {
        return LVL;
    }

    void setLVL(int LVL) {
        this.LVL = LVL;
    }

    public int getATK() {
        return ATK;
    }

    void setATK(int ATK) {
        this.ATK = ATK;
    }

    int getDEF() {
        return DEF;
    }

    void setDEF(int DEF) {
        this.DEF = DEF;
    }

    int getMaxHP() {
        return maxHP;
    }

    void setMaxHP(int mHP) {
        this.maxHP = mHP;
    }

    int getMaxFP() {
        return maxFP;
    }

    void setMaxFP(int mFP) {
        this.maxFP = mFP;
    }
}
