package com.aventurasdemarcoyluis.controller.phases;

import com.aventurasdemarcoyluis.model.interfaces.IObject;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;

import java.io.IOException;

/**
 * Fase de selección del item
 */
public class WaitSelectItem extends Phase{

    /**
     * Constructor.
     * Solo WaitToUseItem es true
     */
    public WaitSelectItem(){
        this.canIStart =false;
        this.canIChoose =false;
        this.canAttack =false;
        this.canUseItem=false;
        this.canIEndTurn =false;
        this.WaitToAttack =false;
        this.WaitToUseItem =true;
    }

    @Override
    public String toString() {
        return "WaitSelectItemPhase";
    }

    /**
     * Método que permite ir a la seleccion de item
     * @throws InvalidElectionException Si se hace una elección incorrecta
     * @throws IOException Default
     */
    @Override
    public void selectItem() throws InvalidElectionException, IOException {
        controller.electionUseItem();
    }

    /**
     * Permite ir a la fase de UseItemPhase solo si estaba en WaitSelectItem
     * @param jugador jugador que usa el item
     * @param objeto item a usar
     */
    @Override
    public void toUseItemPhase(IPlayer jugador, IObject objeto) {
        changePhase(new UseItemPhase(jugador,objeto));
        controller.tryToUseItem();
    }
}
