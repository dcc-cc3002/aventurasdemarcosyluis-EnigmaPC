package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.interfaces.IObject;
import com.aventurasdemarcoyluis.interfaces.IPlayer;

public abstract class AbstractItem implements IObject {
    public abstract void use(IPlayer player);
}
