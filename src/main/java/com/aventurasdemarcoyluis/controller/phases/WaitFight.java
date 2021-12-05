package com.aventurasdemarcoyluis.controller.phases;

import com.aventurasdemarcoyluis.model.interfaces.IAttacks;
import com.aventurasdemarcoyluis.model.interfaces.IEnemy;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;

import java.io.IOException;

public class WaitFight extends Phase{

    public WaitFight(){
        this.canIStart=false;
        this.canIChoose=false;
        this.canFight=false;
        this.canIfinish=false;
        this.WaitTOFight =true;
        this.WaitToChooseItem=false;
    }

    @Override
    public String toString() {
        return "WaitFight_Phase";
    }


    @Override
    public void selectAttack() throws InvalidElectionException, IOException {
        controller.electionAttack2();
    }

    @Override
    public void toAttackPhase(IPlayer attacker, IEnemy victim, IAttacks attack) {
        changePhase(new AttackPhase(attacker,victim,attack));
        controller.tryToAttack();
    }
}
