package com.aventurasdemarcoyluis.controller.phases;

import com.aventurasdemarcoyluis.controller.GameController;
import com.aventurasdemarcoyluis.model.interfaces.IAttacks;
import com.aventurasdemarcoyluis.model.interfaces.IEnemy;
import com.aventurasdemarcoyluis.model.interfaces.IObject;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;

import java.io.IOException;

public class Phase {
    protected GameController controller ;
    public boolean canFight;
    public boolean canUseItem;
    public boolean canIStart;
    public boolean canIChoose;
    public boolean canIfinish;
    public boolean WaitTOFight;
    public boolean WaitToChooseItem;

    public void setController(GameController controller){
        this.controller=controller;
    }

    protected void changePhase(Phase phase){
        controller.setPhase(phase);
    }

    /**
     * Metodo que retorna el nombre de la fase actual
     * @return Nombre de la fase actual
     */
    public String toString(){
        return "Phase";
    }

    public void start() throws InvalidStateException, InvalidTransitionException {
        if (controller.looseBattle()) {
            return;
        }
        else if (!controller.getTurnEntity().isPlayer()) {
            toElectionPhase();
            controller.enemyElection();
        }
        else if(!canIStart){
            throw new InvalidStateException("No puedes empezar en"+ toString());
        }
        else{
            toElectionPhase();
            controller.tryToChoose();
        }
    }

    public void election() throws InvalidStateException, IOException {
        if (!canIChoose) {
            throw new InvalidStateException("No puedes elegir en" + toString());
        }
        controller.electionTurn1();
    }

    public void selectAttack() throws InvalidStateException, InvalidElectionException, IOException {
        if(!WaitTOFight){
            throw new InvalidStateException("No puedes pelear en: " + toString());
        }
    }

    public void selectItem() throws InvalidStateException, InvalidElectionException, IOException {
        if(!WaitToChooseItem){
            throw new InvalidStateException("No puedes pelear en: " + toString());
        }
    }

    public void endTurn() throws InvalidStateException, InvalidTransitionException {
        if(!canIfinish){
            throw new InvalidStateException("No puedes terminar el turno en " + this.toString());
        }
        toStartPhase();
        controller.finishTurn();
    }

    public void attack() throws InvalidStateException {
        if (!canFight) {
            throw new InvalidStateException("No puedes atacar ahora.");
        }
    }

    public void useItem() throws InvalidStateException {
        if (!canUseItem) {
            throw new InvalidStateException("No puedes atacar ahora.");
        }
    }

    public void toElectionPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + " a la fase ElectionPhase");
    }

    public void toEndTurnPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + " a la fase EndTurn");
    }

    public void toStartPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + "a la fase StartPhase");
    }

    public void toWaitAttackPhase() throws InvalidTransitionException, InvalidElectionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + "a la fase WaitAttackPhase");
    }

    public void toAttackPhase(IPlayer attacker, IEnemy opponent, IAttacks selectedAttack) throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + "a la fase AttackPhase");
    }

    public void toWaitSelectItemPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + "a la fase WaitSelectItemPhase");
    }

    public void toUseItemPhase(IPlayer jugador, IObject object) throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + "a la fase AttackPhase");
    }



}
