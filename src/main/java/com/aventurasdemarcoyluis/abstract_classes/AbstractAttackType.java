package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.interfaces.IAttacks;

/**
 * <b>Clase abstracta AttackType:</b> <br>
 * Modela los ataques que tendrán los jugadores <br>
 * Los campos que posee la clase son: <br>
 * <b>FPCost</b>: Costo en FP de ocupar un tipo de ataque <br>
 * <b>K</b>: Constante K de daño del tipo de ataque <br>
 *
 * @author Andrea PC
 */
public abstract class AbstractAttackType implements IAttacks {
    // Campos
    public int FPCost;
    public double K;

    /**
     * Entrega el costo en FP de ocupar un tipo de ataque
     * @return Costo en FP de ocupar un tipo de ataque
     */
    public int getFPCost() {
        return FPCost;
    }

    /**
     * 
     * @return
     */
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
