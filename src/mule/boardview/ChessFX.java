package mule.boardview;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import mule.gamecontrol.AIChessController;
import mule.gamecontrol.ChessController;
import mule.gamecontrol.GameController;
import mule.gamecontrol.NetworkedChessController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;

/**
 * Main class for the chess application
 * Sets up the top level of the GUI
 * @author Gustavo
 * @version
 */
public class ChessFX extends Application {

    private GameController controller;
    private BoardView board;
    private Text state;
    private Text sideStatus;
    private VBox root;

    @Override
    public void start(Stage primaryStage) {
        this.controller = new ChessController();
        this.state = new Text("Ongoing");
        this.sideStatus =
            new Text(controller.getCurrentSide().toString() + "'s Turn");
        this.board = new BoardView(controller, state, sideStatus);
        this.root = new VBox();
        this.root.getChildren().addAll(board.getView());
        VBox lowerPane = new VBox();

        Button reset = new Button("Reset");
        reset.setOnAction(e -> board.reset(new ChessController()));

        Button playComp = new Button("Play Computer");
        playComp.setOnAction(e -> board.reset(new AIChessController()));

        HBox upLeft = new HBox(reset, playComp);
        HBox.setMargin(reset, new Insets(0, 10, 0, 0));
        HBox.setMargin(upLeft, new Insets(10, 0, 0, 0));
        HBox.setHgrow(reset, Priority.ALWAYS);

        HBox upRight = new HBox(sideStatus, state);
        HBox.setMargin(sideStatus, new Insets(0, 10, 0, 0));
        upRight.setAlignment(Pos.CENTER_RIGHT);

        HBox up = new HBox(upLeft, upRight);
        HBox.setHgrow(upRight, Priority.ALWAYS);


        Text ip = new Text();
        try {
            ip = new Text(InetAddress.getLocalHost().toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        TextField inputIP = new TextField();
        inputIP.setPromptText("a.b.c.x");

        Button host = new Button("Host");
        host.setOnMouseClicked(makeHostListener());

        Button join = new Button("Join");
        join.setOnMouseClicked(makeJoinListener(inputIP));

        HBox lowerRight = new HBox(inputIP, join);
        lowerRight.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(join, new Insets(0, 0, 0, 5));
        HBox.setHgrow(lowerRight, Priority.ALWAYS);

        HBox lower = new HBox(host, ip, lowerRight);
        HBox.setMargin(ip, new Insets(5, 0, 0, 5));

        root.setPadding(new Insets(10));
        root.getChildren().add(up);
        root.getChildren().add(lower);
        VBox.setMargin(lower, new Insets(20, 0, 10, 0));
        VBox.setMargin(root, new Insets(10, 0, 0, 0));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chess");
        primaryStage.show();
    }

    private EventHandler<? super MouseEvent> makeHostListener() {
        return event -> {
            board.reset(new NetworkedChessController());
            System.out.println("A player has joined.");
            System.out.println("You can now start!");
        };
    }

    private EventHandler<? super MouseEvent> makeJoinListener(TextField input) {
        return event -> {
            try {
                InetAddress addr = InetAddress.getByName(input.getText());
                GameController newController
                    = new NetworkedChessController(addr);
                board.reset(newController);
                System.out.println("You have joined a game.");
                System.out.println("You can now start!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }


    public static void main(String[] args) {
        launch(args);
    }
}
