package com.aventurasdemarcoyluis.model.items;

import com.aventurasdemarcoyluis.model.abstract_classes.AbstractItem;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;

/**
 * <b>Clase HoneySyrup:</b> <br>
 * Modela el item Honey Syrup <br>
 * Se heredan los campos de AbstractItem <br>
 *
 * @author Andrea PC
 *
 * @see RedMushroom
 * @see AbstractItem
 */
public class HoneySyrup extends AbstractItem {

    /**
     * <b>Constructor:</b> <br>
     * Se establece el nombre del item como HoneySyrup.
     */
    public HoneySyrup() {
        super("HoneySyrup");
    }

    /**
     * Permite a Honey Syrup ser usado por un Jugador (los enemigos no pueden usar items).
     * @param player Jugador que quiere usar Honey Syrup
     */
    @Override
    public void use(IPlayer player) {
        player.useHoneySyrup();
    }
}
