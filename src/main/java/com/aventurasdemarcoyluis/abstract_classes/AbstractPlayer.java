package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.interfaces.IAttacks;
import com.aventurasdemarcoyluis.interfaces.IEnemy;
import com.aventurasdemarcoyluis.interfaces.IObject;
import com.aventurasdemarcoyluis.interfaces.IPlayer;

import java.util.Hashtable;

/**
 * <b>Clase abstracta Player:</b> <br>
 * Modela el tipo de entidad JUGADOR <br>
 * Se heredan los campos de la clase madre AbstractEntities.
 * Y se añaden los siguientes: <br>
 * <b>invincible</b>: Si el jugador está en modo invencible <br>
 * <b>inventory</b>: Inventario del jugador <br>
 *
 * @author Andrea PC
 *
 * @see com.aventurasdemarcoyluis.players.Marco
 * @see com.aventurasdemarcoyluis.players.Luis
 * */
public abstract class AbstractPlayer extends AbstractEntities implements IPlayer {
    // Campos
    private boolean invincible;
    private Hashtable<IObject, Integer> inventory; // Variable para colocar items

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
        this.inventory = new Hashtable<>(3);
        this.invincible = false;
    }

    /**
     * Añade cierta cantidad de items al inventario.
     * Si la cantidad es negativa, no hace nada (no se puede añadir cantidades negativas)
     * @param item Item que se quiere añadir
     * @param amount Cantidad
     */
    protected void addItem(IObject item, int amount) {
        if (amount > 0) {
            if (this.hasItem(item)) {
                int amountFinal = inventory.get(item);
                amountFinal += amount;
                inventory.replace(item,amountFinal);
            } else {
                inventory.put(item, amount);
            }
        }
    }

    /**
     * Entrega la cantidad existente en el inventario de cierto item
     * @param item Item del que se requiere conocer la cantidad
     * @return Cantidad del item en el inventario
     */
    protected int amountOfItem(IObject item) {
        if (this.hasItem(item)) {
            return inventory.get(item);
        } else {
            return 0;
        }
    }

    /**
     * Remueve la cantidad que se requiera de cierto item en el inventario.
     * Si la cantidad es negativa, no hace nada (no se puede remover una cantidad negativa)
     * @param item Item que se quiere remover
     * @param amount Cantidad
     */
    protected void removeItem(IObject item, int amount) {
        if (this.hasItem(item)) {
            int amountFinal = inventory.get(item);
            amountFinal -= amount;
            if (amount > 0) {
                if (amountFinal <= 0) {
                    inventory.remove(item);
                } else {
                    inventory.replace(item, amountFinal);
                }
            }
        }
    }

    /**
     * Determina si un item está en el inventario (si hay existencias)
     */
    protected boolean hasItem(IObject item) {
        return inventory.containsKey(item);
    }

    /**
     * Determina si un jugador es invencible o no.
     * @return Verdadero si es invencible, Falso si no.
     */
    public boolean isInvincible() {
        return invincible;
    }

    /**
     * Establece la invencibilidad del jugador.
     * @param bool Verdadero si se quiere hacer invencible, Falso si no.
     */
    public void setInvincible(boolean bool) {
        this.invincible = bool;
    }

    /**
     * Determina si un jugador tiene suficientes FP para atacar con cierto ataque.
     * Para atacar los FP tienen que ser mayores al costo del ataque.
     * @param attack Ataque utilizado
     * @return Verdadero si puede atacar, Falso si no.
     */
    protected boolean enoughFP(IAttacks attack) {
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
     * Usa el item Star.
     * Hace que el personaje que la consuma entre al estado invencible.
     */
    public void useStar() {
        this.setInvincible(true);
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
    public void useItem(IObject item) {
        if (hasItem(item)) {
            item.use(this);
            this.removeItem(item, 1);
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

    /**
     * Determina si un jugador es igual a otro.
     * Se comparan tanto inventario como estado de invencibilidad.
     * @param obj Jugador a comparar
     * @return Si el jugador a comparar tiene el mismo inventario y
     * estado de invencibilidad que el otro (this)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AbstractPlayer that)) return false;
        if (!super.equals(obj)) return false;

        if (isInvincible() != that.isInvincible()) return false;
        return inventory.equals(that.inventory);
    }

    /**
     * Entrega el hashCode de un jugador (inventario y estado de invencibilidad)
     * @return hashCode de un jugador
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isInvincible() ? 1 : 0);
        result = 31 * result + inventory.hashCode();
        return result;
    }
}
