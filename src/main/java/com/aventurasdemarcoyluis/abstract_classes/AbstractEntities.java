package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.interfaces.IEntities;

public abstract class AbstractEntities implements IEntities{
    private final int LVL;
    private final int ATK;
    private final int DEF;
    private final int maxHP;
    private final int maxFP;
    private int HP;
    private int FP;
    private final String name;

    public AbstractEntities(int level, int attack, int defense, int healPoints, int fightPoints, String name) {
        this.LVL = level;
        this.ATK = attack;
        this.DEF = defense;
        this.maxHP = healPoints;
        this.HP = healPoints;
        this.maxFP = fightPoints;
        this.FP = fightPoints;
        this.name = name;
    }

    public void dodge() {
    }

    public boolean isNotDead() {
        return this.getHP() != 0;
    }

    public void getDamage(double damageDeal) {
        int nuevoHP = (int) (this.getHP() - Math.round(damageDeal));
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

    public int getHP() {
        return this.HP;
    }

    public int getLVL() {
        return LVL;
    }

    public int getATK() {
        return ATK;
    }

    int getDEF() {
        return DEF;
    }

    public int getMaxHP() {
        return maxHP;
    }

    int getMaxFP() {
        return maxFP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntities that)) return false;

        if (!name.equals(that.name)) return false;
        if (getLVL() != that.getLVL()) return false;
        if (getATK() != that.getATK()) return false;
        if (getDEF() != that.getDEF()) return false;
        if (getMaxHP() != that.getMaxHP()) return false;
        if (getMaxFP() != that.getMaxFP()) return false;
        if (getHP() != that.getHP()) return false;
        return (getFP() == that.getFP());
    }

    @Override
    public int hashCode() {
        int result = getLVL();
        result = 31 * result + getATK();
        result = 31 * result + getDEF();
        result = 31 * result + getMaxHP();
        result = 31 * result + getMaxFP();
        result = 31 * result + getHP();
        result = 31 * result + getFP();
        result = 31 * result + name.hashCode();
        return result;
    }
}
