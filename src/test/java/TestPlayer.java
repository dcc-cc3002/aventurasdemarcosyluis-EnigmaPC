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

public class TestPlayer {
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

    }

    @Test
    public void testConstructor() {
        // Todos los Player y Enemigos vienen de Entities
        // de modo que solo se testea una vez.
        // HP
        assertEquals(marco.getMaxHP(),40);
        assertEquals(marco.getHP(),40);
        marco.setHP(-50);
        assertEquals(marco.getMaxHP(),40);
        assertEquals(marco.getHP(),0);
        marco.setHP(60);
        assertEquals(marco.getMaxHP(),40);
        assertEquals(marco.getHP(),40);
        // FP
        assertEquals(luis.getMaxFP(),6);
        assertEquals(luis.getFP(),6);
        marco.setFP(2);
        assertEquals(luis.getFP(),2);
        marco.setFP(-30);
        assertEquals(luis.getMaxHP(),6);
        assertEquals(luis.getHP(),0);
        // Para
    }
}
