package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.attacks.HammerAttack;
import com.aventurasdemarcoyluis.attacks.JumpAttack;
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
        luis = new Luis(4,10,25,2,2);
        marco2 = new Marco(16,28,31,57,42);
        luis2 = new Luis(9,12,11,18,7);

        // Items
        honeySyrup = new HoneySyrup();
        star = new Star();
        redMushroom = new RedMushroom();

        // Enemigos
        goomba = new Goomba(8, 9, 11, 40);
        spiny = new Spiny(16, 24, 35, 50);

        // Ataques
        hammer = new HammerAttack();
        jump = new JumpAttack();
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
    void enoughFP() {
        // Un player puede atacar si tiene más de 0 FP
        assertTrue(marco.enoughFP(hammer)); // marco tiene 42 FP
        luis.setFP(0); // seteamos para que luis tenga 0 de FP
        assertFalse(luis.enoughFP(jump));
        luis.setFP(1); // seteamos para que luis tenga 1 de FP
        assertFalse(luis.enoughFP(hammer)); // No puede atacar con Martillo
        luis.setFP(1); // seteamos para que luis tenga 0 de FP
        assertTrue(luis.enoughFP(jump));

        luis.setFP(2);
    }

    @Test
    void damageThornsSpiny() {
        // Las espinas de Spiny hacen que el atacante reciba un daño del 5 % de su HP
        // (se testea el daño que debería hacer)

        // luis tiene 2 de HP => el daño debería ser 0.1
        // luis2 tiene 18 de HP => el daño debería ser 0.9
        // marco tiene 57 de HP => el daño debería ser 2.85
        assertEquals(luis.damageThornsSpiny(), 0.1);
        assertEquals(luis2.damageThornsSpiny(), 0.9);
        assertEquals(marco.damageThornsSpiny(), 2.85);
    }

    /**
     * Se testean:
     * {@code enemyDoDamage},
     * {@code preDamage} (metodo de AbstractEntities).
     */
    @Test
    void enemyDoDamage() {
        // Se testa la cantidad de daño que debiese hacer un enemigo a un player
        // con la fórmula dada en el enunciado. (Solo queremos la cantidad)
        // Todos los enemigos tienen un K = 0.75
        // spiny : ATK(24) LVL(16)
        // goomba : ATK(9) LVL(8)
        // marco : DEF(31)
        // luis2 : DEF(11)
        assertEquals(marco.enemyDoDamage(spiny),9);
        assertEquals(marco.enemyDoDamage(goomba),2);
        assertEquals(luis2.enemyDoDamage(spiny),26);
        assertEquals(luis2.enemyDoDamage(goomba),5);
    }

    /**
     * Se testará:
     * {@code useHoneySyrup} por sí solo y
     * {@code useItem} que invocará el uso de honeySyrup.
     */
    @Test
    void useHoneySyrup() {
        // Restaura al personaje una cantidad de 3 FP
        // Como todos los jugadores están con el máximo de FP, seteamos menos FP.
        marco.setFP(20); // FP = 20, MaxFP = 42
        luis.setFP(0); // FP = 0, MaxFP = 2
        luis2.setFP(0); // FP = 0, MaxFP = 7
        // Los jugadores tienen inicialmente el inventario vacío,
        // así que les damos algunos items.
        marco.addItem(honeySyrup,2);
        luis.addItem(honeySyrup,1);
        luis2.addItem(honeySyrup,4);
        // Probamos que los FP aumenten si son menos que el maxFP
        assertEquals(marco.getFP(),20);
        marco.useHoneySyrup();
        assertEquals(marco.getFP(),23);
        marco.useItem(honeySyrup);
        assertEquals(marco.getFP(),26);
        // Probamos que los FP no sobrepasen el maxFP
        assertEquals(luis.getFP(),0);
        luis.useHoneySyrup();
        assertEquals(luis.getFP(),2);
        assertEquals(luis.getFP(),luis.getMaxFP());
        // Probamos que los FP no sobrepasen el maxFP
        assertEquals(luis2.getFP(),0);
        luis2.useHoneySyrup();
        assertEquals(luis2.getFP(),3);
        luis2.useItem(honeySyrup);
        assertEquals(luis2.getFP(),6);
        luis2.useHoneySyrup();
        assertEquals(luis2.getFP(),7); // Llegó al máximo de FP
        assertEquals(luis2.getFP(),luis2.getMaxFP());
        luis2.useHoneySyrup();
        assertEquals(luis2.getFP(),luis2.getMaxFP());

        // Seteamos los FP otra vez para que no afecte el código
        marco.setFP(42);
        luis.setFP(2);
        luis2.setFP(7);
    }

    /**
     * Se testará:
     * {@code useRedMushroom} por sí solo y
     * {@code useItem} que invocará el uso de redMushroom.
     */
    @Test
    void useRedMushroom() {
        // Cura al jugador una cantidad de 10 % del HP máximo del personaje.
        // Como todos los jugadores están con el máximo de vida, seteamos menos HP.
        marco.setHP(30); // Vida = 30, MaxVida = 57, 10% = 5.7 aprox 6
        luis.setHP(0); // Vida = 0, MaxVida = 2, 10% = 0.2 aprox 0
        luis2.setHP(13); // Vida = 13, MaxVida = 18, 10% = 1.8 aprox 2
        // Los jugadores tienen inicialmente el inventario vacío,
        // así q les damos algunos items.
        marco.addItem(redMushroom,2);
        luis.addItem(redMushroom,1);
        luis2.addItem(redMushroom,4);
        // Probamos que la vida aumente si el 10% > 0
        assertEquals(marco.getHP(),30);
        marco.useRedMushroom();
        assertEquals(marco.getHP(),36);
        marco.useItem(redMushroom);
        assertEquals(marco.getHP(),42);
        // Probamos que la vida no aumente si el 10% = 0
        assertEquals(luis.getHP(),0);
        luis.useRedMushroom();
        assertEquals(luis.getHP(),0);
        // Probamos que la vida aumente si el 10% > 0
        // pero que no sobrepase el máximo de vida posible
        assertEquals(luis2.getHP(),13);
        luis2.useRedMushroom();
        assertEquals(luis2.getHP(),15);
        luis2.useItem(redMushroom);
        assertEquals(luis2.getHP(),17);
        luis2.useRedMushroom();
        assertEquals(luis2.getHP(),18); // Llegó al máximo de vida
        assertEquals(luis2.getHP(),luis2.getMaxHP());
        luis2.useRedMushroom();
        assertEquals(luis2.getHP(),luis2.getMaxHP());

        // Seteamos la vida otra vez para que no afecte el código
        marco.setHP(57);
        luis.setHP(2);
        luis2.setHP(18);
    }

    /**
     * Se testará:
     * {@code useStar} por sí solo y
     * {@code useItem} que invocará el uso de star.
     */
    @Test
    void useStar() {
        // Hace que el personaje que la consuma entre al estado invencible.
        // Inicialmente ningún personaje está en el estado invencible
        // ni tienen items.
        assertFalse(marco.isInvincible());
        assertFalse(luis.isInvincible());
        marco.addItem(star,2);
        luis.addItem(star,2);
        // Usamos y ahora deben estar en estado invencible
        marco.useStar();
        luis.useStar();
        assertTrue(marco.isInvincible());
        assertTrue(luis.isInvincible());
        // Seteamos no invencible y ahora probamos con useItem
        marco.setInvincible(false);
        luis.setInvincible(false);
        marco.useItem(star);
        luis.useItem(star);
        assertTrue(marco.isInvincible());
        assertTrue(luis.isInvincible());
        // Seteamos no invencible para que no afecte el código
        marco.setInvincible(false);
        luis.setInvincible(false);
    }

    /**
     * Se prueban:
     * {@code attackCost} de AbstractPlayer y
     * {@code getFPCost} de AbstractAttackType.
     */
    @Test
    void useFPtoAttack() {
        // Setea un nuevo FP, luego del uso de un ataque
        // hammer : FPCost = 2
        // jump : FPCost = 1
        // marco tiene 42 de FP
        assertEquals(marco.getFP(),42);
        marco.useFPtoAttack(hammer);
        assertEquals(marco.getFP(), 40);
        marco.useFPtoAttack(hammer);
        assertEquals(marco.getFP(), 38);
        marco.useFPtoAttack(jump);
        assertEquals(marco.getFP(), 37);
        marco.useFPtoAttack(jump);
        assertEquals(marco.getFP(), 36);
        // luis2 tiene 7 de FP
        assertEquals(luis2.getFP(),7);
        luis2.useFPtoAttack(hammer);
        assertEquals(luis2.getFP(), 5);
        luis2.useFPtoAttack(hammer);
        assertEquals(luis2.getFP(), 3);
        luis2.useFPtoAttack(jump);
        assertEquals(luis2.getFP(), 2);
        luis2.useFPtoAttack(jump);
        assertEquals(luis2.getFP(), 1);
        luis2.useFPtoAttack(hammer);
        assertEquals(luis2.getFP(), 0); // Sobran -1 de FP pero llega a 0.

        // Volvemos a setear los FP para que no afecte el código
        marco.setFP(42);
        luis2.setFP(7);
    }

    @Test
    void testEquals() {
        // Sabemos por los test de AbstractEntities que se cumple que
        // marco =/= luis, goomba =/= spiny, spiny =/= marco, etc.
        // Ahora se probará que marco =/= marco2, si tienen distinto inventario
        // o estado (cambio de FP, invenciblidad, etc), aunque tengan las mismas estadísticas.
        // Primero, sabemos que marco y marco2 tienen las mismas estadísticas,
        // inventario (vacío) y estado, por lo que son iguales.
        assertTrue(marco.equals(marco2));
        // Si añadimos items, ya no son iguales
        marco.addItem(star,1);
        assertFalse(marco.equals(marco2));
        // Si añadimos los mismos items, sí.
        marco2.addItem(star,1);
        assertTrue(marco.equals(marco2));
        // Si cambia el estado de uno, ya no son iguales
        marco.useItem(star);
        assertFalse(marco.equals(marco2));
        // Si cambia el estado del otro al mismo, son iguales
        marco2.useItem(star);
        assertTrue(marco.equals(marco2));
        // Si se cambia algun estado FP, HP, etc, ya no son iguales
        marco.useFPtoAttack(hammer);
        assertFalse(marco.equals(marco2));
        // Si el otro sí ocupa el mismo ataque, sí.
        marco2.useFPtoAttack(hammer);
        assertTrue(marco.equals(marco2));
    }

    @Test
    void testHashCode() {
        assertEquals(marco.hashCode(),marco2.hashCode());
        // Si añadimos items, ya no son iguales
        marco.addItem(star,1);
        assertNotEquals(marco.hashCode(),marco2.hashCode());
        // Si añadimos los mismos items, sí.
        marco2.addItem(star,1);
        assertEquals(marco.hashCode(),marco2.hashCode());
        // Si cambia el estado de uno, ya no son iguales
        marco.useItem(star);
        assertNotEquals(marco.hashCode(),marco2.hashCode());
        // Si cambia el estado del otro al mismo, son iguales
        marco2.useItem(star);
        assertEquals(marco.hashCode(),marco2.hashCode());
        // Si se cambia algun estado FP, HP, etc, ya no son iguales
        marco.useFPtoAttack(hammer);
        assertNotEquals(marco.hashCode(),marco2.hashCode());
        // Si el otro sí ocupa el mismo ataque, sí.
        marco2.useFPtoAttack(hammer);
        assertEquals(marco.hashCode(),marco2.hashCode());
    }
}