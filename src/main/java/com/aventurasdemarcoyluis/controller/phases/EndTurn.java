package com.aventurasdemarcoyluis.controller.phases;

public class EndTurn extends Phase{
    public EndTurn(){
        this.canIStart=false;
        this.canIChoose=false;
        this.canFight=false;
        this.canUseItem=false;
        this.canIfinish=true;
        this.WaitTOFight =false;
        this.WaitToChooseItem=false;
    }

    @Override
    public void endTurn() throws InvalidStateException, InvalidTransitionException {
       super.endTurn();
    }

    @Override
    public void toStartPhase(){
        changePhase(new StartPhase());
    }

    @Override
    public String toString() {
        return "EndTurn_Phase";
    }
}
