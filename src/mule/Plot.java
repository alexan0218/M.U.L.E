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
public class Plot {
    int tag;
    int foodProduction;
    int energyProduction;
    int oreProduction;
    int crystiteProduction;
    int mountains;
    boolean withRiver;
    Player owner;
    boolean isOwned;
    MultiUsage mule;
    
    public Plot(int f, int e, int o, int c, int tag) {
        foodProduction = f;
        energyProduction = e;
        oreProduction = o;
        crystiteProduction = c;
        owner = null;
        isOwned = false;
        mountains = 0;
        withRiver = false;
        mule = null;
        this.tag = tag;
    }

    public Plot(int f, int e, int o, int c, boolean b, int m, int tag) {
        foodProduction = f;
        energyProduction = e;
        oreProduction = o;
        crystiteProduction = c;
        owner = null;
        isOwned = false;
        mountains = m;
        withRiver = b;
        mule = null;
        this.tag = tag;
    }
    
    public void setTag(int tag) {
        this.tag = tag;
    }
    
    public int getTag() {
        return tag;
    }
    
    public MultiUsage getMule() {
        return mule;
    }
    
    public void setMule(MultiUsage m) {
        mule = m;
    }
    
    public void setOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }
    
    public boolean isOwned() {
        return isOwned;
    }
    
    public void setOwner(Player player) {
        this.owner = player;
    }
    
    public Player getOwner() {
        return owner;
    }
    
    public int getFoodProduction() {
        return foodProduction;
    }
    
    public void setFoodProduction(int food) {
        foodProduction = food;
    }
    
    public int getEnergyProduction() {
        return energyProduction;
    }
    
    public void setEnergyProduction(int energy) {
        energyProduction = energy;
    }
    public int getOreProduction() {
        return oreProduction;
    }
    
    public void setOreProduction(int ore) {
        oreProduction = ore;
    }
    
    public int getCrystiteProduction() {
        return crystiteProduction;
    }
    
    public void setCrystiteProduction(int crystite) {
        crystiteProduction = crystite;
    }
}
//24号11点