package com.aventurasdemarcoyluis.controller.phases;

/**
 * Fase de término del turno
 */
public class EndTurnPhase extends Phase{

    /**
     * Constructor
     * Solo canIEndTurn es true
     */
    public EndTurnPhase(){
        this.canIStart =false;
        this.canIChoose =false;
        this.canAttack =false;
        this.canUseItem=false;
        this.canIEndTurn =true;
        this.WaitToAttack =false;
        this.WaitToUseItem =false;
    }

    @Override
    public String toString() {
        return "EndTurnPhase";
    }

    /**
     * Método que permite terminar el turno
     * @throws InvalidStateException Si está en un estado incorrecto
     * @throws InvalidTransitionException Si está en una fase incorrecta
     */
    @Override
    public void endTurn() throws InvalidStateException, InvalidTransitionException {
       super.endTurn();
    }

    /**
     * Permite ir a la fase de inicio de turno una vez que termina el turno
     */
    @Override
    public void toStartPhase(){
        changePhase(new StartPhase());
    }
}
