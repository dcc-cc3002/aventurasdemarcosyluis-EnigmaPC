package com.aventurasdemarcoyluis.controller.phases;

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
    public void toWaitPathPhase() {
        changePhase(new WaitPath());
    }

    @Override
    public void toWaitHomePhase() {
        changePhase(new WaitHome());
    }

    @Override
    public void toWaitFigthPhase(IUnit attacker, IUnit victim) {
        changePhase(new WaitFight(attacker, victim));
    }

    @Override
    public void toEndTurnPhase(){
        changePhase(new EndTurn());
    }
}
