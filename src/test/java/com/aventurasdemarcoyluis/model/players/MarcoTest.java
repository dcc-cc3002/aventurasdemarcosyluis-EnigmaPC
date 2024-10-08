package com.aventurasdemarcoyluis.model.players;

import com.aventurasdemarcoyluis.model.abstract_classes.BaseTest;
import com.aventurasdemarcoyluis.model.attacks.HammerAttack;
import com.aventurasdemarcoyluis.model.attacks.JumpAttack;
import com.aventurasdemarcoyluis.model.enemies.Boo;
import com.aventurasdemarcoyluis.model.enemies.Goomba;
import com.aventurasdemarcoyluis.model.enemies.Spiny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarcoTest extends BaseTest {

    @BeforeEach
    void setUp() {
        // Luis
        marco = new Marco(19,22,16,59,13);

        // Enemigos
        goomba = new Goomba(24,26,29,49);
        spiny = new Spiny(11,5,14,19);
        boo = new Boo(14,16,19,19);

        // Ataques
        hammer = new HammerAttack();
        jump = new JumpAttack();
    }

    @Test
    void attack() {
        // El daño del ataque se calcula con la fórmula entregada en el ReadMe
        // Probemos que también se van gastando los FP
        // goomba, daño martillo = 21, salto = 14
        // spiny, daño martillo = 45, salto no le hace daño
        // boo, daño martillo no le hace daño, salto = 33


        // TESTEO DE MARTILLO
        // Se prueba la semilla 3, la cual genera los siguientes enteros entre
        // 1 y 4 en 7 llamadas:
        // 4 - 0 - 0 - 1 - 3 - 2 - 4
        // Si sale 0, el ataque falla (se elige que 0 sea el fallo)
        hammer.setSeed(3);

        // Goomba
        marco.attack(goomba,hammer);
        assertTrue(goomba.getHP() == 28);
        assertTrue(marco.getFP() == 11);
        marco.attack(goomba,hammer); // Ataque Fallido
        assertTrue(goomba.getHP() == 28);
        assertTrue(marco.getFP() == 9);
        marco.attack(goomba,hammer); // Ataque Fallido
        assertTrue(goomba.getHP() == 28);
        assertTrue(marco.getFP() == 7);
        marco.attack(goomba,hammer);
        assertTrue(goomba.getHP() == 7);
        assertTrue(marco.getFP() == 5);

        // Spiny
        marco.attack(spiny,hammer);
        assertTrue(spiny.getHP() == 0);
        assertTrue(marco.getFP() == 3);


        // Boo no le hace nada martillo
        marco.attack(boo,hammer);
        assertTrue(boo.getHP() == 19);
        assertTrue(marco.getFP() == 1);

        // TESTEO DE SALTO
        goomba = new Goomba(24,26,29,49);
        spiny = new Spiny(11,5,14,19);
        boo = new Boo(14,16,19,19);
        marco = new Marco(19,22,16,59,11);
        // Goomba
        marco.attack(goomba,jump);
        assertTrue(goomba.getHP() == 35);
        assertTrue(marco.getFP() == 10);
        marco.attack(goomba,jump);
        assertTrue(goomba.getHP() == 21);
        assertTrue(marco.getFP() == 9);
        marco.attack(goomba,jump);
        assertTrue(goomba.getHP() == 7);
        assertTrue(marco.getFP() == 8);
        marco.attack(goomba,jump);
        assertTrue(goomba.getHP() == 0);
        assertTrue(marco.getFP() == 7);
        // Spiny no le hace daño salto, Marco recibe un daño del 5% de su HP
        marco.attack(spiny,jump);
        assertTrue(spiny.getHP() == 19);
        assertTrue(marco.getFP() == 6);
        assertTrue(marco.getHP() == 56);
        marco.attack(spiny,jump);
        assertTrue(spiny.getHP() == 19);
        assertTrue(marco.getFP() == 5);
        assertTrue(marco.getHP() == 53);
        marco.attack(spiny,jump);
        assertTrue(spiny.getHP() == 19);
        assertTrue(marco.getFP() == 4);
        assertTrue(marco.getHP() == 50);
        marco.attack(spiny,jump);
        assertTrue(spiny.getHP() == 19);
        assertTrue(marco.getFP() == 3);
        assertTrue(marco.getHP() == 47);
        // Boo
        marco.attack(boo,jump);
        assertTrue(boo.getHP() == 0);
        assertTrue(marco.getFP() == 2);
        // Si un enemigo muere, marco no ataca por lo que no pierde FP
        marco.attack(boo,jump);
        assertTrue(boo.getHP() == 0);
        assertTrue(marco.getFP() == 2);

        // Hacemos que pierda los FP
        marco.attack(spiny,jump);
        assertTrue(spiny.getHP() == 19);
        assertTrue(marco.getFP() == 1);
        assertTrue(marco.getHP() == 45);
        // Pero antes, veamos que marco no puede atacar con Martillo
        // pues tiene 1 FP y cuesta 2 FP
        marco.attack(spiny,hammer);
        assertTrue(spiny.getHP() == 19);
        assertTrue(marco.getFP() == 1);
        assertTrue(marco.getHP() == 45);
        marco.attack(spiny,jump);
        assertTrue(spiny.getHP() == 19);
        assertTrue(marco.getFP() == 0);
        assertTrue(marco.getHP() == 43);

        // Si pierde los FP no puede atacar y no le pasa nada
        marco.attack(spiny,jump);
        assertTrue(spiny.getHP() == 19);
        assertTrue(marco.getFP() == 0);
        assertTrue(marco.getHP() == 43);
        marco.attack(spiny,jump);
        assertTrue(spiny.getHP() == 19);
        assertTrue(marco.getFP() == 0);
        assertTrue(marco.getHP() == 43);
    }

    @Test
    void attackedByGoomba() {
        marco = new Marco(19,22,16,59,11);
        // Con la fórmula del Daño sabemos que Goomba hace 29 de daño por hit.
        marco.attackedByGoomba(goomba);
        assertEquals(marco.getHP(),30);
        marco.attackedByGoomba(goomba);
        assertEquals(marco.getHP(),1);
        marco.attackedByGoomba(goomba);
        assertEquals(marco.getHP(),0);
        marco.attackedByGoomba(goomba);
        assertEquals(marco.getHP(),0);
    }

    @Test
    void attackedBySpiny() {
        marco = new Marco(19,22,16,59,11);
        // Con la fórmula del Daño sabemos que Spiny hace 2 de daño por hit.
        marco.attackedBySpiny(spiny);
        assertEquals(marco.getHP(),57);
        marco.attackedBySpiny(spiny);
        assertEquals(marco.getHP(),55);
        marco.attackedBySpiny(spiny);
        assertEquals(marco.getHP(),53);
        marco.attackedBySpiny(spiny);
        assertEquals(marco.getHP(),51);
        marco.attackedBySpiny(spiny);
        assertEquals(marco.getHP(),49);
        marco.attackedBySpiny(spiny);
        assertEquals(marco.getHP(),47);
    }

    @Test
    void isLuis() {
        assertFalse(marco.isLuis());
    }
}