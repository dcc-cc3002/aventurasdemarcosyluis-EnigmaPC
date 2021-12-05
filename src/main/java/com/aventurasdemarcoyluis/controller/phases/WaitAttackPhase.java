package com.aventurasdemarcoyluis.controller.phases;

import com.aventurasdemarcoyluis.model.interfaces.IAttacks;
import com.aventurasdemarcoyluis.model.interfaces.IEnemy;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;

import java.io.IOException;

/**
 * Fase de selección del enemigo por atacar
 */
public class WaitAttackPhase extends Phase{

    /**
     * Constructor.
     * Solo WaitToAttack es true
     */
    public WaitAttackPhase(){
        this.canIStart =false;
        this.canIChoose =false;
        this.canAttack =false;
        this.canUseItem=false;
        this.canIEndTurn =false;
        this.WaitToAttack =true;
        this.WaitToUseItem =false;
    }

    @Override
    public String toString() {
        return "WaitFightPhase";
    }

    /**
     * Método que permite ir a la seleccion del enemigo por atacar
     * @throws InvalidElectionException Si se hace una elección incorrecta
     * @throws IOException Default
     */
    @Override
    public void selectAttack() throws InvalidElectionException, IOException {
        controller.electionAttack();
    }

    /**
     * Permite ir a la fase AttackPhase solo si estaba en WaitAttackPhase
     * @param attacker atacante
     * @param victim enemigo
     * @param attack ataque usado
     */
    @Override
    public void toAttackPhase(IPlayer attacker, IEnemy victim, IAttacks attack) {
        changePhase(new AttackPhase(attacker,victim,attack));
        controller.tryToAttack();
    }
}
