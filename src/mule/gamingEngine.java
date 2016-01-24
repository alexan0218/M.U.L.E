/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;

import java.io.IOException;
import java.util.Random;
import javafx.event.ActionEvent;

/**
 * Our facade interface which represents the whole gaming engine.
 * Operates the game during gaming time.
 * @author Jihai
 */
public interface gamingEngine {
    
    public void passButtonAction(ActionEvent e);
    
    public void plotButtonAction(ActionEvent e);
    
    public void pass();
    
    public void changeState(Player p);
    
    public void getIntoAndOutOfTown(ActionEvent e) throws IOException;
    
    public boolean randomBoolean();
    
    public int randomInt(int i);
    
    public boolean isLowestPlayer(Player target);
    
    public void shootGoodEvent(int currRound, Player target);
    
    public void shootAllEvent(int currRound, Player target); 
    
    public void initiateButtons();

}