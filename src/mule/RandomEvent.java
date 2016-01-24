/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mule;
import java.util.Random;


/**
 *
 * @author Alex
 */
public class RandomEvent {
   
    private final int eventCode;
    private final String message;
    private Player target;
    //TODO: getter, setter,
    /* 
    1.YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.
    2.A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.
    3.THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $ 8*m.
    4.YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $2*m.
    
    
    5.MOTHER EARTH SEND 5 PACKAGE OF FOOD, ENERGY AND ORE
    6.BRAVO GT STUDENT BROK INTO UGA STORAGE AND GAIN 0.5 OF YOUR ENERGY
    7.ACADEMIC MISCONDUCT: YOU LOST ALL YOUR ENERGY.
    
    8.FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $4*m.
    9.MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.
    10.YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $6*m TO CLEAN IT UP.
    11.A STRONG FLU ATTACKED YOUR HOME, COSUMING HALF OF YOUR ENERGY.
    12.FIZZ WANT SOME CARROTS, HE TOOK ONE OF YOUR FOOD.
    */
    public RandomEvent(int eventCode, String message) {
        this.eventCode = eventCode;
        this.message = message;
    }
    

    public void doEvent(int code, int currRound, Player player) {
        if (code == 0) {
            player.gainFood(3);
            player.gainEnergy(2);
            System.out.println(player.toString() + " Event 1 : food + 3 ; energy + 2");
        } else if (code == 1) {
            player.gainOre(2);
            System.out.println(player.toString() + " Event 2 : Ore + 2");
        } else if (code == 2) {
            int m = getFactor(currRound);
            player.gainMoney(8*m);
            System.out.println(player.toString() + " Event 3 : " + currRound + " m : " + m);
        } else if (code == 3) {
            int m = getFactor(currRound);
            player.gainMoney(2*m);
            System.out.println(player.toString() + " Event 4 : " + currRound + " m : " + m);
        } else if (code == 4) {
            player.gainFood(5);
            player.gainEnergy(5);
            player.gainOre(5);
            System.out.println(player.toString() + "Event 5: food + 5; energy + 5; Ore + 5");
        } else if (code == 5) {
            player.gainEnergy(player.getEnergy() / 2);
            System.out.println(player.toString() + "Event 6: Energy *1.5");
        } else if (code == 6) {
            player.spendEnergy(player.getEnergy());
            player.setEnergy(0);
            System.out.println(player.toString() + "Event 7: Energy is zero");
        } else if (code == 7) {
            int m = getFactor(currRound);
            player.spendMoney(4*m);
            System.out.println(player.toString() + " Event 8 : " + currRound + " m : " + m);
        } else if (code == 8) {
            player.spendFood(player.getFood()/2);
            System.out.println(player.toString() + " Event 9 : food / 2 " );
        } else if (code == 9) {
            int m = getFactor(currRound);
            player.spendMoney(6*m);
            System.out.println(player.toString() + " Event 10 : " + currRound + " m : " + m);
        } else if (code == 10) {
            player.spendEnergy(player.getEnergy() / 2);
            System.out.println(player.toString() + " Event 11 : energy / 2" );
        } else {
            player.spendFood(1);
            System.out.println(player.toString() + " Event 12 : food - 1 " );
        }
    }    
    
    public int getFactor(int currRound) {
        if (currRound <= 3) {
            return 25;
        } else if (currRound <= 7) {
            return 50;
        } else if (currRound <= 11) {
            return 75;
        } else {
            return 100;
        }
    }

    // 0 <= probability <= 100
    // Example: 27% --> 27% chance of true
    public boolean randomBoolean(int probability) {
        Random rand = new Random();
        int value = rand.nextInt(100) + 1;
        if (value <= probability) {
            return true;
        }
        return false;
    }
}
