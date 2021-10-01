package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.interfaces.IAttacks;
import com.aventurasdemarcoyluis.interfaces.IEnemy;
import com.aventurasdemarcoyluis.interfaces.IPlayer;

/**
 * <b>Clase abstracta Enemy:</b> <br>
 * Modela el tipo de entidad ENEMIGO <br>
 * Se heredan los campos de la clase madre AbstractEntities. <br>
 *
 * @author Andrea PC
 *
 * @see com.aventurasdemarcoyluis.enemies.Boo
 * @see com.aventurasdemarcoyluis.enemies.Goomba
 * @see com.aventurasdemarcoyluis.enemies.Spiny
 */
public abstract class AbstractEnemy extends AbstractEntities implements IEnemy {

    /**
     * <b>Constructor:</b> <br>
     * Modela un enemigo.
     * Los enemigos no tienen Máxima cantidad de FP.
     * @param level Nivel del enemigo
     * @param attack Poder de Ataque del enemigo
     * @param defense Poder de Defensa del enemigo
     * @param maxHealPoints Máxima cantidad de puntos de Vida del enemigo
     * @param name Nombre del enemigo
     */
    public AbstractEnemy(int level, int attack, int defense, int maxHealPoints, String name) {
        super(level, attack, defense, maxHealPoints, 0, name);
    }

    /**
     * Entrega la cantidad de daño que un jugador podría hacerle a un enemigo (this) con
     * cierto tipo de ataque. Calculado como
     * (Constante K del ataque)*(ATK del Jugador)*((LVL del Jugador)/(DEF del Enemigo))
     * @param player Jugador atacante
     * @param attack Ataque utilizado por el jugador
     * @return Cantidad de daño que un jugador podría hacer a un enemigo con cierto ataque.
     */
    protected double damageToHurt(IPlayer player, IAttacks attack) {
        return attack.getK()*this.preDamage(player);
    }
}
