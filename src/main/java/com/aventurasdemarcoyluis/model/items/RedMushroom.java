package com.aventurasdemarcoyluis.model.items;

import com.aventurasdemarcoyluis.model.abstract_classes.AbstractItem;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;

/**
 * <b>Clase RedMushroom:</b> <br>
 * Modela el item RedMushroom <br>
 * Se heredan los campos de AbstractItem <br>
 *
 * @author Andrea PC
 *
 * @see HoneySyrup
 * @see AbstractItem
 */
public class RedMushroom extends AbstractItem {

    /**
     * <b>Constructor:</b> <br>
     * Se establece el nombre del item como RedMushroom.
     */
    public RedMushroom() {
        super("RedMushroom");
    }

    /**
     * Permite a Red Mushroom ser usado por un Jugador (los enemigos no pueden usar items).
     * @param player Jugador que quiere usar Red Mushroom
     */
    @Override
    public void use(IPlayer player) {
        player.useRedMushroom();
    }
}
