package com.aventurasdemarcoyluis.model.abstract_classes;

import com.aventurasdemarcoyluis.model.attacks.HammerAttack;
import com.aventurasdemarcoyluis.model.attacks.JumpAttack;
import com.aventurasdemarcoyluis.model.enemies.Goomba;
import com.aventurasdemarcoyluis.model.enemies.Spiny;
import com.aventurasdemarcoyluis.model.players.Luis;
import com.aventurasdemarcoyluis.model.players.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AbstractEnemyTest extends BaseTest {

    @BeforeEach
    void setUp() {
        marco = new Marco(16,28,31,57,42);
        luis = new Luis(4,10,25,2,2);

        // Enemigos
        goomba = new Goomba(8, 9, 11, 40);
        spiny = new Spiny(16, 24, 35, 50);

        // Ataques
        hammer = new HammerAttack();
        jump = new JumpAttack();
    }

    @Test
    void damageToHurt() {
        // Se testa la cantidad de daño que debiese hacer un player a un enemigo,
        // con cierto ataque. Se ocupa la fórmula dada en el enunciado.
        // (Solo queremos la cantidad)
        // hammer : K = 1.5
        // jump : K = 1
        // spiny : DEF(35)
        // goomba : DEF(11)
        // marco : ATK(28) LVL(16)
        // luis : ATK(10) LVL(4)
        assertEquals(goomba.damageToHurt(luis,hammer),6);
        assertEquals(goomba.damageToHurt(luis,jump),4);
        assertEquals(goomba.damageToHurt(marco,hammer),61.5);
        assertEquals(goomba.damageToHurt(marco,jump),41);
        assertEquals(spiny.damageToHurt(marco,hammer),19.5);
        assertEquals(spiny.damageToHurt(luis,hammer),1.5);

    }
}