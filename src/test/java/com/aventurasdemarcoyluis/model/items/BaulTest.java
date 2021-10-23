package com.aventurasdemarcoyluis.model.items;

import com.aventurasdemarcoyluis.model.abstract_classes.BaseTest;
import com.aventurasdemarcoyluis.model.players.Luis;
import com.aventurasdemarcoyluis.model.players.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaulTest extends BaseTest {

    @BeforeEach
    void setUp() {
        baul = new Baul();

        // Items
        honeySyrup = new HoneySyrup();
        redMushroom = new RedMushroom();

        // Players
        marco = new Marco(16,28,31,57,20);
        luis = new Luis(4,10,25,2,2);
        luis2 = new Luis(9,12,11,18,7);
    }

    @Test
    void baulEmptyCompleteTest() {
        // Inicialmente el baul no tiene ningún item.
        assertEquals(baul.hasItem(honeySyrup), false);
        assertEquals(baul.hasItem(redMushroom), false);

        // Añadimos algunos items:
        baul.addItem(honeySyrup, 5);
        baul.addItem(redMushroom, 4);

        // Ahora el Baul debe tener estos items y con la cantidad añadida
        assertEquals(baul.hasItem(honeySyrup), true);
        assertEquals(baul.hasItem(redMushroom), true);
        assertEquals(baul.amountOfItem(honeySyrup), 5);
        assertEquals(baul.amountOfItem(redMushroom), 4);

        // Si removemos algunos items:
        baul.removeItem(honeySyrup, 2); // Ahora debe tener 3 honeySyrup
        baul.removeItem(redMushroom, 2); // Ahora debe tener 2 redMushroom
        baul.removeItem(honeySyrup, -5); // Esto no debe hacer nada pues
        // no se pueden remover -5 items.

        // Ahora el Baul debe tener estos items y con la cantidad añadida
        assertEquals(baul.hasItem(honeySyrup), true);
        assertEquals(baul.hasItem(redMushroom), true);
        assertEquals(baul.amountOfItem(honeySyrup), 3);
        assertEquals(baul.amountOfItem(redMushroom), 2);

        // Ahora se testeará useItem, el cual debe disminuir la cantidad de
        // items según el item que se use.
        marco.useItem(honeySyrup, baul);
        assertEquals(baul.amountOfItem(honeySyrup), 2);
        marco.useItem(honeySyrup, baul);
        assertEquals(baul.amountOfItem(honeySyrup), 1);
        marco.useItem(honeySyrup, baul);
        assertEquals(baul.amountOfItem(honeySyrup), 0);
        marco.useItem(redMushroom, baul);
        assertEquals(baul.amountOfItem(redMushroom), 1);
        marco.useItem(redMushroom, baul);
        assertEquals(baul.amountOfItem(redMushroom), 0);
    }

    /**
     * El mismo test anterior pero para un baúl con items
     */
    @Test
    void baulCompleteTest() {
        // Inicialmente el baul tiene 5 Honey Syrup y 4 Red Mushroom
        baul = new Baul(5,4);

        // Ahora el Baul debe tener estos items y con la cantidad dada
        assertEquals(baul.hasItem(honeySyrup), true);
        assertEquals(baul.hasItem(redMushroom), true);
        assertEquals(baul.amountOfItem(honeySyrup), 5);
        assertEquals(baul.amountOfItem(redMushroom), 4);

        // Si removemos algunos items:
        baul.removeItem(honeySyrup, 2); // Ahora debe tener 3 honeySyrup
        baul.removeItem(redMushroom, 2); // Ahora debe tener 2 redMushroom
        baul.removeItem(honeySyrup, -5); // Esto no debe hacer nada pues
        // no se pueden remover -5 items.

        // Ahora el Baul debe tener estos items y con la cantidad añadida
        assertEquals(baul.hasItem(honeySyrup), true);
        assertEquals(baul.hasItem(redMushroom), true);
        assertEquals(baul.amountOfItem(honeySyrup), 3);
        assertEquals(baul.amountOfItem(redMushroom), 2);

        // Ahora se testeará useItem, el cual debe disminuir la cantidad de
        // items según el item que se use.
        marco.useItem(honeySyrup, baul);
        assertEquals(baul.amountOfItem(honeySyrup), 2);
        marco.useItem(honeySyrup, baul);
        assertEquals(baul.amountOfItem(honeySyrup), 1);
        marco.useItem(honeySyrup, baul);
        assertEquals(baul.amountOfItem(honeySyrup), 0);
        marco.useItem(redMushroom, baul);
        assertEquals(baul.amountOfItem(redMushroom), 1);
        marco.useItem(redMushroom, baul);
        assertEquals(baul.amountOfItem(redMushroom), 0);
    }
}