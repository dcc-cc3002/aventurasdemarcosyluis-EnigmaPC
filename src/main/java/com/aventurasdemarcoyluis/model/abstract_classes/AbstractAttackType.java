package com.aventurasdemarcoyluis.model.abstract_classes;

import com.aventurasdemarcoyluis.model.interfaces.IAttacks;

import java.util.Random;

/**
 * <b>Clase abstracta AttackType:</b> <br>
 * Modela los ataques que tendrán los jugadores <br>
 * Los campos que posee la clase son: <br>
 * <b>FPCost</b>: Costo en FP de ocupar un tipo de ataque <br>
 * <b>K</b>: Constante K de daño del tipo de ataque <br>
 *
 * @author Andrea PC
 *
 * @see com.aventurasdemarcoyluis.model.attacks.HammerAttack
 * @see com.aventurasdemarcoyluis.model.attacks.JumpAttack
 */
public abstract class AbstractAttackType implements IAttacks {
    // Campos
    protected int FPCost;
    protected double K;
    protected Random random;

    /**
     * Entrega el costo en FP de ocupar un tipo de ataque
     * @return Costo en FP de ocupar un tipo de ataque
     */
    public int getFPCost() {
        return FPCost;
    }

    /**
     * Entrega la constante K de daño del tipo de ataque
     * @return Constante K de daño del tipo de ataque
     */
    public double getK() {
        return K;
    }

    /**
     * Determina si un ataque con fallará o no.
     * Posee un 25 % de posibilidades de fallar.
     * @return Verdadero si el ataque falla, Falso si no.
     */
    @Override
    public boolean attackFailed() {
        int dado = random.nextInt(5);
        return dado == 0;
    }

    /**
     * Se establece la semilla para el ataque. Creado exclusivamente para testeo.
     * @param seed Semilla a plantar
     */
    public void setSeed(int seed) {
        random.setSeed(seed);
    }

    /**
     * Determina si un tipo de ataque es igual a otra.
     * Se comparan tanto el costo en FP como la constante K de daño.
     * @param obj Tipo de ataque a comparar
     * @return Si el tipo de ataque a comparar es el mismo tipo de ataque (this)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AbstractAttackType that)) return false;

        if (getFPCost() != that.getFPCost()) return false;
        return Double.compare(that.getK(), getK()) == 0;
    }

    /**
     * Entrega el hashCode de un tipo de ataque
     * @return hashCode de un tipo de ataque
     */
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
