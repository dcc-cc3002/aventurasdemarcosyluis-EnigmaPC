package com.aventurasdemarcoyluis.attacks;

import com.aventurasdemarcoyluis.abstract_classes.AbstractAttackType;
import com.aventurasdemarcoyluis.interfaces.IEnemy;

/**
 * <b>Clase JumpAttack:</b> <br>
 * Modela el ataque Salto <br>
 * Se heredan los campos de AbstractAttackType <br>
 *
 * @author Andrea PC
 *
 * @see HammerAttack
 * @see AbstractAttackType
 */
public class JumpAttack extends AbstractAttackType {

    /**
     * <b>Constructor:</b> <br>
     * Se establecen los FPCost (Costos en FP de usar un ataque) como 1 y
     * la constante K del ataque como 1
     */
    public JumpAttack() {
        this.FPCost = 1;
        this.K = 1;
    }

    /**
     * Determina si el ataque con Salto puede dañar a Boo.
     * @return Verdadero (Puede dañar a Boo)
     */
    @Override
    public boolean hurtsBoo() {
        return true;
    }

    /**
     * Determina si el ataque con Salto puede dañar a Spiny.
     * @return Falso (No puede dañar a Spiny)
     */
    @Override
    public boolean hurtsSpiny() {
        return false;
    }

    /**
     * Permite que Salto le haga cierto daño a un enemigo
     * @param enemy Enemigo que recibe el daño
     * @param damageToHurt Daño que se le hace al enemigo
     */
    @Override
    public void hurts(IEnemy enemy, double damageToHurt) {
        enemy.getDamage(damageToHurt);
    }
}
