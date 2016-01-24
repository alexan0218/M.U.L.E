/**
 * @author Wenzhong Jin
 * Player.sellEnergy test
 */
package mule;

//import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javafx.scene.paint.Color;


public class sellEnergyTest {
    private static final int TIMEOUT = 200;
    private Player player;

    @Before
    public void setup() {
        player = new Player("Daniel", "HUMAN", Color.NAVY, 5, "Intermediate");
    }

    @Test(timeout = TIMEOUT)
    public void sellEnergyTesty() {
        player.setEnergy(100);
        assertEquals(100, player.getEnergy());
        assertEquals(600, player.getMoney());
        assertTrue(player.sellEnergy());
        assertEquals(99, player.getEnergy());
        assertEquals(625, player.getMoney());
    }

    @Test(timeout = TIMEOUT)
    public void sellEnergyTestn() {
        player.setEnergy(0);
        assertEquals(0, player.getEnergy());
        assertEquals(600, player.getMoney());
        assertFalse(player.sellEnergy());
        assertEquals(0, player.getEnergy());
        assertEquals(600, player.getMoney());
    }
}
