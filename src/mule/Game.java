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
public class Game {
    private int playerNum;
    private String difficulty;
    private String map;
    private int round = 0;
    private int phase = 0;
    private int turn = 0;
    
    private final static Game instance = new Game();
    
    public static Game getInstance() {
        return instance;
    }

    public Game() {
        
    }
    public Game(int num, String dfct, String map) {
        playerNum = num;
        difficulty = dfct;
        this.map = map;
    }
    
    public void setNum(int n) {
        playerNum = n;
    }
         
    public void setDifficulty(String d) {
        difficulty = d;
    }
           
    public void setMap(String m) {
        map = m;
    }
    
    public int getPlayerNum() {
        return playerNum;
    }
    
    public String getDifficulty() {
        return difficulty;
    }
    
    public String getMap() {
        return map;
    }
    
    public int getTurn() {
        return turn;
    }
    
    public void changeTurn() {
        turn++;
    }
    public int getPhase() {
        return phase;
    }
    
    public void changePhase() {
        if (turn == playerNum) {
            phase++;
            turn = 0;
        }
    }
    //仍需要修改；
    public int getRound() {
        return round;
    }
    
    public void changeRound() {
        if (phase == 3) {
            round++;
            phase = 0;
        }
    } 
    
    
     //24号11点       
            
            
            
            
            
            
            
            
            
            
            
            
}
