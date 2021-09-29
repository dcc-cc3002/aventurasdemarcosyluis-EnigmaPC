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
}
