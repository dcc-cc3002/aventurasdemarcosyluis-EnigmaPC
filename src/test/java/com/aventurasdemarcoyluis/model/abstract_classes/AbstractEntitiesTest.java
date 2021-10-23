package com.aventurasdemarcoyluis.model.abstract_classes;

import com.aventurasdemarcoyluis.model.enemies.Boo;
import com.aventurasdemarcoyluis.model.enemies.Goomba;
import com.aventurasdemarcoyluis.model.enemies.Spiny;
import com.aventurasdemarcoyluis.model.players.Luis;
import com.aventurasdemarcoyluis.model.players.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractEntitiesTest extends BaseTest {

    @BeforeEach
    void setUp() {
        // Entidades
        marco = new Marco(8, 9, 11, 40, 23);
        luis = new Luis(10, 11, 6, 51, 6);
        goomba = new Goomba(2, 3, 4, 7);
        spiny = new Spiny(17, 25, 20, 90);
        boo = new Boo(9, 13, 11, 35);

        marco2 = new Marco(7, 8, 15, 6, 4);
        goomba2 = new Goomba(8, 9, 11, 40);
        spiny2 = new Spiny(16, 24, 35, 50);
        boo2 = new Boo(3, 6, 6, 35);
    }

    @Test
    void getDamage() {
        // La vida de marco es 40, si obtiene 3.5 de daño,
        // este se aproxima y termina recibiendo 4. Su próxima vida es 36.
        marco.getDamage(3.5);
        assertEquals(marco.getHP(),36);

        // La vida de boo es 35, si obtiene 50.3 de daño,
        // este se aproxima y termina recibiendo 50. Su próxima vida es 0.
        boo.getDamage(50.3);
        assertEquals(boo.getHP(),0);
    }

    @Test
    void testHP() {
        // Testearemos que no se pueda dar más HP al personaje que el maxHP.
        // marco tiene 40 de maxHP, y 40 de HP (no ha bajado su vida)
        assertEquals(marco.getMaxHP(),40);
        assertEquals(marco.getHP(),40);
        // seteamos la vida en "70", como sobrepasa maxHP, queda en el maxHP
        marco.setHP(70);
        assertEquals(marco.getMaxHP(),40); // No se modifica
        assertEquals(marco.getMaxHP(),marco.getHP());
        // seteamos la vida en "-70", como es menor a 0 de vida, queda en 0
        // pues no se puede tener -70 de vida
        marco.setHP(-70);
        assertEquals(marco.getMaxHP(),40); // No se modifica
        assertEquals(marco.getHP(),0);
        // seteamos la vida en 20
        marco.setHP(20);
        assertEquals(marco.getMaxHP(),40); // No se modifica
        assertEquals(marco.getHP(),20);
    }

    @Test
    void isNotDead() {
        // Actualmente marco está vivo, tiene 40 de maxHP
        assertTrue(marco.isNotDead());
        marco.setHP(-30); // Si queremos setear una vida<0 se vuelve 0
        assertFalse(marco.isNotDead());

        // Actualmente marco2 está vivo, tiene 6 de maxHP
        assertTrue(marco2.isNotDead());
        marco2.setHP(0); // La vida queda en 0
        assertFalse(marco2.isNotDead());

        // Actualmente luis está vivo, tiene 51 de maxHP
        assertTrue(luis.isNotDead());
        luis.setHP(40); // La vida queda en 40, sigue vivo
        assertTrue(luis.isNotDead());
        luis.setHP(-40); // La vida queda en 0
        assertFalse(luis.isNotDead());
    }

    @Test
    void testEquals() {
        assertFalse(marco.equals(marco2)); // Diferentes estadísticas, mismo Tipo (Marco) = diferentes
        assertFalse(marco.equals(luis)); // Diferentes estadísticas, diferente Tipo = diferentes
        assertFalse(marco.equals(goomba2)); // Mismas estadísticas, diferente Tipo = diferentes
        assertFalse(luis.equals(boo)); // Diferentes estadísticas, diferente Tipo = diferentes
        assertTrue(boo.equals(boo)); // Mismas estadísticas, mismo Tipo = iguales
        assertFalse(spiny.equals(spiny2)); // Diferentes estadísticas, mismo Tipo (Spiny) = diferentes
    }

    @Test
    void testHashCode() {
        assertNotEquals(marco.hashCode(),marco2.hashCode()); // Diferentes
        assertNotEquals(marco.hashCode(),luis.hashCode()); // Diferentes
        assertNotEquals(marco.hashCode(),goomba2.hashCode()); // Diferentes
        assertNotEquals(luis.hashCode(),boo.hashCode()); // Diferentes
        assertEquals(boo.hashCode(),boo.hashCode()); // Iguales
        assertNotEquals(spiny.hashCode(),spiny2.hashCode()); // Diferentes
        assertEquals(goomba.hashCode(),goomba.hashCode()); // Iguales
    }
}