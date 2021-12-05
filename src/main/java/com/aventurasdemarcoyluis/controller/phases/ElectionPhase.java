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
    }



    @Override
    public String toString() {
        return "Moving_Phase";
    }


    @Override
    public void toWaitSelectItemPhase() {
        changePhase(new WaitSelectItem());
        controller.tryToSelectItem();
    }

    @Override
    public void toWaitAttackPhase() {
        changePhase(new WaitFight());
        controller.tryToSelectAttack();
    }

    @Override
    public void toEndTurnPhase(){
        changePhase(new EndTurn());
    }
}
