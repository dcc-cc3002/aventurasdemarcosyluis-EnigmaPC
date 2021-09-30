package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.enemies.Goomba;
import com.aventurasdemarcoyluis.enemies.Spiny;
import com.aventurasdemarcoyluis.items.HoneySyrup;
import com.aventurasdemarcoyluis.items.RedMushroom;
import com.aventurasdemarcoyluis.items.Star;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractPlayerTest extends BaseTest {

    @BeforeEach
    void setUp() {
        // Jugadores
        marco = new Marco(16,28,31,57,42);
        luis = new Luis(4,10,25,2,0);
        marco2 = new Marco(16,28,31,57,42);
        luis2 = new Luis(9,12,11,18,7);

        // Items
        honeySyrup = new HoneySyrup();
        star = new Star();
        redMushroom = new RedMushroom();

        // Enemigos
        goomba2 = new Goomba(8, 9, 11, 40, 23);
        spiny2 = new Spiny(16, 24, 35, 50, 0);
    }

    /**
     * En este test se probarán en conjunto los métodos:
     * {@code addItem},
     * {@code amountOfItem},
     * {@code removeItem},
     * {@code hasItem}.
     * {@code useItem}
     * Los cuales se relacionan entre sí
     */
    @Test
    void inventoryTest() {
        // Marco y Luis son players los cuales tienen inventario
        // como también pueden tener items, testeamos con ellos.

        // Inicialmente el inventario no tiene ningún item.
        assertEquals(marco.hasItem(star), false);
        assertEquals(marco.hasItem(honeySyrup), false);
        assertEquals(marco.hasItem(redMushroom), false);

        // Añadimos algunos items:
        marco.addItem(star, 1);
        marco.addItem(honeySyrup, 5);
        marco.addItem(redMushroom, 4);

        // Ahora Marco debe tener estos items y con la cantidad añadida
        assertEquals(marco.hasItem(star), true);
        assertEquals(marco.hasItem(honeySyrup), true);
        assertEquals(marco.hasItem(redMushroom), true);
        assertEquals(marco.amountOfItem(star), 1);
        assertEquals(marco.amountOfItem(honeySyrup), 5);
        assertEquals(marco.amountOfItem(redMushroom), 4);

        // Si removemos algunos items:
        marco.removeItem(star, 5); // Ahora no debe tener estrellas
        // como tenía 1 estrella y se quieren eliminar 5, solo se elimina 1.
        marco.removeItem(honeySyrup, 2); // Ahora debe tener 3 honeySyrup
        marco.removeItem(redMushroom, 2); // Ahora debe tener 2 redMushroom
        marco.removeItem(honeySyrup, -5); // Esto no debe hacer nada pues
        // no se pueden remover -5 items.

        // Ahora Marco debe tener estos items y con la cantidad añadida
        assertEquals(marco.hasItem(star), false);
        assertEquals(marco.hasItem(honeySyrup), true);
        assertEquals(marco.hasItem(redMushroom), true);
        assertEquals(marco.amountOfItem(star), 0);
        assertEquals(marco.amountOfItem(honeySyrup), 3);
        assertEquals(marco.amountOfItem(redMushroom), 2);

        // Ahora se testeará useItem, el cual debe disminuir la cantidad de
        // items según el item que se use.
        marco.useItem(honeySyrup);
        assertEquals(marco.amountOfItem(honeySyrup), 2);
        marco.useItem(honeySyrup);
        assertEquals(marco.amountOfItem(honeySyrup), 1);
        marco.useItem(honeySyrup);
        assertEquals(marco.amountOfItem(honeySyrup), 0);
        marco.useItem(redMushroom);
        assertEquals(marco.amountOfItem(redMushroom), 1);
        marco.useItem(redMushroom);
        assertEquals(marco.amountOfItem(redMushroom), 0);
    }

    @Test
    void canAttack() {
        // Un player puede atacar si tiene más de 0 FP
        assertTrue(marco.canAttack()); // marco tiene 42 FP
        assertFalse(luis.canAttack()); // luis tiene 0
    }

    @Test
    void useHoneySyrup() {
        // 
    }

    @Test
    void useRedMushroom() {
    }

    @Test
    void useStar() {
    }

    @Test
    void damageThornsSpiny() {
    }

    @Test
    void enemyDoDamage() {
    }

    @Test
    void attackCost() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }
}