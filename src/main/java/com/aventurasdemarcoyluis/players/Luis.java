package com.aventurasdemarcoyluis.players;

import com.aventurasdemarcoyluis.abstract_classes.AbstractPlayer;

import com.aventurasdemarcoyluis.enemies.Boo;
import com.aventurasdemarcoyluis.enemies.Goomba;
import com.aventurasdemarcoyluis.enemies.Spiny;
import com.aventurasdemarcoyluis.interfaces.IAttacks;
import com.aventurasdemarcoyluis.interfaces.IAttackedByBoo;
import com.aventurasdemarcoyluis.interfaces.IAttackedByLuis;


/**
 * <b>Clase Luis:</b> <br>
 * Modela al JUGADOR LUIS <br>
 * Se heredan los campos de la clase madre AbstractPlayer.
 *
 * @author Andrea PC
 *
 * @see Marco
 * @see AbstractPlayer
 * */
public class Luis extends AbstractPlayer implements IAttackedByBoo {

    /**
     * <b>Constructor:</b> <br>
     * Modela un Luis. Se establece el nombre "Luis".
     * @param level Nivel de Luis
     * @param attack Poder de Ataque de Luis
     * @param defense Poder de Defensa de Luis
     * @param maxHealPoints Máxima cantidad de puntos de Vida de Luis
     * @param maxFightPoints Máxima cantidad de puntos de Ataque de Luis
     */
    public Luis(int level, int attack, int defense, int maxHealPoints, int maxFightPoints) {
        super(level, attack, defense, maxHealPoints, maxFightPoints, "Luis");
    }

    /**
     * Permite a Luis atacar a los enemigo que pueden ser atacados por él con cierto ataque. Solo si
     * Luis tiene suficientes FP para atacar y ni Luis ni el enemigo están muertos.
     * @param enemy Enemigo a atacar
     * @param attack Ataque utilizado
     */
    public void attack(IAttackedByLuis enemy, IAttacks attack) {
        if (this.enoughFP(attack) && this.isNotDead() && enemy.isNotDead()) {
            this.useFPtoAttack(attack);
            enemy.attackedByLuis(this, attack);
        }
    }

    /**
     * Permite a Luis ser atacado por Boo.
     * @param boo Boo atacante
     */
    @Override
    public void attackedByBoo(Boo boo) {
        double damageDeal = this.enemyDoDamage(boo);
        this.getDamage(damageDeal);
    }

    /**
     * Permite a Luis ser atacado por Goomba.
     * @param goomba Goomba atacante
     */
    @Override
    public void attackedByGoomba(Goomba goomba) {
        double damageDeal = this.enemyDoDamage(goomba);
        this.getDamage(damageDeal);
    }

    /**
     * Permite a Luis ser atacado por Spiny.
     * @param spiny Spiny atacante
     */
    @Override
    public void attackedBySpiny(Spiny spiny) {
        double damageDeal = this.enemyDoDamage(spiny);
        this.getDamage(damageDeal);
    }
}
