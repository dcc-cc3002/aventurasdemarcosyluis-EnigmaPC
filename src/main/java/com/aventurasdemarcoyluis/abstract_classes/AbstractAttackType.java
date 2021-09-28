package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.interfaces.IAttack;

public abstract class AbstractAttackType implements IAttack {
    public int FPCost;
    public double K;

    public int getFPCost() {
        return FPCost;
    }

    public double getK() {
        return K;
    }
}
