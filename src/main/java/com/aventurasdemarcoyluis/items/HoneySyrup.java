package com.aventurasdemarcoyluis.items;

import com.aventurasdemarcoyluis.abstract_classes.AbstractItem;
import com.aventurasdemarcoyluis.interfaces.IPlayer;

public class HoneySyrup extends AbstractItem {

    public HoneySyrup() {
        super("HoneySyrup");
    }

    @Override
    public void use(IPlayer player) {
        player.useHoneySyrup();
    }
}
