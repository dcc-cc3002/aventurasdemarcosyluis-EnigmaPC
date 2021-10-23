package com.aventurasdemarcoyluis.items;

import com.aventurasdemarcoyluis.abstract_classes.AbstractItem;
import com.aventurasdemarcoyluis.interfaces.IPlayer;

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
        System.out.println(player.getName()+" ha usado Honey Syrup");
        player.useHoneySyrup();
    }
}
