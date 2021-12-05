package com.aventurasdemarcoyluis.controller.phases;

public class EndTurn extends Phase{
    public EndTurn(){
        this.canIStart=false;
        this.canIChoose=false;
        this.canFight=false;
        this.canIfinish=true;
        this.WaitTOFight =false;
        this.WaitToChooseItem=false;
        this.Battle=false;
    }

    @Override
    public void endTurn() throws InvalidStateException {
       super.endTurn();
       toStartPhase();
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
