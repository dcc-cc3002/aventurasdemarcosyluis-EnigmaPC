package com.aventurasdemarcoyluis.controller.phases;

import com.aventurasdemarcoyluis.model.interfaces.IAttacks;
import com.aventurasdemarcoyluis.model.interfaces.IEnemy;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;

/**
 * Fase de ataque
 */
public class AttackPhase extends Phase {
    IPlayer attacker;
    IEnemy opponent;
    IAttacks attack;

    /**
     * Constructor.
     * @param attacker atacante
     * @param victim enemigo
     * @param ataque ataque usado
     */
    public AttackPhase(IPlayer attacker, IEnemy victim, IAttacks ataque) {
        this.canIStart =false;
        this.canIChoose =false;
        this.canAttack =true;
        this.canUseItem=false;
        this.canIEndTurn =false;
        this.WaitToAttack =false;
        this.WaitToUseItem =false;
        this.attacker=attacker;
        this.opponent=victim;
        this.attack = ataque;
    }

    @Override
    public String toString() {
        return "AttackPhase";
    }

    /**
     * Método para atacar
     */
    @Override
    public void attack(){
        controller.attackEnemyWith(attacker,opponent,attack);
        toEndTurnPhase();
        controller.tryToEndTurn();
    }

    /**
     * Permite ir a la fase de término del turno una vez terminado el ataque.
     */
    @Override
    public void toEndTurnPhase() {
        changePhase(new EndTurnPhase());
    }
}
