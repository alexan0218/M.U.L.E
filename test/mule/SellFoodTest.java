package mule;

import java.util.Random;
import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chris
 */
public class SellFoodTest {

    /*public PlayerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        Player player = new Player("A", "FLAPPER", Color.BLACK, 4);
    }

    @AfterClass
    public static void tearDownClass() {
    }*/

    @Before
    public void setUp() {
         Player player = new Player("A", "FLAPPER", Color.BLACK, 4, "Intermediate");
    }

    /*@After
    public void tearDown() {
    }*/

    /**
     * Test of sellFood method, of class Player.
     */
    @Test
    public void testSellFood() {
        System.out.println("sellFood");
        Player player = new Player("A", "FLAPPER", Color.BLACK, 4, "Intermediate");
        Random r = new Random();
        int amount = r.nextInt(100);
        player.setFood(amount);
        assertEquals(amount, player.getFood());
        assertEquals(1600, player.getMoney());

        assertTrue(player.sellFood());
        assertEquals(amount - 1, player.getFood());
        assertEquals(1630, player.getMoney());

    }

    @Test
    public void TestSellFood2() {
        Player player = new Player("A", "FLAPPER", Color.BLACK, 4, "Intermediate");
        player.setFood(0);
        //Player player = new Player("A", "FLAPPER", BLACK, 4);
        boolean expResult = false;
        boolean result = player.sellFood();
        assertEquals(expResult, result);

        assertEquals(0, player.getFood());
        assertEquals(1600, player.getMoney());

        assertFalse(player.sellFood());
        assertEquals(0, player.getFood());
        assertEquals(1600, player.getMoney());
    }
        // TODO review the generated test code and remove the default call to fail.

}
