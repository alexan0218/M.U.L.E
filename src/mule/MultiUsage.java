/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;

/**
 *
 * @author CENA
 */
public class MultiUsage {
    int category;
    Plot plotSetAt;
    // food==1, energy==2,ore==3,crysite==4
    
    public MultiUsage(int category) {
        this.category = category;
        plotSetAt = null;
    }
    public int getCategory() {
        return category;
    }
    public void setCategory(int amount) {
        category = amount;
    }
    
    public void setPlotSetAt(Plot p) {
        plotSetAt = p;
    }
    
    
    
    
    
}



