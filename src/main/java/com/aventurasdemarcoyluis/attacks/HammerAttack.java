package com.aventurasdemarcoyluis.attacks;

import com.aventurasdemarcoyluis.abstract_classes.AbstractAttackType;

/**
 * <b>Clase HammerAttack:</b> <br>
 * Modela el ataque Martillo <br>
 * Se heredan los campos de AbstractAttackType <br>
 *
 * @author Andrea PC
 *
 * @see JumpAttack
 * @see AbstractAttackType
 */
public class HammerAttack extends AbstractAttackType {

    /**
     * <b>Constructor:</b> <br>
     * Se establecen los FPCost (Costos en FP de usar un ataque) como 2 y
     * la constante K del ataque como 1.5
     */
    public HammerAttack() {
        this.FPCost = 2;
        this.K = 1.5;
    }

    /**
     * Determina si el ataque con Martillo puede dañar a Boo.
     * @return Falso (No puede dañar a Boo)
     */
    @Override
    public boolean hurtsBoo() {
        return false;
    }

    /**
     * Determina si el ataque con Martillo puede dañar a Spiny.
     * @return Verdadero (Puede dañar a Spiny)
     */
    @Override
    public boolean hurtsSpiny() {
        return true;
    }
}
