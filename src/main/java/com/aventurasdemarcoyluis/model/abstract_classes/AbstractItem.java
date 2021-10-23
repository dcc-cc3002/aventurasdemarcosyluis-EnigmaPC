package com.aventurasdemarcoyluis.model.abstract_classes;

import com.aventurasdemarcoyluis.model.interfaces.IObject;

/**
 * <b>Clase abstracta Item:</b> <br>
 * Modela los items que existirán en el mundo. <br>
 * Tiene un único campo: <br>
 * <b>name</b>: Nombre del item <br>
 *
 * @author Andrea PC
 *
 * @see com.aventurasdemarcoyluis.model.items.HoneySyrup
 * @see com.aventurasdemarcoyluis.model.items.RedMushroom
 */
public abstract class AbstractItem implements IObject {
    // Campos
    private final String name;

    /**
     * <b>Constructor:</b> <br>
     * Modela un item
     * @param aName Nombre del item
     */
    public AbstractItem(String aName) {
        this.name = aName;
    }

    /**
     * Determina si un item es igual a otro.
     * Solamente se compara el nombre.
     * @param obj Item a comparar
     * @return Si el item es igual al item a comparar.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AbstractItem that)) return false;

        return name.equals(that.name);
    }

    /**
     * Entrega el hashCode de un item
     * @return hashCode de un item
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
