package com.aventurasdemarcoyluis.controller.phases;

import com.aventurasdemarcoyluis.controller.GameController;

import java.io.IOException;

public class Phase {
    protected GameController controller ;
    public boolean canFight;
    public boolean canIStart;
    public boolean canIChoose;
    public boolean canIfinish;
    public boolean WaitTOFight;
    public boolean WaitToChooseItem;
    public boolean Battle;

    public void setController(GameController controller){
        this.controller=controller;
    }

    protected void changePhase(Phase phase){
        controller.setPhase(phase);
    }

    /**
     * Method that
     * @return the name of the actual Phase
     */
    public String toString(){
        return "Phase";
    }

    public void start() throws InvalidTransitionException {
        if(!canIStart){
            throw new InvalidTransitionException("You can't start at"+ toString());
        }
        else{
            toElectionPhase();
            controller.tryToChoose();
        }
    }

    public void election() throws InvalidElectionException, IOException {
        if (!canIChoose) {
            throw new InvalidElectionException("No puedes elegir en" + toString());
        }
        controller.electionTurn1();
    }

    public void toElectionPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + " a la fase ElectionPhase");
    }

}
