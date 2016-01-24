/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author YICHEN & Mengyang Shi
 */
public class StoreTest {
    
    public StoreTest() {
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

    /**
     * Test of getFood method, of class Store.
     */
    @Test
    public void testGetFood() {
        System.out.println("getFood");
        Store store = new Store("Intermediate");
        int expResult = 16;
        int result = store.getFood();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEnergy method, of class Store.
     */
    @Test
    public void testGetEnergy() {
        System.out.println("getEnergy");
        Store store = new Store("Intermediate");
        int expResult = 16;
        int result = store.getEnergy();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOre method, of class Store.
     */
    @Test
    public void testGetOre() {
        System.out.println("getOre");
        Store store = new Store("Intermediate");
        int expResult = 0;
        int result = store.getOre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCrystite method, of class Store.
     */
    @Test
    public void testGetCrystite() {
        System.out.println("getCrystite");
        Store store = new Store("Intermediate");
        int expResult = 0;
        int result = store.getCrystite();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMules method, of class Store.
     */
    @Test
    public void testGetMules() {
        System.out.println("getMules");
        Store store = new Store("Intermediate");
        int expResult = 25;
        int result = store.getMules();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFood method, of class Store.
     */
    @Test
    public void testSetFood() {
        System.out.println("setFood");
        Store store = new Store("Intermediate");
        store.setFood(10);
        int expResult = 10;
        int result = store.getFood();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEnergy method, of class Store.
     */
    @Test
    public void testSetEnergy() {
        System.out.println("setEnergy");
        Store store = new Store("Intermediate");
        store.setEnergy(10);
        int expResult = 10;
        int result = store.getEnergy();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOre method, of class Store.
     */
    @Test
    public void testSetOre() {
       System.out.println("setOre");
        Store store = new Store("Intermediate");
        store.setOre(10);
        int expResult = 10;
        int result = store.getOre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCrystite method, of class Store.
     */
    @Test
    public void testSetCrystite() {
        System.out.println("setCrystite");
        Store store = new Store("Intermediate");
        store.setCrystite(10);
        int expResult = 10;
        int result = store.getCrystite();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMules method, of class Store.
     */
    @Test
    public void testSetMules() {
       System.out.println("setMules");
        Store store = new Store("Intermediate");
        store.setMules(10);
        int expResult = 10;
        int result = store.getMules();
        assertEquals(expResult, result);
    }

    /**
     * Test of sellFood method, of class Store.
     */
    @Test
    public void testSellFood() {
        System.out.println("sellFood");
        Store store = new Store("Intermediate");
        store.sellFood();
        int expResult = 15;
        int result = store.getFood();
        assertEquals(expResult, result);
        store.setFood(0);
        store.sellFood();
        result = store.getFood();
        assertEquals(0, result);
    }

    /**
     * Test of sellEnergy method, of class Store.
     */
    @Test
    public void testSellEnergy() {
        System.out.println("sellEnergy");
        Store store = new Store("Intermediate");
        store.sellEnergy();
        int expResult = 15;
        int result = store.getEnergy();
        assertEquals(expResult, result);
    }

    /**
     * Test of sellOre method, of class Store.
     */
    @Test
    public void testSellOre() {
        System.out.println("sellOre");
        Store store = new Store("Intermediate");
        store.setOre(10);
        store.sellOre();
        int expResult = 9;
        int result = store.getOre();
        assertEquals(expResult, result);
    }

    /**
     * Test of sellCrystite method, of class Store.
     */
    @Test
    public void testSellCrystite() {
        System.out.println("sellCrystite");
        Store store = new Store("Intermediate");
        store.setCrystite(10);
        store.sellCrystite();
        int expResult = 9;
        int result = store.getCrystite();
        assertEquals(expResult, result);
    }

    /**
     * Test of sellMule method, of class Store.
     */
    @Test
    public void testSellMule() {
        System.out.println("sellMule");
        Store store = new Store("Intermediate");
        store.sellMule();
        int expResult = 24;
        int result = store.getMules();
        assertEquals(expResult, result);
    }

    /**
     * Test of buyFood method, of class Store.
     */
    @Test
    public void testBuyFood() {
        System.out.println("buyFood");
        Store store = new Store("Intermediate");
        store.buyFood();
        int expResult = 17;
        int result = store.getFood();
        assertEquals(expResult, result);
    }

    /**
     * Test of buyEnergy method, of class Store.
     */
    @Test
    public void testBuyEnergy() {
        System.out.println("buyEnergy");
        Store store = new Store("Intermediate");
        store.buyEnergy();
        int expResult = 17;
        int result = store.getEnergy();
        assertEquals(expResult, result);
    }

    /**
     * Test of buyOre method, of class Store.
     */
    @Test
    public void testBuyOre() {
        System.out.println("buyOre");
        Store store = new Store("Intermediate");
        store.buyOre();
        int expResult = 1;
        int result = store.getOre();
        assertEquals(expResult, result);
    }

    /**
     * Test of buyCrystite method, of class Store.
     */
    @Test
    public void testBuyCrystite() {
        System.out.println("buyCrystite");
        Store store = new Store("Intermediate");
        store.buyCrystite();
        int expResult = 1;
        int result = store.getCrystite();
        assertEquals(expResult, result);
    }

    /**
     * Test of buyMule method, of class Store.
     */
    @Test
    public void testBuyMule() {
        System.out.println("buyMule");
        Store store = new Store("Intermediate");
        store.buyMule();
        int expResult = 26;
        int result = store.getMules();
        assertEquals(expResult, result);
    }
    
}
