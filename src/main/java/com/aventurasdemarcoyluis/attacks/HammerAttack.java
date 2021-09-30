package com.aventurasdemarcoyluis.attacks;

import com.aventurasdemarcoyluis.abstract_classes.AbstractAttackType;
import com.aventurasdemarcoyluis.interfaces.IEnemy;

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
     * Determina si el ataque con Martillo fallará o no.
     * Posee un 25 % de posibilidades de fallar.
     * @return Verdadero si el ataque falla, Falso si no.
     */
    public boolean attackFailed() {
        int dado = (int) (Math.random()*4);
        return dado == 0;
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

    /**
     * Permite a un enemigo recibir daño al utilizar Martillo si este no falla.
     * @param enemy Enemigo que recibe el daño
     * @param damageToHurt Daño que se le hace al enemigo
     */
    @Override
    public void hurts(IEnemy enemy, double damageToHurt) {
        if (attackFailed()) {
            enemy.dodge();
        } else {
            enemy.getDamage(damageToHurt);
        }
    }
}
