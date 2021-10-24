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

class LuisTest extends BaseTest {

    @BeforeEach
    void setUp() {
        // Luis
        luis = new Luis(20,23,17,60,12);

        // Enemigos
        goomba = new Goomba(25,27,30,50);
        spiny = new Spiny(13,6,15,20);
        boo = new Boo(15,17,20,20);

        // Ataques
        hammer = new HammerAttack();
        jump = new JumpAttack();
    }

    @Test
    void attackTest() {
        // El daño del ataque se calcula con la fórmula entregada en el ReadMe
        // Probemos que también se van gastando los FP
        // goomba, daño martillo = 23, salto = 15
        // spiny, daño martillo = 35, salto no le hace daño


        // TESTE0 DE MARTILLO
        // Se prueba la semilla 0, la cual genera los siguientes enteros entre
        // 1 y 4 en 7 llamadas:
        // 0 - 3 - 4 - 2 - 0 - 3 - 1
        // Si sale 0, el ataque falla (se elige que 0 sea el fallo)
        hammer.setSeed(0);

        // Goomba
        luis.attack(goomba,hammer); // Ataque Fallido
        assertTrue(goomba.getHP() == 50);
        assertTrue(luis.getFP() == 10);

        luis.attack(goomba,hammer);
        assertTrue(goomba.getHP() == 27);
        assertTrue(luis.getFP() == 8);

        luis.attack(goomba,hammer);
        assertTrue(goomba.getHP() == 4);
        assertTrue(luis.getFP() == 6);

        luis.attack(goomba,hammer);
        assertTrue(goomba.getHP() == 0);
        assertTrue(luis.getFP() == 4);

        // Spiny
        luis.attack(spiny,hammer); // Ataque Fallido
        assertTrue(spiny.getHP() == 20);
        assertTrue(luis.getFP() == 2);

        luis.attack(spiny,hammer);
        assertTrue(spiny.getHP() == 0);
        assertTrue(luis.getFP() == 0);

        // TESTEO DE SALTO
        goomba = new Goomba(25,27,30,50);
        spiny = new Spiny(13,6,15,20);
        luis = new Luis(20,23,17,60,7);
        // Goomba
        luis.attack(goomba,jump);
        assertTrue(goomba.getHP() == 35);
        assertTrue(luis.getFP() == 6);
        luis.attack(goomba,jump);
        assertTrue(goomba.getHP() == 20);
        assertTrue(luis.getFP() == 5);
        luis.attack(goomba,jump);
        assertTrue(goomba.getHP() == 5);
        assertTrue(luis.getFP() == 4);
        luis.attack(goomba,jump);
        assertTrue(goomba.getHP() == 0);
        assertTrue(luis.getFP() == 3);
        // Si un enemigo muere, luis, no ataca y no pierde FP
        luis.attack(goomba,jump);
        assertTrue(goomba.getHP() == 0);
        assertTrue(luis.getFP() == 3);
        // Spiny no recibe daño y daña a Luis con un 5% de su HP
        luis.attack(spiny,jump);
        assertTrue(spiny.getHP() == 20);
        assertTrue(luis.getFP() == 2);
        assertTrue(luis.getHP() == 57);
        luis.attack(spiny,jump);
        assertTrue(spiny.getHP() == 20);
        assertTrue(luis.getFP() == 1);
        assertTrue(luis.getHP() == 54);
        // Ahora que luis tiene 1 FP veamos que no puede atacar con
        // Martillo pues cuesta 2 FP
        luis.attack(spiny,hammer);
        assertTrue(spiny.getHP() == 20);
        assertTrue(luis.getFP() == 1);
        assertTrue(luis.getHP() == 54);
        luis.attack(spiny,jump); // Pero con salto si puede atacar y se le resta vida
        assertTrue(spiny.getHP() == 20);
        assertTrue(luis.getFP() == 0);
        assertTrue(luis.getHP() == 51);

        // Si se queda sin FP no hace nada, no puede atacar
        // aunque use Martillo o Salto
        luis.attack(spiny,jump);
        assertTrue(spiny.getHP() == 20);
        assertTrue(luis.getFP() == 0);
        assertTrue(luis.getHP() == 51);
        luis.attack(spiny,jump);
        assertTrue(spiny.getHP() == 20);
        assertTrue(luis.getFP() == 0);
        assertTrue(luis.getHP() == 51);
        luis.attack(spiny,hammer);
        assertTrue(spiny.getHP() == 20);
        assertTrue(luis.getFP() == 0);
        assertTrue(luis.getHP() == 51);
    }

    @Test
    void attackedByBooTest() {
        luis = new Luis(20,23,17,60,7);
        // Con la fórmula del Daño sabemos que Boo hace 11 de daño por hit.
        luis.attackedByBoo(boo);
        assertEquals(luis.getHP(),49);
        luis.attackedByBoo(boo);
        assertEquals(luis.getHP(),38);
        luis.attackedByBoo(boo);
        assertEquals(luis.getHP(),27);
        luis.attackedByBoo(boo);
        assertEquals(luis.getHP(),16);
        luis.attackedByBoo(boo);
        assertEquals(luis.getHP(),5);
        luis.attackedByBoo(boo);
        assertEquals(luis.getHP(),0);
    }

    @Test
    void attackedByGoombaTest() {
        luis = new Luis(20,23,17,60,7);
        // Con la fórmula del Daño sabemos que Goomba hace 30 de daño por hit.
        luis.attackedByGoomba(goomba);
        assertEquals(luis.getHP(),30);
        luis.attackedByGoomba(goomba);
        assertEquals(luis.getHP(),0);
        luis.attackedByGoomba(goomba);
        assertEquals(luis.getHP(),0);
    }

    @Test
    void attackedBySpinyTest() {
        luis = new Luis(20,23,17,60,7);
        // Con la fórmula del Daño sabemos que Spiny hace 4 de daño por hit.
        luis.attackedBySpiny(spiny);
        assertEquals(luis.getHP(),56);
        luis.attackedBySpiny(spiny);
        assertEquals(luis.getHP(),52);
        luis.attackedBySpiny(spiny);
        assertEquals(luis.getHP(),48);
        luis.attackedBySpiny(spiny);
        assertEquals(luis.getHP(),44);
        luis.attackedBySpiny(spiny);
        assertEquals(luis.getHP(),40);
        luis.attackedBySpiny(spiny);
        assertEquals(luis.getHP(),36);
    }
}