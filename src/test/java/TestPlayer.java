import com.aventurasdemarcoyluis.Marco;
import com.aventurasdemarcoyluis.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPlayer {
    private Player p1;

    @BeforeEach
    public void setUp() {
        p1 = new Marco(8, 9, 11, 40, 23);
    }

    @Test
    public void constructorTest() {
        assertEquals(p1.getMaxHP(),40);
        assertEquals(p1.getHP(),40);
        p1.setHP(-50);
        assertEquals(p1.getMaxHP(),40);
        assertEquals(p1.getHP(),0);
    }
}
