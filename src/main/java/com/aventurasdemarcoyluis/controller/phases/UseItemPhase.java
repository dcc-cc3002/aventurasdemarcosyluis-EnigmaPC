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
        this.canUseItem=true;
        this.canIStart=false;
        this.player=jugador;
        this.item=object;
    }

    @Override
    public String toString() {
        return "Fase de Usar Item";
    }

    @Override
    public void useItem(){
        controller.usePlayerItem(player,item);
        toEndTurnPhase();
        controller.tryToEndTurn();
    }

    @Override
    public void toEndTurnPhase() {
        changePhase(new EndTurn());
    }
}
