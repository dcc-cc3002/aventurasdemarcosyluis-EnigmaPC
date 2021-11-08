package com.aventurasdemarcoyluis.model.enemies;

import com.aventurasdemarcoyluis.model.interfaces.IAttacks;
import com.aventurasdemarcoyluis.model.interfaces.IAttackedByLuis;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;
import com.aventurasdemarcoyluis.model.abstract_classes.AbstractEnemy;
import com.aventurasdemarcoyluis.model.players.Luis;
import com.aventurasdemarcoyluis.model.players.Marco;

/**
 * <b>Clase Spiny:</b> <br>
 * Modela el ENEMIGO SPINY <br>
 * Se heredan los campos de la clase madre AbstractEnemy. <br>
 *
 * @author Andrea PC
 *
 * @see com.aventurasdemarcoyluis.model.enemies.Boo
 * @see com.aventurasdemarcoyluis.model.enemies.Goomba
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
        } else {
            System.out.println("Spiny no puede atacar");
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
        if (attack.hurtsSpiny()) {
            if (!attack.attackFailed()) {
                System.out.println("Luis usa Martillo y le hace "+(int) Math.round(this.damageToHurt(luis, attack))
                        +" de daño a Spiny");
                this.getDamage(this.damageToHurt(luis, attack));
            } else {
                System.out.println("Luis usa Martillo, pero ha fallado");
            }
        } else {
            System.out.println("Spiny se protege con sus pinchos");
            System.out.println("Spiny le hace "+(int) Math.round(luis.damageThornsSpiny())+" de daño a Luis con" +
                    " sus pinchos");
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
        if (attack.hurtsSpiny()) {
            if (!attack.attackFailed()) {
                System.out.println("Marco usa Martillo y le hace "+(int) Math.round(this.damageToHurt(marco, attack))
                        +" de daño a Spiny");
                this.getDamage(this.damageToHurt(marco, attack));
            } else {
                System.out.println("Marco usa Martillo, pero ha fallado");
            }
        } else {
            System.out.println("Spiny se protege con sus pinchos");
            System.out.println("Spiny le hace "+(int) Math.round(marco.damageThornsSpiny())+" de daño a Marco con" +
                    " sus pinchos");
            marco.getDamage(marco.damageThornsSpiny());
        }
    }

    /**
     * Si es Boo entrega Verdadero
     * @return False
     */
    @Override
    public boolean isBoo() {
        return false;
    }
}
