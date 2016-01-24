/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Alex
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button startButton;
    
    @FXML
    private void handleButtonAction(ActionEvent e) throws IOException {
        System.out.println("Game Started");
        Parent game_config_parent = FXMLLoader.load(getClass().getResource("MuleGameConfigScreen.fxml"));
        Scene game_config_scene = new Scene(game_config_parent);
        Stage game_config_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        game_config_stage.setScene(game_config_scene);
        game_config_stage.show();
    }
    
    @FXML
    private void loadGame(ActionEvent e) throws IOException {
        Setting.getInstance().setLoadGameTrue();
        System.out.println("loading old game");
        Parent game_config_parent = FXMLLoader.load(getClass().getResource("MuleGameWindow.fxml"));
        Scene game_config_scene = new Scene(game_config_parent);
        Stage game_config_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        game_config_stage.setScene(game_config_scene);
        game_config_stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
