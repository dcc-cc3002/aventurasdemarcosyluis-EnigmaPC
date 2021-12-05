package com.aventurasdemarcoyluis.controller.phases;

import com.aventurasdemarcoyluis.model.interfaces.IAttacks;
import com.aventurasdemarcoyluis.model.interfaces.IEnemy;
import com.aventurasdemarcoyluis.model.interfaces.IEntities;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;

public class AttackPhase extends Phase {
    IPlayer attacker;
    IEnemy opponent;
    IAttacks attack;

    public AttackPhase(IPlayer attacker, IEnemy victim, IAttacks ataque) {
        this.canIChoose=false;
        this.canFight=true;
        this.canIStart=false;
        this.attacker=attacker;
        this.opponent=victim;
        this.attack = ataque;
    }

    @Override
    public String toString() {
        return "Fase de Ataque";
    }

    @Override
    public void attack(){
        controller.attackEnemyWith(attacker,opponent,attack);
        toEndTurnPhase();
        controller.tryToEndTurn();
    }

    @Override
    public void toEndTurnPhase() {
        changePhase(new EndTurn());
    }
}
