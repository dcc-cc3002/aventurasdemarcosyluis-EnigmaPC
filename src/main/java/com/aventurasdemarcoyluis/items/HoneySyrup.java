package com.aventurasdemarcoyluis.items;

import com.aventurasdemarcoyluis.abstract_classes.AbstractItem;
import com.aventurasdemarcoyluis.interfaces.IPlayer;

public class HoneySyrup extends AbstractItem {

    @Override
    public void use(IPlayer player) {
        player.useHoneySyrup();
    }
}
