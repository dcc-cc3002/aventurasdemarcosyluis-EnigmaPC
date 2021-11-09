package com.aventurasdemarcoyluis.model.abstract_classes;

import com.aventurasdemarcoyluis.model.attacks.HammerAttack;
import com.aventurasdemarcoyluis.model.attacks.JumpAttack;
import com.aventurasdemarcoyluis.model.enemies.Goomba;
import com.aventurasdemarcoyluis.model.enemies.Spiny;
import com.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.aventurasdemarcoyluis.model.items.RedMushroom;
import com.aventurasdemarcoyluis.model.players.Luis;
import com.aventurasdemarcoyluis.model.players.Marco;
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
        redMushroom = new RedMushroom();

        // Enemigos
        goomba = new Goomba(8, 9, 11, 40);
        spiny = new Spiny(16, 24, 35, 50);

        // Ataques
        hammer = new HammerAttack();
        jump = new JumpAttack();
    }

    @Test
    void isPlayer() {
        assertTrue(marco.isPlayer());
        assertTrue(luis.isPlayer());
        assertTrue(marco2.isPlayer());
        assertTrue(luis2.isPlayer());
    }

    @Test
    void playerToString() {
        assertEquals(marco.playerToString(), "Marco | nivel: 16, ataque: 28, defensa: 31, vida: 57, fp: 42");
        assertEquals(luis.playerToString(), "Luis | nivel: 4, ataque: 10, defensa: 25, vida: 2, fp: 2");
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
     * {@code useHoneySyrup} por sí solo
     */
    @Test
    void useHoneySyrup() {
        // Restaura al personaje una cantidad de 3 FP
        // Como todos los jugadores están con el máximo de FP, seteamos menos FP.
        marco.setFP(20); // FP = 20, MaxFP = 42
        luis.setFP(0); // FP = 0, MaxFP = 2
        luis2.setFP(0); // FP = 0, MaxFP = 7
        // Probamos que los FP aumenten si son menos que el maxFP
        assertEquals(marco.getFP(),20);
        marco.useHoneySyrup();
        assertEquals(marco.getFP(),23);
        marco.useHoneySyrup();
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
        luis2.useHoneySyrup();
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
     * {@code useRedMushroom} por sí solo
     */
    @Test
    void useRedMushroom() {
        // Cura al jugador una cantidad de 10 % del HP máximo del personaje.
        // Como todos los jugadores están con el máximo de vida, seteamos menos HP.
        marco.setHP(30); // Vida = 30, MaxVida = 57, 10% = 5.7 aprox 6
        luis.setHP(0); // Vida = 0, MaxVida = 2, 10% = 0.2 aprox 0
        luis2.setHP(13); // Vida = 13, MaxVida = 18, 10% = 1.8 aprox 2
        // Probamos que la vida aumente si el 10% > 0
        assertEquals(marco.getHP(),30);
        marco.useRedMushroom();
        assertEquals(marco.getHP(),36);
        marco.useRedMushroom();
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
        luis2.useRedMushroom();
        assertEquals(luis2.getHP(),17);
        luis2.useRedMushroom();
        assertEquals(luis2.getHP(),18); // Llegó al máximo de vida
        assertEquals(luis2.getHP(),luis2.getMaxHP());
        luis2.useRedMushroom();
        assertEquals(luis2.getHP(),luis2.getMaxHP());
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
    }

    @Test
    void levelUP() {
        //marco = new Marco(16,28,31,57,42);
        //luis = new Luis(4,10,25,2,2);
        marco.levelUP();
        assertEquals(marco.getLVL(),17);
        assertEquals(marco.getATK(),32);
        assertEquals(marco.getDEF(),36);
        assertEquals(marco.getMaxHP(),66);
        assertEquals(marco.getMaxFP(),48);

        luis.levelUP();
        assertEquals(luis.getLVL(),5);
        assertEquals(luis.getATK(),12);
        assertEquals(luis.getDEF(),29);
        assertEquals(luis.getMaxHP(),2);
        assertEquals(luis.getMaxFP(),2);
    }
}