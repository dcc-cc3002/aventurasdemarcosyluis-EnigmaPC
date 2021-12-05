package com.aventurasdemarcoyluis.controller.phases;

/**
 * Fase de inicio de turno
 */
public class StartPhase extends Phase{

    /**
     * Constructor.
     * Solo canIStart es true
     */
    public StartPhase(){
        this.canIStart =true;
        this.canIChoose =false;
        this.canAttack =false;
        this.canUseItem=false;
        this.canIEndTurn =false;
        this.WaitToAttack =false;
        this.WaitToUseItem =false;
    }

    @Override
    public String toString() {
        return "StartPhase";
    }

    /**
     * Permite ir a la fase de elección
     */
    @Override
    public void toElectionPhase() {
        changePhase(new ElectionPhase());
    }

}
