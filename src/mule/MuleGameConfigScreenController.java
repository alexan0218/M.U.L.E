/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author Alex
 */
public class MuleGameConfigScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button confirmButton;
    @FXML
    public void handleButtonAction(ActionEvent e) throws IOException {
        System.out.println("game config done");
        Parent player_config_parent = FXMLLoader.load(getClass().getResource("MulePlayerConfig.fxml"));
        Scene player_config_scene = new Scene(player_config_parent);
        Stage player_config_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        player_config_stage.setScene(player_config_scene);
        player_config_stage.show();
    }
    
    final String[] difficulties = new String[]{"Beginner", "Intermediate", "Expert"};
    final String[] maps = new String[]{"Summoner's Rift", "Howling Abyss", "Twisted Treeline"};
    public String difficulty;
    public String mapName;
    public int playerNum;
    
    @FXML
    private ChoiceBox<String> myDifficulty;
    @FXML
    private ChoiceBox<String> myMaps;
    @FXML
    private ChoiceBox<String> myChoices;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        URL mp4resource = getClass().getResource("TFBOYZ.mp3");
        Media media = new Media(mp4resource.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        
        myDifficulty.setItems(FXCollections.observableArrayList("Beginner", "Intermediate", "Expert"));
        myDifficulty.setValue("Intermediate");
        Setting.getInstance().setDifficulty("Intermediate");
        myMaps.setItems(FXCollections.observableArrayList("Summoner's Rift", "Howling Abyss", "Twisted Treeline"));
        myMaps.setValue("Summoner's Rift");
        Setting.getInstance().setMap("Summoner's Rift");
        myChoices.setItems(FXCollections.observableArrayList("one", "two", "three", "four"));
        myChoices.setValue("one");
        Setting.getInstance().setPlayerNum(1);
        
        myDifficulty.getSelectionModel().selectedIndexProperty().addListener(new
            ChangeListener<Number>() {
                public void changed(ObservableValue ov,
                    Number value, Number new_value) {
                        difficulty = difficulties[new_value.intValue()];
                        Setting.getInstance().setDifficulty(difficulty);
            }
        });
        myMaps.getSelectionModel().selectedIndexProperty().addListener(new
            ChangeListener<Number>() {
                public void changed(ObservableValue ov,
                    Number value, Number new_value) {
                        mapName = maps[new_value.intValue()];
                        Setting.getInstance().setMap(mapName);
            }
        });
        myChoices.getSelectionModel().selectedIndexProperty().addListener(new
            ChangeListener<Number>() {
                public void changed(ObservableValue ov,
                    Number value, Number new_value) {
                        playerNum = new_value.intValue() + 1;
                        Setting.getInstance().setPlayerNum(playerNum);
            }
        });
    }
    
    
}
