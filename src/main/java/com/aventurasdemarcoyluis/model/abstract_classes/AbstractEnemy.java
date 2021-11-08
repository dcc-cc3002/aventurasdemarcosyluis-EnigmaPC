package com.aventurasdemarcoyluis.model.abstract_classes;

import com.aventurasdemarcoyluis.model.interfaces.IAttacks;
import com.aventurasdemarcoyluis.model.interfaces.IEnemy;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;

/**
 * <b>Clase abstracta Enemy:</b> <br>
 * Modela el tipo de entidad ENEMIGO <br>
 * Se heredan los campos de la clase madre AbstractEntities. <br>
 *
 * @author Andrea PC
 *
 * @see com.aventurasdemarcoyluis.model.enemies.Boo
 * @see com.aventurasdemarcoyluis.model.enemies.Goomba
 * @see com.aventurasdemarcoyluis.model.enemies.Spiny
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
     * Transforma las características del enemigo a string
     * @return String con los datos del enemigo
     */
    public String enemyToString() {
        return this.name+" | nivel: "+this.LVL+", ataque: "+this.ATK+", defensa: "+this.DEF+", vida: "+this.getHP();
    }

    /**
     * Retorna un valor entero aleatorio entre [0,1]
     */
    public int roll() {
        return random.nextInt(2);
    }

    /**
     * Determina si la entidad es un jugador
     * @return False
     */
    public boolean isPlayer() {
        return false;
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
