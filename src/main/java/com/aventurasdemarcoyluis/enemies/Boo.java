package com.aventurasdemarcoyluis.enemies;

import com.aventurasdemarcoyluis.interfaces.IAttacks;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;
import com.aventurasdemarcoyluis.abstract_classes.AbstractEnemy;

/**
 * <b>Clase abstracta Boo:</b> <br>
 * Modela el ENEMIGO BOO <br>
 * Se heredan los campos de la clase madre AbstractEnemy. <br>
 *
 * @author Andrea PC
 *
 * @see com.aventurasdemarcoyluis.enemies.Goomba
 * @see com.aventurasdemarcoyluis.enemies.Spiny
 * @see AbstractEnemy
 */
public class Boo extends AbstractEnemy {

    /**
     * <b>Constructor:</b> <br>
     * Modela un enemigo Boo. El nombre es Boo.
     * @param level Nivel de Boo
     * @param attack Poder de Ataque de Boo
     * @param defense Poder de Defensa de Boo
     * @param maxHealPoints Máxima cantidad de puntos de Vida de Boo
     */
    public Boo(int level, int attack, int defense, int maxHealPoints) {
        super(level, attack, defense, maxHealPoints,  "Boo");
    }

    /**
     * Permite a Boo atacar a Luis, solo si ninguno de los 2 está muerto.
     * @param luis Luis que está siendo atacado
     */
    public void attack(Luis luis) {
        if (this.isNotDead() && luis.isNotDead()) {
            luis.attackedByBoo(this);
        }
    }

    /**
     * Permite a Boo recibir daño de parte de Marco, si el ataque
     * utilizado le podría herir (Salto), si no, lo esquiva.
     * @param marco Marco atacante
     * @param attack Ataque que usa Marco
     */
    @Override
    public void attackedByMarco(Marco marco, IAttacks attack) {
        marco.useFPtoAttack(attack);
        if (attack.hurtsBoo()) {
            attack.hurts(this, this.damageToHurt(marco, attack));
        } else {
            this.dodge();
        }
    }
}
