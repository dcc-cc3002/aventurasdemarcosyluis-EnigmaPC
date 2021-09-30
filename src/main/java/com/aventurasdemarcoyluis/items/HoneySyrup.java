package com.aventurasdemarcoyluis.items;

import com.aventurasdemarcoyluis.abstract_classes.AbstractAttackType;
import com.aventurasdemarcoyluis.abstract_classes.AbstractItem;
import com.aventurasdemarcoyluis.attacks.JumpAttack;
import com.aventurasdemarcoyluis.interfaces.IPlayer;

/**
 * <b>Clase HoneySyrup:</b> <br>
 * Modela el item Honey Syrup <br>
 * Se heredan los campos de AbstractItem <br>
 *
 * @author Andrea PC
 *
 * @see RedMushroom
 * @see Star
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
     * Permite a un item ser usado por un Jugador (los enemigos no pueden usar items).
     * @param player Jugador que quiere usar el item
     */
    @Override
    public void use(IPlayer player) {
        player.useHoneySyrup();
    }
}
