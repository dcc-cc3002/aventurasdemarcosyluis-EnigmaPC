package com.aventurasdemarcoyluis.controller.phases;

/**
 * Fase de elección de ataque, uso de item o pasar
 */
public class ElectionPhase extends Phase{

    /**
     * Constructor.
     * Solo canIChoose es true
     */
    public ElectionPhase(){
        this.canIStart =false;
        this.canIChoose =true;
        this.canAttack =false;
        this.canUseItem=false;
        this.canIEndTurn =false;
        this.WaitToAttack =false;
        this.WaitToUseItem =false;
    }

    @Override
    public String toString() {
        return "ElectionPhase";
    }

    /**
     * Permite ir a la fase de selección de item
     */
    @Override
    public void toWaitSelectItemPhase() {
        changePhase(new WaitSelectItem());
        controller.tryToSelectItem();
    }

    /**
     * Permite ir a la fase de selección de enemigo por atacar
     */
    @Override
    public void toWaitAttackPhase() {
        changePhase(new WaitAttackPhase());
        controller.tryToSelectAttack();
    }

    /**
     * Permite ir a la fase de termino del turno (si es que pasa)
     */
    @Override
    public void toEndTurnPhase(){
        changePhase(new EndTurnPhase());
        controller.tryToEndTurn();
    }
}
