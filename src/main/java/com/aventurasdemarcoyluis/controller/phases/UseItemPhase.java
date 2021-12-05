package com.aventurasdemarcoyluis.controller.phases;

import com.aventurasdemarcoyluis.model.interfaces.IObject;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;

import java.io.IOException;

/**
 * Fase para usar un item
 */
public class UseItemPhase extends Phase {
    IPlayer player;
    IObject item;

    /**
     * Constructor.
     * Solo canUseItem es true
     * @param jugador jugador
     * @param object item usado
     */
    public UseItemPhase(IPlayer jugador, IObject object) {
        this.canIStart =false;
        this.canIChoose =false;
        this.canAttack =false;
        this.canUseItem=true;
        this.canIEndTurn =false;
        this.WaitToAttack =false;
        this.WaitToUseItem =false;
        this.player=jugador;
        this.item=object;
    }

    @Override
    public String toString() {
        return "Fase de Usar Item";
    }

    /**
     * Método que permite usar un item y terminar el turno
     */
    @Override
    public void useItem(){
        controller.usePlayerItem(player,item);
        toEndTurnPhase();
        controller.tryToEndTurn();
    }

    /**
     * Permite ir a la fase de término del turno
     */
    @Override
    public void toEndTurnPhase() {
        changePhase(new EndTurn());
    }
}
