package com.aventurasdemarcoyluis.controller.phases;

import com.aventurasdemarcoyluis.model.interfaces.IAttacks;
import com.aventurasdemarcoyluis.model.interfaces.IEnemy;
import com.aventurasdemarcoyluis.model.interfaces.IObject;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;

public class UseItemPhase extends Phase {
    IPlayer player;
    IObject item;

    public UseItemPhase(IPlayer jugador, IObject object) {
        this.canIChoose=false;
        this.canFight=true;
        this.canIStart=false;
        this.player=jugador;
        this.item=object;
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
