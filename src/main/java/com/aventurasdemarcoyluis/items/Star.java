package com.aventurasdemarcoyluis.items;

import com.aventurasdemarcoyluis.abstract_classes.AbstractItem;
import com.aventurasdemarcoyluis.interfaces.IPlayer;

/**
 * <b>Clase Star:</b> <br>
 * Modela el item Star <br>
 * Se heredan los campos de AbstractItem <br>
 *
 * @author Andrea PC
 *
 * @see HoneySyrup
 * @see RedMushroom
 * @see AbstractItem
 */
public class Star extends AbstractItem {

    /**
     * <b>Constructor:</b> <br>
     * Se establece el nombre del item como Star.
     */
    public Star() {
        super("Star");
    }

    /**
     * Permite a Star ser usado por un Jugador (los enemigos no pueden usar items).
     * @param player Jugador que quiere usar Star
     */
    @Override
    public void use(IPlayer player) {
        player.useStar();
    }
}
