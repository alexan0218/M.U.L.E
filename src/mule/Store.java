/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;

/**
 *
 * @author Alex
 */
public class Store {
    
    int food;
    int energy;
    int ore;
    int crystite;
    int mules;
    
    public Store(String difficulty) {
        if (difficulty == "Beginner"){
            food = 16;
            energy = 16;
            ore = 0;
        } else {
            food = 8;
            energy = 8;
            ore = 8;
        }
        crystite = 0;
        mules = 25;
    }
    
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
    
    public int getMules() {
        return mules;
    }
    
    public void setFood(int n) {
        food = n;
    }
    
    public void setEnergy(int n) {
        energy = n;
    }
    
    public void setOre(int n) {
        ore = n;
    }
    
    public void setCrystite(int n) {
        crystite = n;
    }
    
    
    public void setMules(int n) {
        mules = n;
    }
    
    public void sellFood() {
        if (food > 0) {
            food--;
        } else {
            System.out.println("food was sold out");
        }
    }
    
    public void sellEnergy() {
        if (energy > 0) {
            energy--;
        } else {
            System.out.println("energy was sold out");
        }
    }
    
    public void sellOre() {
        if (ore > 0) {
            ore--;
        } else {
            System.out.println("Smithore was sold out");
        }       
    }
    
    public void sellCrystite() {
        if (crystite > 0) {
            crystite--;
        } else {
            System.out.println("crystite was sold out");
        }       
    }
    
    public void sellMule() {
        if (mules > 0) {
            mules--;
        } else {
            System.out.println("Mules was sold out");
        }
    }
    
    public void buyFood() {
        food++;
    }
    
    public void buyEnergy() {
        energy++;
    }
    
    public void buyOre() {
        ore++;
    }
    
    public void buyCrystite() {
        crystite++;
    }
    
    public void buyMule() {
        mules++;
    }
}
