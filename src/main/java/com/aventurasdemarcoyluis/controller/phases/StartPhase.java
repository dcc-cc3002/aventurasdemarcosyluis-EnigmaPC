package com.aventurasdemarcoyluis.controller.phases;

public class StartPhase extends Phase{
    public StartPhase(){
        this.canIStart=true;
        this.canIChoose=false;
        this.canFight=false;
        this.canIfinish=false;
        this.WaitTOFight =false;
        this.WaitToChooseItem=false;
        this.Battle=false;
    }

    @Override
    public String toString() {
        return "Start_Phase";
    }

    @Override
    public void toElectionPhase() {
        changePhase(new ElectionPhase());
    }

}
