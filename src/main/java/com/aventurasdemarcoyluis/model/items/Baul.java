package com.aventurasdemarcoyluis.model.items;

import com.aventurasdemarcoyluis.model.interfaces.IObject;
import com.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.aventurasdemarcoyluis.model.items.RedMushroom;

import java.util.Hashtable;

/**
 * <b>Clase Baul:</b> <br>
 * Modela un BAUL para almacenar items del juego. <br>
 *
 * @author Andrea PC
 */
public class Baul {
    private Hashtable<IObject, Integer> storage = new Hashtable<>(2); // Variable para colocar items

    /**
     * <b>Constructor:</b> <br>
     * Modela un baul vacío.
     * No tiene ninguna existencia de los items inicialmente
     */
    public Baul() {
        storage.put(new HoneySyrup(), 0);
        storage.put(new RedMushroom(), 0);
    }

    /**
     * <b>Constructor:</b> <br>
     * Modela un baul con items.
     * Posee existencia de los items según los parámetros dados
     * @param amountHoneySyrup cantidad inicial de Honey Syrup
     * @param amountRedMushroom cantidad inicial de Red Mushroom
     */
    public Baul(int amountHoneySyrup, int amountRedMushroom) {
        storage.put(new HoneySyrup(), amountHoneySyrup);
        storage.put(new RedMushroom(), amountRedMushroom);
    }

    /**
     * Añade cierta cantidad de items al almacenaje.
     * Si la cantidad es negativa, no hace nada (no se puede añadir cantidades negativas)
     * @param item Item que se quiere añadir
     * @param amount Cantidad
     */
    public void addItem(IObject item, int amount) {
        if (amount > 0) {
            int amountFinal = storage.get(item);
            amountFinal += amount;
            storage.replace(item,amountFinal);
        }
    }

    /**
     * Entrega la cantidad existente en el almacenaje de cierto item
     * @param item Item del que se requiere conocer la cantidad
     * @return Cantidad del item en el almacenaje
     */
    protected int amountOfItem(IObject item) {
        return storage.get(item);
    }

    /**
     * Remueve la cantidad que se requiera de cierto item en el inventario.
     * Si la cantidad es negativa, no hace nada (no se puede remover una cantidad negativa)
     * @param item Item que se quiere remover
     * @param amount Cantidad
     */
    public void removeItem(IObject item, int amount) {
        int amountFinal = storage.get(item);
        amountFinal -= amount;
        if (amount > 0) {
            if (amountFinal <= 0) {
                storage.replace(item, 0);
            } else {
                storage.replace(item, amountFinal);
            }
        }
    }

    /**
     * Entrega los elementos que hay en el baúl
     * @return Hashtable con los elementos del baúl
     */
    public Hashtable<IObject, Integer> getStorage() {
        return storage;
    }

    /**
     * Determina si un item está en el almacenaje (SI HAY EXISTENCIAS)
     * @param item Item a buscar
     * @return Verdadero si está, falso si no.
     */
    public boolean hasItem(IObject item) {
        return (storage.get(item) > 0);
    }

}
