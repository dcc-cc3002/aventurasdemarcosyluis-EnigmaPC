package com.aventurasdemarcoyluis.model.abstract_classes;

import com.aventurasdemarcoyluis.model.interfaces.IEntities;

import java.util.Random;

/**
 * <b>Clase abstracta Entities:</b> <br>
 * Modela las entidades que interactuarán entre ellas y el mundo <br>
 * Los campos que posee la clase son: <br>
 * <b>LVL</b>: Nivel de la entidad <br>
 * <b>ATK</b>: Poder de Ataque de la entidad <br>
 * <b>DEF</b>: Poder de Defensa de la entidad <br>
 * <b>maxHP</b>: Cantidad máxima de vida de la entidad <br>
 * <b>maxFP</b>: Cantidad máxima de puntos de ataque de la entidad <br>
 * <b>HP</b>: Cantidad de vida que posee la entidad en el momento <br>
 * <b>FP</b>: Cantidad de puntos de ataque que posee la entidad en el momento <br>
 * <b>name</b>: Nombre de la entidad (Diferenciará cada tipo de entidad) <br>
 *
 * @author Andrea PC
 *
 * @see AbstractEnemy
 * @see AbstractPlayer
 */
public abstract class AbstractEntities implements IEntities {
    // Campos
    protected int LVL;
    protected int ATK;
    protected int DEF;
    protected int maxHP;
    protected int maxFP;
    private int HP;
    private int FP;
    protected String name;
    protected Random random;

    /**
     * <b>Constructor:</b> <br>
     * Modela una entidad
     * @param level Nivel de la entidad
     * @param attack Poder de Ataque de la entidad
     * @param defense Poder de Defensa de la entidad
     * @param maxHealPoints Máxima cantidad de puntos de Vida de la entidad
     * @param maxFightPoints Máxima cantidad de puntos de Ataque de la entidad
     * @param name Nombre de la entidad
     */
    public AbstractEntities(int level, int attack, int defense, int maxHealPoints, int maxFightPoints, String name) {
        this.LVL = level;
        this.ATK = attack;
        this.DEF = defense;
        this.maxHP = maxHealPoints;
        this.HP = maxHealPoints;
        this.maxFP = maxFightPoints;
        this.FP = maxFightPoints;
        this.name = name;
    }

    /**
     * Entrega el nombre de la entidad.
     * @return Nombre de la entidad.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Determina si un personaje está muerto o no
     * @return Si un personaje tiene 0 de HP
     */
    public boolean isNotDead() {
        return this.getHP() != 0;
    }

    /**
     * Permite a una entidad recibir cierto daño
     * @param damageDeal Daño que recibe la entidad
     */
    public void getDamage(double damageDeal) {
        int nuevoHP = (int) (this.getHP() - Math.round(damageDeal));
        this.setHP(nuevoHP);
    }

    /**
     * Entrega el daño previo que haría una entidad externa "entities" sin
     * contar el uso de alguna habilidad o característica.
     * Se calcula como (ATK entidad externa) * ((LVL entidad externa)/(DEF entidad))
     * @param entities Entidad externa (la que está atacando)
     * @return Daño previo que hace la entidad externa a la entidad (this) [Redondeado]
     */
    public double preDamage(IEntities entities) {
        return Math.round(entities.getATK()*((double) entities.getLVL()/this.getDEF()));
    }

    /**
     * Establece la cantidad de FP que se requieran.
     * No se establecen FP menores a 0 ni mayores al máximo de FP (maxFP).
     * @param nuevoFP Cantidad de FP que se quieren establecer (idealmente un
     *                entero positivo)
     */
    public void setFP(int nuevoFP) {
        if (nuevoFP <= 0) {
            this.FP = 0;
        } else {
            this.FP = Math.min(nuevoFP, this.getMaxFP());
        }
    }

    /**
     * Entrega la cantidad de FP que posee la entidad en el momento.
     * @return Cantidad de FP que posee la entidad.
     */
    public int getFP() {
        return this.FP;
    }

    /**
     * Establece la cantidad de HP que se requieran.
     * No se establecen HP menores a 0 ni mayores al máximo de HP (maxHP).
     * @param nuevoHP Cantidad de HP que se quieren establecer (idealmente
     *                un entero positivo)
     */
    public void setHP(int nuevoHP) {
        if (nuevoHP <= 0) {
            this.HP = 0;
        } else {
            this.HP = Math.min(nuevoHP, this.getMaxHP());
        }
    }

    /**
     * Entrega la cantidad de HP que tiene la entidad en el momento.
     * @return Cantidad de HP que posee la entidad
     */
    public int getHP() {
        return this.HP;
    }


    /**
     * Entrega el Nivel de la entidad
     * @return Nivel del a entidad
     */
    public int getLVL() {
        return LVL;
    }

    /**
     * Entrega el Poder de Ataque de la entidad
     * @return Poder de Ataque de la entidad
     */
    public int getATK() {
        return ATK;
    }

    /**
     * Entrega el Poder de Defensa de la entidad
     * @return Poder de Defensa de la entidad
     */
    public int getDEF() {
        return DEF;
    }

    /**
     * Entrega la cantidad máxima de HP que tiene la entidad
     * @return Cantidad máxima de HP
     */
    public int getMaxHP() {
        return maxHP;
    }

    /**
     * Entrega la cantidad máxima de FP que tiene la entidad
     * @return Cantidad máxima de FP
     */
    public int getMaxFP() {
        return maxFP;
    }

    /**
     * Determina si una entidad es igual a otra.
     * Se comparan tanto estadísticas como el nombre.
     * @param obj Entidad a comparar
     * @return Si la entidad a comparar es la misma que la entidad (this)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AbstractEntities that)) return false;

        if (!name.equals(that.name)) return false;
        if (getLVL() != that.getLVL()) return false;
        if (getATK() != that.getATK()) return false;
        if (getDEF() != that.getDEF()) return false;
        if (getMaxHP() != that.getMaxHP()) return false;
        if (getMaxFP() != that.getMaxFP()) return false;
        if (getHP() != that.getHP()) return false;
        return (getFP() == that.getFP());
    }

    /**
     * Entrega el hashCode de una entidad
     * @return hashCode de una entidad
     */
    @Override
    public int hashCode() {
        int result = getLVL();
        result = 31 * result + getATK();
        result = 31 * result + getDEF();
        result = 31 * result + getMaxHP();
        result = 31 * result + getMaxFP();
        result = 31 * result + getHP();
        result = 31 * result + getFP();
        result = 31 * result + name.hashCode();
        return result;
    }
}
