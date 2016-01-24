/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CinaSMY
 */
public class MuleTownWindowController implements Initializable {

    
    Store store = new Store(Setting.getInstance().getDifficulty());
    
    @FXML
    private Button foodMuleButton;
    @FXML
    private Button energyMuleButton;
    @FXML
    private Button oreMuleButton;
    @FXML
    private Button getOutOfTown;
    @FXML
    private Button sellFood;
    @FXML
    private Button buyFood;
    @FXML
    private Button sellEnergy;
    @FXML
    private Button buyEnergy;
    @FXML
    private Button sellOre;
    @FXML
    private Button buyOre;
    @FXML
    private Button sellCrystite;
    @FXML
    private Button buyCrystite;
    
    private Player currentPlayer;
    
    //以下是基于玩家买/玩家卖
    @FXML
    private void buyFood(ActionEvent e) {
        if (Setting.getInstance().getCurrentPlayer().buyFood()) {
            store.sellFood();
        }
        System.out.println("current #food: " + store.getFood());
    }
    @FXML
    private void buyEnergy(ActionEvent e) {
        if (Setting.getInstance().getCurrentPlayer().buyEnergy()) {
           store.sellEnergy(); 
        }   
        System.out.println("current #energy: " + store.getEnergy());
    }
    @FXML
    private void buyOre(ActionEvent e) {
        if (Setting.getInstance().getCurrentPlayer().buyOre()) {
            store.sellOre();
        }
        System.out.println("current #ore: " + store.getOre());
    }
    @FXML
    private void buyCrystite(ActionEvent e) {
        if (Setting.getInstance().getCurrentPlayer().buyCrystite()) {
            store.sellCrystite();
        } 
        System.out.println("current #crystite: " + store.getCrystite());
    }
    
    @FXML
    private void sellFood(ActionEvent e) { 
        if (Setting.getInstance().getCurrentPlayer().sellFood()) {
            store.buyFood();
        }
        System.out.println("current #food: " + store.getFood());
    }
    @FXML
    private void sellEnergy(ActionEvent e) {
        if (Setting.getInstance().getCurrentPlayer().sellEnergy()) {
            store.buyEnergy();
        }
        System.out.println("current #energy: " + store.getEnergy());
    }
    @FXML
    private void sellOre(ActionEvent e) {
        if (Setting.getInstance().getCurrentPlayer().sellOre()) {
            store.buyOre();
        }
        System.out.println("current #ore: " + store.getOre());
    }
    @FXML
    private void sellCrystite(ActionEvent e) {
        if (Setting.getInstance().getCurrentPlayer().sellCrystite()) {
            store.buyCrystite();
        }
        System.out.println("current #crystite: " + store.getCrystite());
    }
    

    @FXML
    private void exitTown(ActionEvent e)throws IOException {
        Stage stage;
        if (e.getSource() == getOutOfTown) {
            stage = (Stage) getOutOfTown.getScene().getWindow();
            stage.close();
        }

    }
    
    @FXML
    private void buyMule(ActionEvent e) throws IOException {
        Stage stage;
        //Parent root;
        if (e.getSource() == foodMuleButton) {
            if (currentPlayer.buyFoodMule()) {
                store.sellMule();
            }
            Setting.getInstance().setCurrentPlayer(currentPlayer);
            System.out.println("current #mule: " + store.getMules());
            //System.out.println(Setting.getInstance().getCurrentPlayer());
            stage = (Stage) foodMuleButton.getScene().getWindow();
            stage.close();
        } else if (e.getSource() == oreMuleButton) {
            if (currentPlayer.buyOreMule()) {
                store.sellMule();
            }
            Setting.getInstance().setCurrentPlayer(currentPlayer);
            System.out.println("current #mule: " + store.getMules());
            stage = (Stage) oreMuleButton.getScene().getWindow();
            stage.close();
        } else if (e.getSource() == energyMuleButton) {
            if (currentPlayer.buyEnergyMule()) {
                store.sellMule();
            }
            Setting.getInstance().setCurrentPlayer(currentPlayer);
            System.out.println("current #mule: " + store.getMules());
            stage = (Stage) energyMuleButton.getScene().getWindow();
            stage.close();
        }
        
    }
    
    @FXML
    private void gambleAndEndTurn(ActionEvent e) throws IOException {
        Stage stage;
        //need to change to be related to timer later
        currentPlayer.gainMoney(600);
        Setting.getInstance().setCurrentPlayer(currentPlayer);
        ArrayList<Player> players = Setting.getInstance().getPlayers();
        players.set(Setting.getInstance().getCurrentTurn() - 1, currentPlayer);
        if (Setting.getInstance().getCurrentTurn() == Setting.getInstance().getPlayerNum()) {
            // handle last player's turn here
            Setting.getInstance().setCurrentTurn(1);
            Setting.getInstance().incrementCurrentPhase();
        } else {
            Setting.getInstance().incrementCurrentTurn();
        }
        Setting.getInstance().setCurrentPlayer(Setting.getInstance().getCurrentTurn() - 1, players);
        //System.out.println(Setting.getInstance().getCurrentTurn());
        stage = (Stage) energyMuleButton.getScene().getWindow();
        stage.close();
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        currentPlayer = Setting.getInstance().getCurrentPlayer();
        
    }    
    
}
