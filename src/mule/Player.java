/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;


import javafx.scene.paint.Color;

import java.lang.System;
import java.util.ArrayList;

/**
 *
 * @author CinaSMY
 */
public class Player implements Comparable {
    String name;
    String race;
    Color color;
    int money;
    //1001
    int food;
    int energy;
    int ore;
    int crystite;
    int score;
    boolean canBuy;
    int tag;
    ArrayList<Plot> plots = new ArrayList<>();
    ArrayList<MultiUsage> mules = new ArrayList<>();


    public Player(String name, String race, Color color, int tag, String difficulty) {
        this.name = name;
        this.race = race;
        this.color = color;
        this.tag = tag;
        if (difficulty == "Beginner") {
            this.food = 8;
            this.energy = 4;
            this.ore = 0;
        } else if (difficulty == "Intermediate") {
            this.food = 4;
            this.energy = 2;
            this.ore = 0;
        } else if (difficulty == "Expert") {
            this.food = 4;
            this.energy = 2;
            this.ore = 0;
        }
        
        if (race.equals("HUMAN")) {
            this.money = 600;
        } else if (race.equals("FLAPPER")) {
            this.money = 1600;
        } else {
            this.money = 1000;
        }
        // WARDEN, MARAUDER, GRAVELORD, GAREN, TWISTEDFATE, BARD, VEIGAR, VAYNE
        if (race.equals("WARDEN")) {this.food = 4;}
        else if (race.equals("MARAUDER")) {this.food = 8; this.energy = 8;}
        else if (race.equals("GRAVELORD")) {this.food = 4; this.energy = 12;}
        else if (race.equals("GAREN")) {this.food = 5; this.energy = 5;}
        else if (race.equals("TWISTEDFATE")) {this.food = 2; this.energy = 2;}
        else if (race.equals("BARD")) {this.food = 10; this.energy = 10;}
        else if (race.equals("VEIGAR")) {this.ore = 5;}
        else if (race.equals("VAYNE")) {this.energy = 8; this.ore = 8; this.crystite = 8;}
    }
    //临时constructor 没有颜色
    public Player(String name, String race, int money) {
        this.name = name;
        this.race = race;
        this.money = money;
    }
    
    
    // Human (hardest), Flapper(easiest), Bonzoid, Ugaite, Buzzite.
    
    public String getName() {
        return name;
    }
    
    public String getRace() {
        return race;
    }
    
    public Color getColor() {
        return color;
    }
    
    public int getMoney() {
        return money;
    }
    
    public void setMoney(int amount) {
        money = amount;
    }
    
    public void spendMoney(int amount) {
         money -= amount;
    }

    public void gainMoney(int amount) { money += amount;}
 //1001添加以下//  
    public int getFood() {
        return food;
    }
    
    public int getEnergy() {
        return energy;
    }
    
    public int getOre() {
        return ore;
    }
    
    public int getCrystite() {
        return crystite;
    }
    
    public void setFood(int num) {
        food = num;
    }
    
    public void setEnergy(int num) {
        energy = num;
    }
    
    public void setOre(int num) {
        ore = num;
    }
    
    public void setCrystite(int num) {
        crystite = num;
    }
    
    public void spendFood(int num) {
        food -= num;
    }
    
    public void spendEnergy(int num) {
        energy -= num;
    }
    
    public void spendOre(int num) {
        ore -= num;
    } 
    
    public void spendCrystite(int num) {
        crystite -= num;
    }
    
    public void gainFood(int num) {
        food += num;
    }
    
    public void gainEnergy(int num) {
        energy += num;
    }
    
    public void gainOre(int num) {
        ore += num;
    }    
    
    public void gainCrystite(int num) {
        crystite += num;
    }
    public int getScore() {
        score = getMoney() + getFood() + getEnergy() + getOre() + 500 * plots.size();
        return score;
    }
    
    public boolean getCanBuy() {
        return canBuy;
    }

    public void setCanBuy(boolean b) {
        canBuy = b;
    }
//以上是于1001添加

//以下是于1005添加
    public boolean buyFood() {
        if (money > 30) {
            food++;
            spendMoney(30);
            return true;
        } else {
            System.out.println("Not enough money to buy food.");
            return false;
        }
        
    }
    public boolean buyEnergy() {
        if (money > 25) {
            energy++;
            spendMoney(25);
            return true;
        } else {
            System.out.println("Not enough money to buy energy.");
            return false;
        }
    }
    public boolean buyOre() {
        if (money > 50) {
            ore++;
            spendMoney(50);
            return true;
        } else {
            System.out.println("Not enough money to buy ore.");
            return false;
        }
    }
    public boolean buyCrystite() {
        if (money > 100) {
            crystite++;
            spendMoney(100);
            return true;
        } else {
            System.out.println("Not enough money to buy crystite.");
            return false;
        }
        
    }
    public boolean sellFood() {
        if (food > 0) {
            food--;
            gainMoney(30);
            return true;
        } else {
            System.out.println("no enough food to sell");
            return false;
        }
    }
    public boolean sellEnergy() {
        if (energy > 0) {
            energy--;
            gainMoney(25);
            return true;
        } else {
            System.out.println("no enough energy to sell");
            return false;
        }
    }
    public boolean sellOre() {
        if (ore > 0) {
            ore--;
            gainMoney(50);
            return true;
        } else {
             System.out.println("no enough ore to sell");
             return false;
        }
    }
    public boolean sellCrystite() {
        if (crystite > 0) {
            crystite--;
            gainMoney(100);
            return true;
        } else {
            System.out.println("no enough crystite to sell");
            return false;
        }
    }
    
    public boolean buyFoodMule() {        
            if (money > 125) {
                mules.add(new MultiUsage(1));
                spendMoney(125);
                return true;
            } else {
                System.out.println("Not enough money to buy mule with food.");
                return false;
            }
    }
    public boolean buyEnergyMule() {        
            if (money > 150) {
                mules.add(new MultiUsage(2));
                spendMoney(150);
                return true;
            } else {
                System.out.println("Not enough money to buy mule with Energy.");
                return false;
            }
    }
    public boolean buyOreMule() {        
            if (money > 175) {
                mules.add(new MultiUsage(3));
                spendMoney(175);
                return true;
            } else {
                System.out.println("Not enough money to buy mule with ore.");
                return false;
            }
    }
    
    public ArrayList<MultiUsage> getMules() {
        return mules;
    }
    
    public void removeMules(int i) {
        mules.remove(i);
    }
    
    public void gainMules(int i) {
        mules.add(new MultiUsage(i));
    }
    
//以上是于1005添加 
    public ArrayList<Plot> getPlots() {
        return plots;
    }
    
    public void addPlot(Plot plot) {
        plots.add(plot);
    }
    
    
    public boolean equals(Player b) {
        System.out.println("using method in Player class !");
        return this.hashCode() == b.hashCode();
    }
    
    @Override
    public int hashCode() {
        int a = name.hashCode() * 13;
        int b = race.hashCode() * 13 + a;
        return b;
    }
    
    @Override
    public int compareTo(Object p) {
        int compareScore = ((Player) p).getScore();
        int result = this.getScore() - compareScore;
        return result;
    }
    
    public int getTag() {
        return tag;
    }

    public String toString() {
        return "name: " + name + " race: " + race + " color: " + color.toString() + " score: " + this.getScore() + "plots: " + this.getPlots() + "mules: " + this.mules;
    }  
}

//24号11点