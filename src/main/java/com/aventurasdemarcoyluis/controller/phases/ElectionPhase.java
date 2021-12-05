package com.aventurasdemarcoyluis.controller.phases;

import java.io.IOException;

public class ElectionPhase extends Phase{
    public ElectionPhase(){
        this.canIStart=false;
        this.canIChoose=true;
        this.canFight=false;
        this.canIfinish=false;
        this.WaitTOFight =false;
        this.WaitToChooseItem=false;
        this.Battle=false;
    }



    @Override
    public String toString() {
        return "Moving_Phase";
    }


    @Override
    public void toWaitHomePhase() {
        changePhase(new WaitHome());
    }

    @Override
    public void toWaitAttackPhase() throws IOException, InvalidElectionException {
        changePhase(new WaitFight());
        controller.tryToSelectAttack();
    }

    @Override
    public void toEndTurnPhase(){
        changePhase(new EndTurn());
    }
}
