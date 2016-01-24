/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;

/**
 * This is the global model for this game. Put any data you want to share among controllers here plz.
 * @author CinaSMY
 */
public class Setting {
    private int playerNum;
    private String difficulty;
    private String mapName;
    private ArrayList<Player> players = new ArrayList<>();
    private final static Setting instance = new Setting();
    public Timer timer = new Timer();
    private Player currentPlayer;
    private int currentTurn;
    private int currentPhase;
    private int currentRound;
    private boolean loadOldGame = false;

    public static Setting getInstance() {
        return instance;
    }
    
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    
    public void setMap(String mapName) {
        this.mapName = mapName;
    }
    
    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }
    
    public String getDifficulty() {
        return difficulty;
    }
    
    public String getMap() {
        return mapName;
    }
    
    public int getPlayerNum() {
        return playerNum;
    }
    
    public void savePlayer(Player player) {
        players.add(players.size(), player);
    }
    
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    
    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    public void setCurrentPlayer(int turn, ArrayList<Player> ps) {
        if (ps.size() != 0) {
            currentPlayer = ps.get(turn);
        }
    }
    
    public void setCurrentPlayer(Player p) {
        currentPlayer = p;
    }
    
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }    
    
    public void setCurrentTurn(int turn) {
        currentTurn = turn;
    }
    
    public int getCurrentTurn() {
        return currentTurn;
    }
    
    public void incrementCurrentTurn() {
        currentTurn++;
    }
    
    public void setCurrentPhase(int phase) {
        currentPhase = phase;
    }
    
    public int getCurrentPhase() {
        return currentPhase;
    }
    
    public void incrementCurrentPhase() {
        currentPhase++;
    }
    
    public void setCurrentRound(int round) {
        currentRound = round;
    }
    
    public int getCurrentRound() {
        return currentRound;
    }
    
    public void incrementCurrentRound() {
        currentRound++;
    }
    
    public void setLoadGameTrue() {
        loadOldGame = true;
    }
    
    public boolean isOldGame() {
        return loadOldGame;
    }
}


