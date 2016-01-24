/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;

import javafx.scene.paint.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.T;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alex
 */
public class MulePlayerConfigController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button confirmButton;
    @FXML
    private TabPane tabPane;
    @FXML
    private TextField player1NameTextField;
    @FXML
    private TextField player2NameTextField;
    @FXML
    private TextField player3NameTextField;
    @FXML
    private TextField player4NameTextField;
    @FXML
    private ChoiceBox<String> player1Race;
    @FXML
    private ChoiceBox<String> player2Race;
    @FXML
    private ChoiceBox<String> player3Race;
    @FXML
    private ChoiceBox<String> player4Race;
    @FXML
    private ColorPicker player1Color;
    @FXML
    private ColorPicker player2Color;
    @FXML
    private ColorPicker player3Color;
    @FXML
    private ColorPicker player4Color;
    @FXML
    private Button player1Reset;
    @FXML
    private Button player2Reset;
    @FXML
    private Button player3Reset;
    @FXML
    private Button player4Reset;
    @FXML
    private Button resetAllButton;
    
    @FXML
    private void handleConfirmButtonAction(ActionEvent e) throws IOException {
        //should save all players' info first
        Setting setting = Setting.getInstance();
        int playerNum = setting.getPlayerNum();
        String difficluty = setting.getDifficulty();
        switch (playerNum) {
            case 1: setting.savePlayer(new Player(player1NameTextField.getText(), player1Race.getValue(), player1Color.getValue(), 0, difficluty));
                    break;
            case 2: setting.savePlayer(new Player(player1NameTextField.getText(), player1Race.getValue(), player1Color.getValue(), 0, difficluty));
                    setting.savePlayer(new Player(player2NameTextField.getText(), player2Race.getValue(), player2Color.getValue(), 1, difficluty));
                    break;
            case 3: setting.savePlayer(new Player(player1NameTextField.getText(), player1Race.getValue(), player1Color.getValue(), 0, difficluty));
                    setting.savePlayer(new Player(player2NameTextField.getText(), player2Race.getValue(), player2Color.getValue(), 1, difficluty));
                    setting.savePlayer(new Player(player3NameTextField.getText(), player3Race.getValue(), player3Color.getValue(), 2, difficluty));
                    break;
            case 4: setting.savePlayer(new Player(player1NameTextField.getText(), player1Race.getValue(), player1Color.getValue(), 0, difficluty));
                    setting.savePlayer(new Player(player2NameTextField.getText(), player2Race.getValue(), player2Color.getValue(), 1, difficluty));
                    setting.savePlayer(new Player(player3NameTextField.getText(), player3Race.getValue(), player3Color.getValue(), 2, difficluty));
                    setting.savePlayer(new Player(player4NameTextField.getText(), player4Race.getValue(), player4Color.getValue(), 3, difficluty));
                    break;
            default: System.out.println(playerNum);
                    break;
        }
        //debug place
        for (int i = 0; i < Setting.getInstance().getPlayerNum(); i++) {
            System.out.println(setting.getPlayers().get(i));
        }
        
        System.out.println("player config done");
        Parent game_window_parent = FXMLLoader.load(getClass().getResource("MuleGameWindow.fxml"));
        Scene game_window_scene = new Scene(game_window_parent);
        Stage game_window_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        game_window_stage.setScene(game_window_scene);
        game_window_stage.show();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        for (Race r : Race.values()) {
            player1Race.getItems().add(r.toString());
            player2Race.getItems().add(r.toString());
            player3Race.getItems().add(r.toString());
            player4Race.getItems().add(r.toString());
            
            player1Race.setValue(Race.HUMAN.toString());
            player2Race.setValue(Race.HUMAN.toString());
            player3Race.setValue(Race.HUMAN.toString());
            player4Race.setValue(Race.HUMAN.toString());
            
        }
        
        int playerNum = Setting.getInstance().getPlayerNum();
        switch (playerNum) {
            case 1: tabPane.getTabs().remove(1, 4);
                    break;
            case 2: tabPane.getTabs().remove(2, 4);
                    break;
            case 3: tabPane.getTabs().remove(3, 4);
                    break;
            case 4: break;
            default: System.out.println(playerNum);
                    break;
        }
        
        player1Reset.setOnAction((event) -> {
            player1NameTextField.setText(" ");
            player1Race.setValue(Race.HUMAN.toString());
            player1Color.setValue(Color.WHITE);
        });
        player2Reset.setOnAction((event) -> {
            player2NameTextField.setText(" ");
            player2Race.setValue(Race.HUMAN.toString());
            player2Color.setValue(Color.WHITE);
        });
        player3Reset.setOnAction((event) -> {
            player3NameTextField.setText(" ");
            player3Race.setValue(Race.HUMAN.toString());
            player3Color.setValue(Color.WHITE);
        });
        player4Reset.setOnAction((event) -> {
            player4NameTextField.setText(" ");
            player4Race.setValue(Race.HUMAN.toString());
            player4Color.setValue(Color.WHITE);
        });
        resetAllButton.setOnAction((event) -> {
            player1NameTextField.setText(" ");
            player1Race.setValue(Race.HUMAN.toString());
            player1Color.setValue(Color.WHITE);
            player2NameTextField.setText(" ");
            player2Race.setValue(Race.HUMAN.toString());
            player2Color.setValue(Color.WHITE);
            player3NameTextField.setText(" ");
            player3Race.setValue(Race.HUMAN.toString());
            player3Color.setValue(Color.WHITE);
            player4NameTextField.setText(" ");
            player4Race.setValue(Race.HUMAN.toString());
            player4Color.setValue(Color.WHITE);
        });
        
    }

    
    
    
}
//24号11点