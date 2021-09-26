package com.aventurasdemarcoyluis;

/**
 * Enumerator that represents de type of attack that a
 * player can choose
 *
 */
public enum AttackType {
    MARTILLO(2,1.5),
    SALTO(1,1);

    public int FPCost;
    public double K;

    AttackType(int FPCost, double K) {
        this.FPCost = FPCost;
        this.K = K;
    }

    int getFPCost() {
        return FPCost;
    }

    double getK() {
        return K;
    }
}
