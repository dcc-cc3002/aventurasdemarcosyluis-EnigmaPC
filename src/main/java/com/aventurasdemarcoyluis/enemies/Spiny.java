package com.aventurasdemarcoyluis.enemies;

import com.aventurasdemarcoyluis.interfaces.IAttacks;
import com.aventurasdemarcoyluis.interfaces.IAttackedByLuis;
import com.aventurasdemarcoyluis.interfaces.IPlayer;
import com.aventurasdemarcoyluis.abstract_classes.AbstractEnemy;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;

/**
 * <b>Clase abstracta Spiny:</b> <br>
 * Modela el ENEMIGO SPINY <br>
 * Se heredan los campos de la clase madre AbstractEnemy. <br>
 *
 * @author Andrea PC
 *
 * @see com.aventurasdemarcoyluis.enemies.Boo
 * @see com.aventurasdemarcoyluis.enemies.Goomba
 * @see AbstractEnemy
 */
public class Spiny extends AbstractEnemy implements IAttackedByLuis {

    /**
     * <b>Constructor:</b> <br>
     * Modela un enemigo Spiny. El nombre es Spiny.
     * @param level Nivel de Spiny
     * @param attack Poder de Ataque de Spiny
     * @param defense Poder de Defensa de Spiny
     * @param maxHealPoints Máxima cantidad de puntos de Vida de Spiny
     */
    public Spiny(int level, int attack, int defense, int maxHealPoints) {
        super(level, attack, defense, maxHealPoints, "Spiny");
    }

    /**
     * Permite a Spiny atacar a un jugador cualquiera. Solo si
     * ni el jugador ni Spiny están muertos.
     * @param player Jugador que está siendo atacado
     */
    public void attack(IPlayer player) {
        if (this.isNotDead() && player.isNotDead()) {
            player.attackedBySpiny(this);
        }
    }

    /**
     * Permite a Spiny recibir daño de parte de Luis, si el ataque
     * utilizado le podría herir (Martillo), si no, le hace daño a Luis con sus pinchos.
     * @param luis Luis atacante
     * @param attack Ataque que usa Luis
     */
    @Override
    public void attackedByLuis(Luis luis, IAttacks attack) {
        luis.useFPtoAttack(attack);
        if (attack.hurtsSpiny()) {
            attack.hurts(this, this.damageToHurt(luis, attack));
        } else {
            luis.getDamage(luis.damageThornsSpiny());
        }
    }

    /**
     * Permite a Spiny recibir daño de parte de Marco, si el ataque
     * utilizado le podría herir (Martillo), si no, le hace daño a Marco con sus pinchos.
     * @param marco Marco atacante
     * @param attack Ataque que usa Marco
     */
    @Override
    public void attackedByMarco(Marco marco, IAttacks attack) {
        marco.useFPtoAttack(attack);
        if (attack.hurtsSpiny()) {
            attack.hurts(this, this.damageToHurt(marco, attack));
        } else {
            marco.getDamage(marco.damageThornsSpiny());
        }
    }
}
