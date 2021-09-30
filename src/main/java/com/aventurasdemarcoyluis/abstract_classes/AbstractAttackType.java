package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.interfaces.IAttacks;

public abstract class AbstractAttackType implements IAttacks {
    public int FPCost;
    public double K;

    public int getFPCost() {
        return FPCost;
    }

    public double getK() {
        return K;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractAttackType)) return false;

        AbstractAttackType that = (AbstractAttackType) o;

        if (getFPCost() != that.getFPCost()) return false;
        return Double.compare(that.getK(), getK()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getFPCost();
        temp = Double.doubleToLongBits(getK());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
