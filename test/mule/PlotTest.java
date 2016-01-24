/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;

import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CinaSMY
 */
public class PlotTest {
    
    public PlotTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSetTag() {
        System.out.println("setTag");
        int tag = 5;
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        instance.setTag(tag);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(5, instance.getTag());
    }

    @Test
    public void testGetTag() {
        System.out.println("getTag");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        int expResult = 10;
        int result = instance.getTag();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMule() {
        System.out.println("getMule");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        MultiUsage expResult = null;
        MultiUsage result = instance.getMule();
        assertEquals(expResult, result);
        expResult = new MultiUsage(1);
        instance.setMule(expResult);
        result = instance.getMule();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetMule() {
        System.out.println("setMule");
        MultiUsage m = new MultiUsage(2);
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        instance.setMule(m);
        assertEquals(m, instance.getMule());
    }

    @Test
    public void testSetOwned() {
        System.out.println("setOwned");
        boolean isOwned = true;
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        assertFalse(instance.isOwned());
        instance.setOwned(isOwned);
        assertTrue(instance.isOwned());
    }

    @Test
    public void testIsOwned() {
        System.out.println("isOwned");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        boolean expResult = false;
        boolean result = instance.isOwned();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetOwner() {
        System.out.println("setOwner");
        Player player = new Player("Cina", "HUMAN", Color.RED, 1, "Intermediate");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        assertEquals(null, instance.getOwner());
        instance.setOwner(player);
        assertEquals(player, instance.getOwner());
    }

    @Test
    public void testGetOwner() {
        System.out.println("getOwner");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        Player expResult = new Player("Cina", "HUMAN", Color.RED, 1, "Intermediate");
        instance.setOwner(expResult);
        Player result = instance.getOwner();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFoodProduction() {
        System.out.println("getFoodProduction");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        int expResult = 1;
        int result = instance.getFoodProduction();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetFoodProduction() {
        System.out.println("setFoodProduction");
        int food = 0;
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        assertEquals(1, instance.getFoodProduction());
        instance.setFoodProduction(food);
        assertEquals(0, instance.getFoodProduction());
    }

    @Test
    public void testGetEnergyProduction() {
        System.out.println("getEnergyProduction");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        int expResult = 2;
        int result = instance.getEnergyProduction();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetEnergyProduction() {
        System.out.println("setEnergyProduction");
        int energy = 0;
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        assertEquals(2, instance.getEnergyProduction());
        instance.setEnergyProduction(energy);
        assertEquals(0, instance.getEnergyProduction());
    }

    @Test
    public void testGetOreProduction() {
        System.out.println("getOreProduction");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        int expResult = 3;
        int result = instance.getOreProduction();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetOreProduction() {
        System.out.println("setOreProduction");
        int ore = 0;
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        assertEquals(3, instance.getOreProduction());
        instance.setOreProduction(ore);
        assertEquals(0, instance.getOreProduction());
    }

    @Test
    public void testGetCrystiteProduction() {
        System.out.println("getCrystiteProduction");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        int expResult = 4;
        int result = instance.getCrystiteProduction();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCrystiteProduction() {
        System.out.println("setCrystiteProduction");
        int crystite = 0;
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        assertEquals(4, instance.getCrystiteProduction());
        instance.setCrystiteProduction(crystite);
        assertEquals(0, instance.getCrystiteProduction());
    }
    
}
