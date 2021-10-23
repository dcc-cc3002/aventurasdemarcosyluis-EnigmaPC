package com.aventurasdemarcoyluis.model.players;

import com.aventurasdemarcoyluis.model.abstract_classes.AbstractPlayer;
import com.aventurasdemarcoyluis.model.enemies.Goomba;
import com.aventurasdemarcoyluis.model.enemies.Spiny;
import com.aventurasdemarcoyluis.model.interfaces.IAttacks;
import com.aventurasdemarcoyluis.model.interfaces.IEnemy;

/**
 * <b>Clase Marco:</b> <br>
 * Modela al JUGADOR MARCO <br>
 * Se heredan los campos de la clase madre AbstractPlayer.
 *
 * @author Andrea PC
 *
 * @see Luis
 * @see AbstractPlayer
 * */
public class Marco extends AbstractPlayer {

    /**
     * <b>Constructor:</b> <br>
     * Modela un Marco. Se establece el nombre "Marco".
     * @param level Nivel de Marco
     * @param attack Poder de Ataque de Marco
     * @param defense Poder de Defensa de Marco
     * @param maxHealPoints Máxima cantidad de puntos de Vida de Marco
     * @param maxFightPoints Máxima cantidad de puntos de Ataque de Marco
     */
    public Marco(int level, int attack, int defense, int maxHealPoints, int maxFightPoints) {
        super(level, attack, defense, maxHealPoints, maxFightPoints, "Marco");
    }

    /**
     * Permite a Marco atacar a un enemigo con cierto ataque. Solo si
     * Marco tiene suficientes FP para atacar y ni Marco ni el enemigo están muertos.
     * @param enemy Enemigo a atacar
     * @param attack Ataque utilizado
     */
    public void attack(IEnemy enemy, IAttacks attack) {
        if (this.enoughFP(attack) && this.isNotDead() && enemy.isNotDead()) {
            this.useFPtoAttack(attack);
            enemy.attackedByMarco(this, attack);
        } else {
            System.out.println("Marco no puede atacar");
        }
    }

    /**
     * Permite a Marco ser atacado por Goomba.
     * @param goomba Goomba atacante
     */
    @Override
    public void attackedByGoomba(Goomba goomba) {
        double damageDeal = this.enemyDoDamage(goomba);
        System.out.println("Marco es atacado por Goomba y recibe "+(int) Math.round(damageDeal)+" de daño");
        this.getDamage(damageDeal);
    }

    /**
     * Permite a Marco ser atacado por Spiny.
     * @param spiny Spiny atacante
     */
    @Override
    public void attackedBySpiny(Spiny spiny) {
        double damageDeal = this.enemyDoDamage(spiny);
        System.out.println("Marco es atacado por Spiny y recibe "+(int) Math.round(damageDeal)+" de daño");
        this.getDamage(damageDeal);
    }
}