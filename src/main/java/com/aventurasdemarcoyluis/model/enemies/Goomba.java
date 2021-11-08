package com.aventurasdemarcoyluis.model.enemies;

import com.aventurasdemarcoyluis.model.interfaces.IAttacks;
import com.aventurasdemarcoyluis.model.interfaces.IAttackedByLuis;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;
import com.aventurasdemarcoyluis.model.abstract_classes.AbstractEnemy;
import com.aventurasdemarcoyluis.model.players.Luis;
import com.aventurasdemarcoyluis.model.players.Marco;

/**
 * <b>Clase Goomba:</b> <br>
 * Modela el ENEMIGO GOOMBA <br>
 * Se heredan los campos de la clase madre AbstractEnemy. <br>
 *
 * @author Andrea PC
 *
 * @see com.aventurasdemarcoyluis.model.enemies.Boo
 * @see com.aventurasdemarcoyluis.model.enemies.Spiny
 * @see AbstractEnemy
 */
public class Goomba extends AbstractEnemy implements IAttackedByLuis {

    /**
     * <b>Constructor:</b> <br>
     * Modela un enemigo Goomba. El nombre es Goomba.
     * @param level Nivel de Goomba
     * @param attack Poder de Ataque de Goomba
     * @param defense Poder de Defensa de Goomba
     * @param maxHealPoints Máxima cantidad de puntos de Vida de Goomba
     */
    public Goomba(int level, int attack, int defense, int maxHealPoints) {
        super(level, attack, defense, maxHealPoints, "Goomba");
    }

    /**
     * Permite a Goomba atacar a un jugador cualquiera. Solo si
     * ni el jugador ni Goomba están muertos.
     * @param player Jugador que está siendo atacado
     */
    public void attack(IPlayer player) {
        if (this.isNotDead() && player.isNotDead()) {
            player.attackedByGoomba(this);
        } else {
            System.out.println("Goomba no puede atacar");
        }
    }

    /**
     * Permite a Goomba recibir daño de parte de Luis.
     * @param luis Luis atacante
     * @param attack Ataque que usa Luis
     */
    @Override
    public void attackedByLuis(Luis luis, IAttacks attack) {
        if (attack.hurtsSpiny()) { // Entonces el ataque es Martillo
            if (!attack.attackFailed()) {
                System.out.println("Luis usa Martillo y le hace "+(int) Math.round(this.damageToHurt(luis, attack))
                +" de daño a Goomba");
                this.getDamage(this.damageToHurt(luis, attack));
            } else {
                System.out.println("Luis usa Martillo, pero ha fallado");
            }
        } else {
            System.out.println("Luis usa Salto y le hace "+(int) Math.round(this.damageToHurt(luis, attack))
                    +" de daño a Goomba");
            this.getDamage(this.damageToHurt(luis, attack));
        }
    }

    /**
     * Permite a Goomba recibir daño de parte de Marco.
     * @param marco Marco atacante
     * @param attack Ataque que usa Marco
     */
    @Override
    public void attackedByMarco(Marco marco, IAttacks attack) {
        if (attack.hurtsSpiny()) { // Entonces el ataque es Martillo
            if (!attack.attackFailed()) {
                System.out.println("Marco usa Martillo y le hace "+(int) Math.round(this.damageToHurt(marco, attack))
                        +" de daño a Goomba");
                this.getDamage(this.damageToHurt(marco, attack));
            } else {
                System.out.println("Marco usa Martillo, pero ha fallado");
            }
        } else {
            System.out.println("Marco usa Salto y le hace "+(int) Math.round(this.damageToHurt(marco, attack))
                    +" de daño a Goomba");
            this.getDamage(this.damageToHurt(marco, attack));
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
