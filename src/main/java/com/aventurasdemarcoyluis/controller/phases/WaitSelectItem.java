package com.aventurasdemarcoyluis.controller.phases;

import com.aventurasdemarcoyluis.model.interfaces.IAttacks;
import com.aventurasdemarcoyluis.model.interfaces.IEnemy;
import com.aventurasdemarcoyluis.model.interfaces.IObject;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;

import java.io.IOException;

public class WaitSelectItem extends Phase{

    public WaitSelectItem(){
        this.canIStart=false;
        this.canIChoose=false;
        this.canFight=false;
        this.canUseItem=false;
        this.canIfinish=false;
        this.WaitTOFight=false;
        this.WaitToChooseItem=true;
    }

    @Override
    public String toString() {
        return "WaitSelectItem_Phase";
    }

    @Override
    public void selectItem() throws InvalidElectionException, IOException {
        controller.electionUseItem1();
    }

    @Override
    public void toUseItemPhase(IPlayer jugador, IObject objeto) {
        changePhase(new UseItemPhase(jugador,objeto));
        controller.tryToUseItem();
    }
}
