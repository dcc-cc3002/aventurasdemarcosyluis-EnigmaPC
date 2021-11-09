package com.aventurasdemarcoyluis.model.abstract_classes;

import com.aventurasdemarcoyluis.model.interfaces.IAttacks;
import com.aventurasdemarcoyluis.model.interfaces.IEnemy;
import com.aventurasdemarcoyluis.model.interfaces.IObject;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;
import com.aventurasdemarcoyluis.model.items.Baul;


/**
 * <b>Clase abstracta Player:</b> <br>
 * Modela el tipo de entidad JUGADOR <br>
 * Se heredan los campos de la clase madre AbstractEntities.
 *
 * @author Andrea PC
 *
 * @see com.aventurasdemarcoyluis.model.players.Marco
 * @see com.aventurasdemarcoyluis.model.players.Luis
 * */
public abstract class AbstractPlayer extends AbstractEntities implements IPlayer {
    /**
     * <b>Constructor:</b> <br>
     * Modela un jugador
     * @param level Nivel del enemigo
     * @param attack Poder de Ataque del enemigo
     * @param defense Poder de Defensa del enemigo
     * @param maxHealPoints Máxima cantidad de puntos de Vida del enemigo
     * @param maxFightPoints Máxima cantidad de puntos de Ataque del enemigo
     * @param name Nombre del enemigo
     */
    public AbstractPlayer(int level, int attack, int defense, int maxHealPoints, int maxFightPoints, String name) {
        super(level, attack, defense, maxHealPoints, maxFightPoints, name);
    }

    /**
     * Transforma las características del player a string
     * @return String con los datos del player
     */
    public String playerToString() {
        return this.name+" | nivel: "+this.LVL+", ataque: "+this.ATK+", defensa: "+this.DEF+", vida: "+
                this.getHP()+", fp: "+this.getFP();
    }

    /**
     * Determina si la entidad es un jugador
     * @return Verdadero
     */
    public boolean isPlayer() {
        return true;
    }

    /**
     * Simula la subida de nivel de un player.
     */
    public void levelUP() {
        this.LVL++;
        this.ATK = (int) Math.round(this.ATK*(1.15));
        this.DEF = (int) Math.round(this.DEF*(1.15));
        this.maxFP = (int) Math.round(this.maxFP*(1.15));
        this.maxHP = (int) Math.round(this.maxHP*(1.15));
    }

    /**
     * Determina si un jugador tiene suficientes FP para atacar con cierto ataque.
     * Para atacar los FP tienen que ser mayores al costo del ataque.
     * @param attack Ataque utilizado
     * @return Verdadero si puede atacar, Falso si no.
     */
    public boolean enoughFP(IAttacks attack) {
        return this.getFP() >= attack.getFPCost();
    }

    /**
     * Usa el item Honey Syrup.
     * Restaura al personaje una cantidad de 3 FP.
     * (Al utilizarse {@code setFP} no permite que se añadan más
     * FP que el máximo de FP)
     */
    public void useHoneySyrup() {
        int newFP = this.getFP()+3;
        this.setFP(newFP);
    }

    /**
     * Usa el item RedMushroom.
     * Cura al personaje una cantidad de 10 % del HP máximo del personaje.
     * (Al utilizarse {@code setHP} no permite que se añadan más
     * HP que el máximo de HP)
     */
    public void useRedMushroom() {
        double amountOfHeal = this.getMaxHP()*0.1;
        int HP = this.getHP();
        int newHP = (int) Math.round(HP + amountOfHeal);
        this.setHP(newHP);
    }

    /**
     * Entrega la cantidad de daño que harían las espinas (o pinchos) de Spiny.
     * La cantidad de daño es el 5% del HP del personaje.
     * @return Cantidad de daño que harían los pinchos de Spiny.
     */
    public double damageThornsSpiny() {
        return 0.05*this.getHP();
    }

    /**
     * Permite utilizar el item que se entregue.
     * El item que se use se consume del inventario.
     * @param item Item que se quiere usar.
     */
    public void useItem(IObject item, Baul baul) {
        if (baul.hasItem(item)) {
            item.use(this);
            baul.removeItem(item, 1);
        }
    }

    /**
     * Entrega la cantidad de daño que haría un enemigo al jugador.
     * Calculado como (Constante K del enemigo)*(ATK del Enemigo)*((LVL del Enemigo)/(DEF del Jugador))
     * La constante K del enemigo es la misma para todos y es 0.75
     * @param enemy Enemigo atacante
     * @return Cantidad de daño que haría un enemigo al jugador.
     */
    public double enemyDoDamage(IEnemy enemy) {
        return (double) (Math.round(0.75*this.preDamage(enemy)));
    }

    /**
     * Reduce los FP del jugador al utilizar un ataque.
     * Los FP reducidos son los que cuesta utilizar el ataque.
     * @param attack Ataque utilizado
     */
    public void useFPtoAttack(IAttacks attack) {
        int nuevoFP = this.getFP() - attack.getFPCost();
        this.setFP(nuevoFP);
    }
}
