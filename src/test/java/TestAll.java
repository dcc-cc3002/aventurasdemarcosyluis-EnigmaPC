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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        marco = new Marco(8, 9, 11, 40, 23);
        luis = new Luis(10, 11, 6, 51, 6);
        goomba = new Goomba(2, 3,4, 7, 0);
        spiny = new Spiny(17, 25,20, 90, 0);
        boo = new Boo(9, 13,11, 35, 0);
    }

    @org.junit.jupiter.api.Test
    public void testConstructor() {
        // Todos los Player y Enemigos vienen de Entities
        // de modo que solo se testea una vez.

        // HP y isDead
        assertEquals(marco.getMaxHP(),40);
        assertEquals(marco.getHP(),40);
        assertEquals(marco.isDead(), false);
        marco.setHP(-50);
        assertEquals(marco.getMaxHP(),40);
        assertEquals(marco.getHP(),0);
        assertEquals(marco.isDead(), true);
        marco.setHP(20);
        assertEquals(marco.getMaxHP(),40);
        assertEquals(marco.getHP(),20);
        assertEquals(marco.isDead(), false);
        marco.setHP(60);
        assertEquals(marco.getMaxHP(),40);
        assertEquals(marco.getHP(),40);
        assertEquals(marco.isDead(), false);

        // FP
        assertEquals(luis.getMaxFP(),6);
        assertEquals(luis.getFP(),6);
        luis.setFP(2);
        assertEquals(luis.getMaxFP(),6);
        assertEquals(luis.getFP(),2);
        luis.setFP(-30);
        assertEquals(luis.getMaxFP(),6);
        assertEquals(luis.getFP(),0);
        luis.setFP(70);
        assertEquals(luis.getMaxFP(),6);
        assertEquals(luis.getFP(),6);

        // LVL
        assertEquals(goomba.getLVL(), 2);
        goomba.setLVL(15);
        assertEquals(goomba.getLVL(), 15);
        goomba.setLVL(2);

        // ATK
        assertEquals(spiny.getATK(), 25);
        spiny.setATK(20);
        assertEquals(spiny.getATK(),20);
        spiny.setATK(25);

        // DEF
        assertEquals(boo.getDEF(), 11);
        boo.setDEF(1);
        assertEquals(boo.getDEF(),1);
        boo.setDEF(11);
    }
}
