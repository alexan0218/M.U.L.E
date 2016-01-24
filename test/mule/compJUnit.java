package mule;

import javafx.scene.paint.Color;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

/**
 * M13--Extensive JUnit
 * Group 16
 */
public class compJUnit {
    private static final int TIMEOUT = 200;
    private Player player;
    private Store store;
    private Setting setting;
    private RandomEvent randomevent;

    ///////////////////////////////////////////////////////////////////////////
    // Plot test
    @Test(timeout = TIMEOUT)
    public void testSetTag() {
        System.out.println("setTag");
        int tag = 5;
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        instance.setTag(tag);
        // review the generated test code and
        // remove the default call to fail.
        assertEquals(5, instance.getTag());
    }

    @Test(timeout = TIMEOUT)
    public void testGetTag() {
        System.out.println("getTag");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        int expResult = 10;
        int result = instance.getTag();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
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

    @Test(timeout = TIMEOUT)
    public void testSetMule() {
        System.out.println("setMule");
        MultiUsage m = new MultiUsage(2);
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        instance.setMule(m);
        assertEquals(m, instance.getMule());
    }

    @Test(timeout = TIMEOUT)
    public void testSetOwned() {
        System.out.println("setOwned");
        boolean isOwned = true;
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        assertFalse(instance.isOwned());
        instance.setOwned(isOwned);
        assertTrue(instance.isOwned());
    }

    @Test(timeout = TIMEOUT)
    public void testIsOwned() {
        System.out.println("isOwned");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        boolean expResult = false;
        boolean result = instance.isOwned();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testSetOwner() {
        System.out.println("setOwner");
        Player player = new Player("Cina", "HUMAN", Color.RED, 1, "Intermediate");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        assertEquals(null, instance.getOwner());
        instance.setOwner(player);
        assertEquals(player, instance.getOwner());
    }

    @Test(timeout = TIMEOUT)
    public void testGetOwner() {
        System.out.println("getOwner");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        Player expResult = new Player("Cina", "HUMAN", Color.RED, 1, "Intermediate");
        instance.setOwner(expResult);
        Player result = instance.getOwner();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testGetFoodProduction() {
        System.out.println("getFoodProduction");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        int expResult = 1;
        int result = instance.getFoodProduction();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testSetFoodProduction() {
        System.out.println("setFoodProduction");
        int food = 0;
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        assertEquals(1, instance.getFoodProduction());
        instance.setFoodProduction(food);
        assertEquals(0, instance.getFoodProduction());
    }

    @Test(timeout = TIMEOUT)
    public void testGetEnergyProduction() {
        System.out.println("getEnergyProduction");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        int expResult = 2;
        int result = instance.getEnergyProduction();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testSetEnergyProduction() {
        System.out.println("setEnergyProduction");
        int energy = 0;
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        assertEquals(2, instance.getEnergyProduction());
        instance.setEnergyProduction(energy);
        assertEquals(0, instance.getEnergyProduction());
    }

    @Test(timeout = TIMEOUT)
    public void testGetOreProduction() {
        System.out.println("getOreProduction");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        int expResult = 3;
        int result = instance.getOreProduction();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testSetOreProduction() {
        System.out.println("setOreProduction");
        int ore = 0;
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        assertEquals(3, instance.getOreProduction());
        instance.setOreProduction(ore);
        assertEquals(0, instance.getOreProduction());
    }

    @Test(timeout = TIMEOUT)
    public void testGetCrystiteProduction() {
        System.out.println("getCrystiteProduction");
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        int expResult = 4;
        int result = instance.getCrystiteProduction();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testSetCrystiteProduction() {
        System.out.println("setCrystiteProduction");
        int crystite = 0;
        Plot instance = new Plot(1, 2, 3, 4, false, 2, 10);
        assertEquals(4, instance.getCrystiteProduction());
        instance.setCrystiteProduction(crystite);
        assertEquals(0, instance.getCrystiteProduction());
    }
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // Store test
    @Test(timeout = TIMEOUT)
    public void testGetFood() {
        System.out.println("getFood");
        Store store = new Store("Intermediate");
        int expResult = 16;
        int result = store.getFood();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testGetEnergy() {
        System.out.println("getEnergy");
        Store store = new Store("Intermediate");
        int expResult = 16;
        int result = store.getEnergy();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testGetOre() {
        System.out.println("getOre");
        Store store = new Store("Intermediate");
        int expResult = 0;
        int result = store.getOre();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testGetCrystite() {
        System.out.println("getCrystite");
        Store store = new Store("Intermediate");
        int expResult = 0;
        int result = store.getCrystite();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testGetMules() {
        System.out.println("getMules");
        Store store = new Store("Intermediate");
        int expResult = 25;
        int result = store.getMules();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testSetFood() {
        System.out.println("setFood");
        Store store = new Store("Intermediate");
        store.setFood(10);
        int expResult = 10;
        int result = store.getFood();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testSetEnergy() {
        System.out.println("setEnergy");
        Store store = new Store("Intermediate");
        store.setEnergy(10);
        int expResult = 10;
        int result = store.getEnergy();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testSetOre() {
        System.out.println("setOre");
        Store store = new Store("Intermediate");
        store.setOre(10);
        int expResult = 10;
        int result = store.getOre();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testSetCrystite() {
        System.out.println("setCrystite");
        Store store = new Store("Intermediate");
        store.setCrystite(10);
        int expResult = 10;
        int result = store.getCrystite();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testSetMules() {
        System.out.println("setMules");
        Store store = new Store("Intermediate");
        store.setMules(10);
        int expResult = 10;
        int result = store.getMules();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void sellFoodTesty() {
        store = new Store("Intermediate");
        store.setFood(100);
        assertEquals(100, store.getFood());
        store.sellFood();
        assertEquals(99, store.getFood());
    }

    @Test(timeout = TIMEOUT)
    public void sellFoodTestn() {
        store = new Store("Intermediate");
        store.setFood(0);
        assertEquals(0, store.getFood());
        store.sellFood();
        assertEquals(0, store.getFood());
    }

    @Test(timeout = TIMEOUT)
    public void sellEnergyTesty() {
        store = new Store("Intermediate");
        store.setEnergy(100);
        assertEquals(100, store.getEnergy());
        store.sellEnergy();
        assertEquals(99, store.getEnergy());
    }

    @Test(timeout = TIMEOUT)
    public void sellEnergyTestn() {
        store = new Store("Intermediate");
        store.setEnergy(0);
        assertEquals(0, store.getEnergy());
        store.sellEnergy();
        assertEquals(0, store.getEnergy());
    }

    @Test(timeout = TIMEOUT)
    public void sellOreTesty() {
        store = new Store("Intermediate");
        store.setOre(100);
        assertEquals(100, store.getOre());
        store.sellOre();
        assertEquals(99, store.getOre());
    }

    @Test(timeout = TIMEOUT)
    public void sellOreTestn() {
        store = new Store("Intermediate");
        store.setOre(0);
        assertEquals(0, store.getOre());
        store.sellOre();
        assertEquals(0, store.getOre());
    }

    @Test(timeout = TIMEOUT)
    public void sellCrystiteTesty() {
        store = new Store("Intermediate");
        store.setCrystite(100);
        assertEquals(100, store.getCrystite());
        store.sellCrystite();
        assertEquals(99, store.getCrystite());
    }

    @Test(timeout = TIMEOUT)
    public void sellCrystiteTestn() {
        store = new Store("Intermediate");
        store.setCrystite(0);
        assertEquals(0, store.getCrystite());
        store.sellCrystite();
        assertEquals(0, store.getCrystite());
    }

    @Test(timeout = TIMEOUT)
    public void sellMuleTesty() {
        store = new Store("Intermediate");
        store.setMules(100);
        assertEquals(100, store.getMules());
        store.sellMule();
        assertEquals(99, store.getMules());
    }

    @Test(timeout = TIMEOUT)
    public void sellMuleTestn() {
        store = new Store("Intermediate");
        store.setMules(0);
        assertEquals(0, store.getMules());
        store.sellMule();
        assertEquals(0, store.getMules());
    }

    @Test(timeout = TIMEOUT)
    public void testBuyFood() {
        System.out.println("buyFood");
        Store store = new Store("Intermediate");
        store.buyFood();
        int expResult = 17;
        int result = store.getFood();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testBuyEnergy() {
        System.out.println("buyEnergy");
        Store store = new Store("Intermediate");
        store.buyEnergy();
        int expResult = 17;
        int result = store.getEnergy();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testBuyOre() {
        System.out.println("buyOre");
        Store store = new Store("Intermediate");
        store.buyOre();
        int expResult = 1;
        int result = store.getOre();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testBuyCrystite() {
        System.out.println("buyCrystite");
        Store store = new Store("Intermediate");
        store.buyCrystite();
        int expResult = 1;
        int result = store.getCrystite();
        assertEquals(expResult, result);
    }

    @Test(timeout = TIMEOUT)
    public void testBuyMule() {
        System.out.println("buyMule");
        Store store = new Store("Intermediate");
        store.buyMule();
        int expResult = 26;
        int result = store.getMules();
        assertEquals(expResult, result);
    }
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // Setting test
    @Test(timeout = TIMEOUT)
    public void setGetDifficulty() {
        setting = new Setting();
        setting.setDifficulty("hard");
        assertEquals("hard", setting.getDifficulty());
    }

    @Test(timeout = TIMEOUT)
    public void setGetMap() {
        setting = new Setting();
        setting.setMap("map1");
        assertEquals("map1", setting.getMap());
    }

    @Test(timeout = TIMEOUT)
    public void setGetPlayerNum() {
        setting = new Setting();
        setting.setPlayerNum(10);
        assertEquals(10, setting.getPlayerNum());
    }

    @Test(timeout = TIMEOUT)
    public void setGetPlayers() {
        setting = new Setting();
        ArrayList<Player> list = new ArrayList<>();
        Player p1 = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        Player p2 = new Player("xixi", "HUMAN", Color.RED, 1, "Intermediate");
        list.add(p1);
        list.add(p2);
        setting.setPlayers(list);
        assertEquals(list, setting.getPlayers());
    }

    @Test(timeout = TIMEOUT)
    public void setGetCurrentPlayer() {
        setting = new Setting();
        Player p1 = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        setting.setCurrentPlayer(p1);
        assertEquals(p1, setting.getCurrentPlayer());
    }

    @Test(timeout = TIMEOUT)
    public void setGetCurrentTurn() {
        setting = new Setting();
        setting.setCurrentTurn(10);
        assertEquals(10, setting.getCurrentTurn());
    }

    @Test(timeout = TIMEOUT)
    public void incrementCurrentTurn() {
        setting = new Setting();
        setting.setCurrentTurn(10);
        setting.incrementCurrentTurn();
        assertEquals(11, setting.getCurrentTurn());
    }

    @Test(timeout = TIMEOUT)
    public void setGetCurrentPhase() {
        setting = new Setting();
        setting.setCurrentPhase(10);
        assertEquals(10, setting.getCurrentPhase());
    }

    @Test(timeout = TIMEOUT)
    public void incrementCurrentPhase() {
        setting = new Setting();
        setting.setCurrentPhase(10);
        setting.incrementCurrentPhase();
        assertEquals(11, setting.getCurrentPhase());
    }

    @Test(timeout = TIMEOUT)
    public void setGetCurrentRound() {
        setting = new Setting();
        setting.setCurrentRound(10);
        assertEquals(10, setting.getCurrentRound());
    }

    @Test(timeout = TIMEOUT)
    public void incrementCurrentRound() {
        setting = new Setting();
        setting.setCurrentRound(10);
        setting.incrementCurrentRound();
        assertEquals(11, setting.getCurrentRound());
    }

    @Test(timeout = TIMEOUT)
    public void setGetLoadGame() {
        setting = new Setting();
        setting.setLoadGameTrue();
        assertTrue(setting.isOldGame());
    }
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // RandomEvent test
    @Test(timeout = TIMEOUT)
    public void doEvent0() {
        randomevent = new RandomEvent(1, "haha");
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setFood(100);
        player.setEnergy(100);
        randomevent.doEvent(0, 3, player);
        assertEquals(103, player.getFood());
        assertEquals(102, player.getEnergy());
    }

    @Test(timeout = TIMEOUT)
    public void doEvent1() {
        randomevent = new RandomEvent(1, "haha");
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setOre(100);
        randomevent.doEvent(1, 3, player);
        assertEquals(102, player.getOre());
    }

    @Test(timeout = TIMEOUT)
    public void doEvent2() {
        randomevent = new RandomEvent(1, "haha");
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setMoney(100);
        randomevent.doEvent(2, 3, player);
        assertEquals(300, player.getMoney());
    }

    @Test(timeout = TIMEOUT)
    public void doEvent3() {
        randomevent = new RandomEvent(1, "haha");
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setMoney(100);
        randomevent.doEvent(3, 5, player);
        assertEquals(200, player.getMoney());
    }

    @Test(timeout = TIMEOUT)
    public void doEvent4() {
        randomevent = new RandomEvent(1, "haha");
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setMoney(200);
        randomevent.doEvent(4, 3, player);
        assertEquals(100, player.getMoney());
    }

    @Test(timeout = TIMEOUT)
    public void doEvent5() {
        randomevent = new RandomEvent(1, "haha");
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setFood(100);
        randomevent.doEvent(5, 3, player);
        assertEquals(50, player.getFood());
    }

    @Test(timeout = TIMEOUT)
    public void doEvent6() {
        randomevent = new RandomEvent(1, "haha");
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setMoney(1000);
        randomevent.doEvent(6, 6, player);
        assertEquals(700, player.getMoney());
    }

    @Test(timeout = TIMEOUT)
    public void getFactor3() {
        randomevent = new RandomEvent(1, "haha");
        assertEquals(25, randomevent.getFactor(1));
        assertEquals(25, randomevent.getFactor(2));
        assertEquals(25, randomevent.getFactor(3));
    }

    @Test(timeout = TIMEOUT)
    public void getFactor7() {
        randomevent = new RandomEvent(1, "haha");
        assertEquals(50, randomevent.getFactor(4));
        assertEquals(50, randomevent.getFactor(5));
        assertEquals(50, randomevent.getFactor(6));
        assertEquals(50, randomevent.getFactor(7));
    }

    @Test(timeout = TIMEOUT)
    public void getFactor11() {
        randomevent = new RandomEvent(1, "haha");
        assertEquals(75, randomevent.getFactor(8));
        assertEquals(75, randomevent.getFactor(9));
        assertEquals(75, randomevent.getFactor(10));
        assertEquals(75, randomevent.getFactor(11));
    }

    @Test(timeout = TIMEOUT)
    public void getFactorelse() {
        randomevent = new RandomEvent(1, "haha");
        assertEquals(100, randomevent.getFactor(12));
        assertEquals(100, randomevent.getFactor(45));
        assertEquals(100, randomevent.getFactor(106));
        assertEquals(100, randomevent.getFactor(999));
    }

    @Test(timeout = TIMEOUT)
    public void randomBoolean() {
        int trueTimes = 0;
        boolean temp;
        randomevent = new RandomEvent(1, "haha");
        for (int i = 0; i < 10000; i++) {
            temp = randomevent.randomBoolean(40);
            if (temp == true) {
                trueTimes++;
            }
        }
        assertTrue(trueTimes < 4500);
        assertTrue(trueTimes > 3500);
    }
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // Player test
    @Test(timeout = TIMEOUT)
    public void getName() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        assertEquals("haha", player.getName());
    }

    @Test(timeout = TIMEOUT)
    public void getRace() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        assertEquals("HUMAN", player.getRace());
    }

    @Test(timeout = TIMEOUT)
    public void getColor() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        assertTrue(Color.RED == player.getColor());
    }

    @Test(timeout = TIMEOUT)
    public void moneyTest() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        assertEquals(600, player.getMoney());
        player = new Player("haha", "FLAPPER", Color.RED, 1, "Intermediate");
        assertEquals(1600, player.getMoney());
        player = new Player("haha", "H", Color.RED, 1, "Intermediate");
        assertEquals(1000, player.getMoney());
        player.setMoney(100);
        assertEquals(100, player.getMoney());
        player.spendMoney(50);
        assertEquals(50, player.getMoney());
        player.gainMoney(40);
        assertEquals(90, player.getMoney());
    }

    @Test(timeout = TIMEOUT)
    public void foodTest() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        assertEquals(8, player.getFood());
        player.setFood(100);
        assertEquals(100, player.getFood());
        player.spendFood(50);
        assertEquals(50, player.getFood());
        player.gainFood(40);
        assertEquals(90, player.getFood());
    }

    @Test(timeout = TIMEOUT)
    public void energyTest() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        assertEquals(4, player.getEnergy());
        player.setEnergy(100);
        assertEquals(100, player.getEnergy());
        player.spendEnergy(50);
        assertEquals(50, player.getEnergy());
        player.gainEnergy(40);
        assertEquals(90, player.getEnergy());
    }

    @Test(timeout = TIMEOUT)
    public void oreTest() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        assertEquals(0, player.getOre());
        player.setOre(100);
        assertEquals(100, player.getOre());
        player.spendOre(50);
        assertEquals(50, player.getOre());
        player.gainOre(40);
        assertEquals(90, player.getOre());
    }

    @Test(timeout = TIMEOUT)
    public void crystiteTest() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        assertEquals(0, player.getCrystite());
        player.setCrystite(100);
        assertEquals(100, player.getCrystite());
        player.spendCrystite(50);
        assertEquals(50, player.getCrystite());
        player.gainCrystite(40);
        assertEquals(90, player.getCrystite());
    }

    @Test(timeout = TIMEOUT)
    public void getScore() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setMoney(10);
        player.setFood(10);
        player.setEnergy(10);
        player.setOre(10);
        int size = player.plots.size();
        assertEquals(40 + 500 * size, player.getScore());
    }

    @Test(timeout = TIMEOUT)
    public void canbuy() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setCanBuy(true);
        assertTrue(player.getCanBuy());
        player.setCanBuy(false);
        assertFalse(player.getCanBuy());
    }

    @Test(timeout = TIMEOUT)
    public void buyFoody() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setMoney(40);
        player.setFood(10);
        assertTrue(player.buyFood());
        assertEquals(10, player.getMoney());
        assertEquals(11, player.getFood());
    }

    @Test(timeout = TIMEOUT)
    public void buyFoodn() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setMoney(20);
        player.setFood(10);
        assertFalse(player.buyFood());
        assertEquals(20, player.getMoney());
        assertEquals(10, player.getFood());
    }

    @Test(timeout = TIMEOUT)
    public void buyEnergyy() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setMoney(40);
        player.setEnergy(10);
        assertTrue(player.buyEnergy());
        assertEquals(15, player.getMoney());
        assertEquals(11, player.getEnergy());
    }

    @Test(timeout = TIMEOUT)
    public void buyEnergyn() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setMoney(20);
        player.setEnergy(10);
        assertFalse(player.buyEnergy());
        assertEquals(20, player.getMoney());
        assertEquals(10, player.getEnergy());
    }

    @Test(timeout = TIMEOUT)
    public void buyOrey() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setMoney(60);
        player.setOre(10);
        assertTrue(player.buyOre());
        assertEquals(10, player.getMoney());
        assertEquals(11, player.getOre());
    }

    @Test(timeout = TIMEOUT)
    public void buyOren() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setMoney(20);
        player.setOre(10);
        assertFalse(player.buyOre());
        assertEquals(20, player.getMoney());
        assertEquals(10, player.getOre());
    }

    @Test(timeout = TIMEOUT)
    public void buyCrystitey() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setMoney(140);
        player.setCrystite(10);
        assertTrue(player.buyCrystite());
        assertEquals(40, player.getMoney());
        assertEquals(11, player.getCrystite());
    }

    @Test(timeout = TIMEOUT)
    public void buyCrystiten() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setMoney(20);
        player.setCrystite(10);
        assertFalse(player.buyCrystite());
        assertEquals(20, player.getMoney());
        assertEquals(10, player.getCrystite());
    }

    @Test(timeout = TIMEOUT)
    public void sellFoody() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setFood(100);
        player.setMoney(100);
        assertTrue(player.sellFood());
        assertEquals(99, player.getFood());
        assertEquals(130, player.getMoney());
    }

    @Test(timeout = TIMEOUT)
    public void sellFoodn() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setFood(0);
        player.setMoney(100);
        assertFalse(player.sellFood());
        assertEquals(0, player.getFood());
        assertEquals(100, player.getMoney());
    }

    @Test(timeout = TIMEOUT)
    public void sellEnergyy() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setEnergy(100);
        player.setMoney(100);
        assertTrue(player.sellEnergy());
        assertEquals(99, player.getEnergy());
        assertEquals(125, player.getMoney());
    }

    @Test(timeout = TIMEOUT)
    public void sellEnergyn() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setEnergy(0);
        player.setMoney(100);
        assertFalse(player.sellEnergy());
        assertEquals(0, player.getEnergy());
        assertEquals(100, player.getMoney());
    }

    @Test(timeout = TIMEOUT)
    public void sellOrey() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setOre(100);
        player.setMoney(100);
        assertTrue(player.sellOre());
        assertEquals(99, player.getOre());
        assertEquals(150, player.getMoney());
    }

    @Test(timeout = TIMEOUT)
    public void selloren() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setOre(0);
        player.setMoney(100);
        assertFalse(player.sellOre());
        assertEquals(0, player.getOre());
        assertEquals(100, player.getMoney());
    }

    @Test(timeout = TIMEOUT)
    public void sellCrystitey() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setCrystite(100);
        player.setMoney(100);
        assertTrue(player.sellCrystite());
        assertEquals(99, player.getCrystite());
        assertEquals(200, player.getMoney());
    }

    @Test(timeout = TIMEOUT)
    public void sellCrystiten() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setCrystite(0);
        player.setMoney(100);
        assertFalse(player.sellCrystite());
        assertEquals(0, player.getCrystite());
        assertEquals(100, player.getMoney());
    }

    @Test(timeout = TIMEOUT)
    public void buymule() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        player.setMoney(1000);
        assertTrue(player.buyFoodMule());
        assertEquals(875, player.getMoney());
        assertTrue(player.buyEnergyMule());
        assertEquals(725, player.getMoney());
        assertTrue(player.buyOreMule());
        assertEquals(550, player.getMoney());
        player.setMoney(100);
        assertFalse(player.buyFoodMule());
        assertFalse(player.buyEnergyMule());
        assertFalse(player.buyOreMule());
    }

    @Test(timeout = TIMEOUT)
    public void setmules() {
        player = new Player("haha", "HUMAN", Color.RED, 1, "Intermediate");
        assertEquals(0, player.getMules().size());
        player.gainMules(1);
        assertEquals(1, player.getMules().size());
        player.removeMules(1);
        assertEquals(0, player.getMules().size());
    }



}
