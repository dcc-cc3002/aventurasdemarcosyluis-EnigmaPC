import com.aventurasdemarcoyluis.Marco;
import com.aventurasdemarcoyluis.Luis;
import com.aventurasdemarcoyluis.Goomba;
import com.aventurasdemarcoyluis.Spiny;
import com.aventurasdemarcoyluis.Boo;
import com.aventurasdemarcoyluis.HoneySyrup;
import com.aventurasdemarcoyluis.Star;
import com.aventurasdemarcoyluis.RedMushroom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAll {
    private Marco marco;
    private Luis luis;
    private Goomba goomba;
    private Spiny spiny;
    private Boo boo;
    private HoneySyrup honeySyrup;
    private Star star;
    private RedMushroom redMushroom;

    @BeforeEach
    public void setUp() {
        // Entidades
        marco = new Marco(8, 9, 11, 40, 23);
        luis = new Luis(10, 11, 6, 51, 6);
        goomba = new Goomba(2, 3, 4, 7, 0);
        spiny = new Spiny(17, 25, 20, 90, 0);
        boo = new Boo(9, 13, 11, 35, 0);

        // Objetos
        honeySyrup = new HoneySyrup();
        star = new Star();
        redMushroom = new RedMushroom();
    }

    @Test
    public void testEntities() {
        // Todos los Player y Enemigos vienen de Entities
        // de modo que solo se testea una vez.

        // HP y isDead
        assertEquals(marco.getMaxHP(), 40);
        assertEquals(marco.getHP(), 40);
        assertEquals(marco.isDead(), false);
        marco.setHP(-50);
        assertEquals(marco.getMaxHP(), 40);
        assertEquals(marco.getHP(), 0);
        assertEquals(marco.isDead(), true);
        marco.setHP(20);
        assertEquals(marco.getMaxHP(), 40);
        assertEquals(marco.getHP(), 20);
        assertEquals(marco.isDead(), false);
        marco.setHP(60);
        assertEquals(marco.getMaxHP(), 40);
        assertEquals(marco.getHP(), 40);
        assertEquals(marco.isDead(), false);

        // FP
        assertEquals(luis.getMaxFP(), 6);
        assertEquals(luis.getFP(), 6);
        luis.setFP(2);
        assertEquals(luis.getMaxFP(), 6);
        assertEquals(luis.getFP(), 2);
        luis.setFP(-30);
        assertEquals(luis.getMaxFP(), 6);
        assertEquals(luis.getFP(), 0);
        luis.setFP(70);
        assertEquals(luis.getMaxFP(), 6);
        assertEquals(luis.getFP(), 6);

        // LVL
        assertEquals(goomba.getLVL(), 2);
        goomba.setLVL(15);
        assertEquals(goomba.getLVL(), 15);
        goomba.setLVL(2);

        // ATK
        assertEquals(spiny.getATK(), 25);
        spiny.setATK(20);
        assertEquals(spiny.getATK(), 20);
        spiny.setATK(25);

        // DEF
        assertEquals(boo.getDEF(), 11);
        boo.setDEF(1);
        assertEquals(boo.getDEF(), 1);
        boo.setDEF(11);

        // maxHP
        assertEquals(boo.getMaxHP(), 35);
        boo.setMaxHP(37);
        assertEquals(boo.getMaxHP(), 37);
        boo.setMaxHP(35);

        // maxFP
        assertEquals(luis.getMaxFP(), 6);
        luis.setMaxFP(15);
        assertEquals(luis.getMaxFP(), 15);
        luis.setMaxFP(6);
    }

    @Test
    public void testPlayerAndItem() {
        // Marco y Luis son players, testeamos con ellos.

        // Star e Inventario
        assertEquals(marco.isInvincible(), false);
        assertEquals(marco.hasItem(star), false);
        marco.useItem(star);
        assertNotEquals(marco.isInvincible(), true);
        assertEquals(marco.amountOfItem(star), 0);
        marco.removeItem(star, 10);
        assertEquals(marco.hasItem(star), false);
        assertEquals(marco.amountOfItem(star), 0);
        marco.addItem(star, 1);
        assertEquals(marco.hasItem(star), true);
        assertEquals(marco.amountOfItem(star), 1);
        marco.useItem(star);
        assertEquals(marco.hasItem(star), false);
        assertEquals(marco.amountOfItem(star), 0);
        assertEquals(marco.isInvincible(), true);
        marco.setInvincible(false);
        assertEquals(marco.isInvincible(), false);

        // RedMushroom e Inventario
        marco.setHP(20); // Vida Máxima es 40
        assertEquals(marco.hasItem(redMushroom), false);
        assertEquals(marco.amountOfItem(redMushroom), 0);
        marco.useItem(redMushroom);
        assertEquals(marco.getHP(), 20);
        marco.removeItem(redMushroom, 15);
        assertEquals(marco.hasItem(redMushroom), false);
        assertEquals(marco.amountOfItem(redMushroom), 0);
        marco.addItem(redMushroom, 3);
        assertEquals(marco.hasItem(redMushroom), true);
        assertEquals(marco.amountOfItem(redMushroom), 3);
        marco.removeItem(redMushroom,1);
        assertEquals(marco.hasItem(redMushroom), true);
        assertEquals(marco.amountOfItem(redMushroom), 2);
        marco.useItem(redMushroom);
        assertEquals(marco.hasItem(redMushroom), true);
        assertEquals(marco.amountOfItem(redMushroom), 1);
        assertEquals(marco.getHP(),24);
        marco.useItem(redMushroom);
        assertEquals(marco.hasItem(redMushroom), false);
        assertEquals(marco.amountOfItem(redMushroom), 0);
        assertEquals(marco.getHP(),28);
        marco.setHP(50);
        marco.addItem(redMushroom, 1);
        marco.useItem(redMushroom);
        assertEquals(marco.getHP(),40);

        // Honey Syrup
        marco.setFP(10); // FP Máximos son 23
        marco.useItem(honeySyrup);
        assertEquals(marco.getFP(), 13); /*
        marco.useItem(honeySyrup);
        assertEquals(marco.getFP(), 16);
        marco.setFP(23);*/
    }
}
