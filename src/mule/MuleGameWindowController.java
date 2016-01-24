/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author Alex
 */
public class MuleGameWindowController implements Initializable, gamingEngine {

    /**
     * Initializes the controller class.
     */
    private Game game = new Game(Setting.getInstance().getPlayerNum(), Setting.getInstance().getDifficulty(),Setting.getInstance().getMap());
    private ArrayList<Player> players = Setting.getInstance().getPlayers();
    private ArrayList<Button> buttons = new ArrayList<>();
    private ArrayList<Plot> plots;
    private int currentTurn;
    private int currentPhase;
    private int currentRound;
    private ArrayList<Label> states = new ArrayList<>();
    
    private RandomEvent event1 = new RandomEvent(1,"YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS." );
    private RandomEvent event2 = new RandomEvent(2,"A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE." );
    private RandomEvent event3 = new RandomEvent(3,"THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $ 8*m." );
    private RandomEvent event4 = new RandomEvent(4,"YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $2*m." );
    private RandomEvent event5 = new RandomEvent(5,"MOTHER EARTH SEND 5 PACKAGE OF FOOD, ENERGY AND ORE" );
    private RandomEvent event6 = new RandomEvent(6,"BRAVO GT STUDENT BROK INTO UGA STORAGE AND GAIN 0.5 OF YOUR ENERGY" );
    private RandomEvent event7 = new RandomEvent(7,"ACADEMIC MISCONDUCT: YOU LOST ALL YOUR ENERGY." );
    private RandomEvent event8 = new RandomEvent(8,"FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $4*m." );
    private RandomEvent event9 = new RandomEvent(9,"MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD." );
    private RandomEvent event10 = new RandomEvent(10,"YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $6*m TO CLEAN IT UP." );
    private RandomEvent event11 = new RandomEvent(11,"A STRONG FLU ATTACKED YOUR HOME, COSUMING HALF OF YOUR ENERGY." );
    private RandomEvent event12 = new RandomEvent(12,"FIZZ WANT SOME CARROTS, HE TOOK ONE OF YOUR FOOD." );
    private ArrayList<RandomEvent> allEvents = new ArrayList<>();
    private ArrayList<RandomEvent> goodEvents = new ArrayList<>();
 
    //one town;
    @FXML
    private Button town;
    @FXML
    private Button P0;
    @FXML
    private Button P1;
    @FXML
    private Button P2;
    @FXML
    private Button P3;
    @FXML
    private Button P4;
    @FXML
    private Button P5;
    @FXML
    private Button P6;
    @FXML
    private Button P7;
    @FXML
    private Button P8;
    @FXML
    private Button P9;
    @FXML
    private Button P10;
    @FXML
    private Button P11;
    @FXML
    private Button P12;
    @FXML
    private Button P13;
    @FXML
    private Button P14;
    @FXML
    private Button P15;
    @FXML
    private Button P16;
    @FXML
    private Button P17;
    @FXML
    private Button P18;
    @FXML
    private Button P19;
    @FXML
    private Button P20;
    @FXML
    private Button P21;
    @FXML
    private Button P22;
    @FXML
    private Button P23;
    @FXML
    private Button P24;
    @FXML
    private Button P25;
    @FXML
    private Button P26;
    @FXML
    private Button P27;
    @FXML
    private Button P28;
    @FXML
    private Button P29;
    @FXML
    private Button P30;
    @FXML
    private Button P31;
    @FXML
    private Button P32;
    @FXML
    private Button P33;
    @FXML
    private Button P34;
    @FXML
    private Button P35;
    @FXML
    private Button P36;
    @FXML
    private Button P37;
    @FXML
    private Button P38;
    @FXML
    private Button P39;
    @FXML
    private Button P40;
    @FXML
    private Button P41;
    @FXML
    private Button P42;
    @FXML
    private Button P43;
    @FXML
    private Button P44;
    @FXML
    private Label currentState;
    @FXML
    private Label player1State;
    @FXML
    private Label player2State;
    @FXML
    private Label player3State;
    @FXML
    private Label player4State;
    @FXML
    private Label currentPlayer;
    @FXML
    private Button passButton;
    @FXML
    private Label timeCD;
    
/*    int remainTime = 50;
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(new Runnable() {
                public void run() {
                    remainTime--;
                    System.out.println(remainTime);
                    //timeCD.setText("remain: " + remainTime + " seconds");            
                    if (remainTime == 0) {
                        timer.cancel();
                        timer.purge();
                        //timeCD.setText("time's up! Please return to the map.");
                    }           
                }
            });
        }
    };
    public void start() {
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }
    */
    
    @FXML
    private void saveData(ActionEvent e) throws java.lang.NullPointerException {
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/muleGame", "root", "");
            PreparedStatement myStmt = myConn.prepareStatement("Truncate table player");
            myStmt.execute();
            myStmt = myConn.prepareStatement("Truncate table process");
            myStmt.execute();
            
            for (Player p:Setting.getInstance().getPlayers()) {
                myStmt = myConn.prepareStatement("insert into player "
                       + " (name, color, race, money, food, energy, ore, crystite, plots)"
                       + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                myStmt.setString(1, p.getName());
                myStmt.setString(2, p.getColor().toString());
                myStmt.setString(3, p.getRace());
                myStmt.setInt(4, p.getMoney());
                myStmt.setInt(5, p.getFood());
                myStmt.setInt(6, p.getEnergy());
                myStmt.setInt(7, p.getOre());
                myStmt.setInt(8, p.getCrystite());
                
                String plotTags = "";
                ArrayList<Plot> playerPlots = p.getPlots();
                for (int i = 0; i < playerPlots.size(); i++) {
                    plotTags = plotTags + playerPlots.get(i).getTag() + " ";
                }
                
                myStmt.setString(9, plotTags);
                
                myStmt.execute();
            }
            myStmt = myConn.prepareStatement("insert into process "
                       + " (turn, phase, round)"
                       + " values (?, ?, ?)");
            Setting s = Setting.getInstance();
            myStmt.setInt(1, s.getCurrentTurn());
            myStmt.setInt(2, s.getCurrentPhase());
            myStmt.setInt(3, s.getCurrentRound());
            myStmt.execute();
            
            System.out.println("save complete");
            
            myConn.close();
            myStmt.close();
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        
    }
    
    @FXML
    public void passButtonAction(ActionEvent e) {
        pass();       
    }
    
    @FXML
    public void plotButtonAction(ActionEvent e) throws java.lang.NullPointerException {
        //int turn = game.getTurn();
        changeState(Setting.getInstance().getCurrentPlayer());
        int turn = Setting.getInstance().getPlayerNum();
        
        if (currentPhase == 2) {
            //go to next phase 
            //TODO, ur code goes here : 
            if ((Button) e.getSource() != town) {
                currentTurn = Setting.getInstance().getCurrentTurn();
                currentPhase = Setting.getInstance().getCurrentPhase();
                currentRound = Setting.getInstance().getCurrentRound();
                
                
               
                if (isLowestPlayer(Setting.getInstance().getCurrentPlayer())) {
                        System.out.println("is lowest one, only good events");
                        shootGoodEvent(currentRound, Setting.getInstance().getCurrentPlayer());
                    } else {
                        System.out.println("not lowest one, all events");
                        shootAllEvent(currentRound, Setting.getInstance().getCurrentPlayer());
                    } 
                
                Button b = (Button) e.getSource();
                int cursor = -1;
                for (int i = 0; i < buttons.size(); i++) {
                    if (b.equals(buttons.get(i))) {
                        cursor = i;
                        break;
                    }
                }
                Plot currentPlot = plots.get(cursor);
                
                
                
                if (currentPlot.getOwner() != null && currentPlot.getOwner().getName().equals(Setting.getInstance().getCurrentPlayer().getName())) {
                    //Setting.getInstance().getCurrentPlayer().getMules().get(0).setPlotSetAt(currentPlot);                    
                    currentPlot.setMule(Setting.getInstance().getCurrentPlayer().getMules().get(0));
                    
                    
                    
                    if (Setting.getInstance().getCurrentPlayer().getEnergy() >= 1) {
                        
                        MultiUsage mule = currentPlot.getMule();
                        Player currentPlayer = Setting.getInstance().getCurrentPlayer();
                        currentPlayer.spendEnergy(1);
                        if (mule != null) {
                            switch(mule.getCategory()) {
                                case 1: currentPlayer.gainFood(currentPlot.getFoodProduction());
                                        break;
                                case 2: currentPlayer.gainEnergy(currentPlot.getEnergyProduction());
                                        break;
                                case 3: currentPlayer.gainOre(currentPlot.getOreProduction());
                                        break; 
                                case 4: currentPlayer.gainCrystite(currentPlot.getCrystiteProduction());
                                        break;
                            }
                            Setting.getInstance().setCurrentPlayer(currentPlayer);
                        }
                        
                        
                    }
                    Setting.getInstance().getCurrentPlayer().getMules().remove(0); 
                    Color currentColor = Setting.getInstance().getCurrentPlayer().getColor();
                    String hex = String.format( "#%02X%02X%02X",
                    (int)( currentColor.getRed() * 255*0.4 ),
                    (int)( currentColor.getGreen() * 255*0.4 ),
                    (int)( currentColor.getBlue() * 255*0.4 ));
                    b.setStyle("-fx-base: " + hex + ";");
                }
            }
            changeState(Setting.getInstance().getCurrentPlayer());
            //Phase two ending 
            
            
        } else if (currentPhase == 1) {
            if (e.getSource() != getIntoTown) {
                Button b = (Button) e.getSource();
                //System.out.println(b.toString());
                int cursor = -1;
                for (int i = 0; i < buttons.size() ; i++) {
                    if (i != 22) {
                        //System.out.println(buttons.get(i).toString());
                        if (b.toString().equals(buttons.get(i).toString())) {
                            cursor = i;
                            //System.out.println("success" + cursor);
                            break;
                        }
                    }
                }
                Plot currentPlot = plots.get(cursor);
                if (!currentPlot.isOwned()) {
                    Player currentPlayer = players.get(currentTurn - 1);
                    //charge money
                    if (currentRound > 2) {
                        if (currentPlayer.getMoney() < 300) {
                            currentPlayer.setCanBuy(false);
                        } else {
                            currentPlayer.setCanBuy(true);
                        }
                        if (!currentPlayer.getCanBuy()) {
                            pass();
                        } else {
                            currentPlayer.spendMoney(300);
                            currentPlot.setOwner(currentPlayer);
                            currentPlot.setOwned(true);
                            currentPlayer.addPlot(currentPlot);
                            Color currentColor = currentPlayer.getColor();
                            String hex = String.format( "#%02X%02X%02X",
                            (int)( currentColor.getRed() * 255 ),
                            (int)( currentColor.getGreen() * 255 ),
                            (int)( currentColor.getBlue() * 255 ) );
                            b.setStyle("-fx-base: " + hex + ";");
                            currentTurn++;
                            if (currentTurn > turn) {
                                currentPhase ++;
                                currentTurn = 1;
                                // MuleGameWindowController mainController = new MuleGameWindowController();
                                // mainController.start();
                            }
                            Setting.getInstance().setCurrentPlayer(currentTurn - 1, players);
                            Setting.getInstance().setCurrentTurn(currentTurn);
                            Setting.getInstance().setCurrentPhase(currentPhase);
                            Setting.getInstance().setCurrentRound(currentRound);
                            changeState(currentPlayer);
                        }
                    } else {
                        currentPlot.setOwner(currentPlayer);
                        currentPlot.setOwned(true);
                        currentPlayer.addPlot(currentPlot);
                        Color currentColor = currentPlayer.getColor();
                        String hex = String.format( "#%02X%02X%02X",
                        (int)( currentColor.getRed() * 255 ),
                        (int)( currentColor.getGreen() * 255 ),
                        (int)( currentColor.getBlue() * 255 ) );
                        b.setStyle("-fx-base: " + hex + ";");
                        currentTurn++;
                        if (currentTurn > turn) {
                            currentPhase ++;
                            currentTurn = 1;
                            // MuleGameWindowController mainController = new MuleGameWindowController();
                            // mainController.start();
                        }
                        Setting.getInstance().setCurrentPlayer(currentTurn - 1, players);
                        Setting.getInstance().setCurrentTurn(currentTurn);
                        Setting.getInstance().setCurrentPhase(currentPhase);
                        Setting.getInstance().setCurrentRound(currentRound);
                        changeState(currentPlayer);
                    }               
                    //update all status
                    currentState.setText("turn:" + currentTurn + " phase:" + currentPhase + " round:" + currentRound);
                    this.currentPlayer.setText("current: " + players.get(currentTurn - 1).getName());
                }
            }           
        } else if (currentPhase == 3) {
            //handle phase 3
            currentPhase = 1;
            Setting.getInstance().setCurrentPhase(1);
            if (currentRound >= 12) {
                currentState.setText("Game ended!");
            } else {
                players = Setting.getInstance().getPlayers();
                currentRound++;
                Collections.sort(players);
                Setting.getInstance().setPlayers(players);
                currentPhase = 1;
                currentState.setText("turn:" + currentTurn + " phase:" + currentPhase + " round:" + currentRound);
                this.currentPlayer.setText("current: " + players.get(currentTurn - 1).getName());
            }
        }        
    }
    
    public void changeState(Player p) {
        int tag = p.getTag();
        states.get(tag).setText(p.getName() + " $:" + p.getMoney() + " score:" + p.getScore() + "\nf:" + p.getFood() + " e:" + p.getEnergy() + " o:" + p.getOre() + " c:" + p.getCrystite());
        //System.out.println(Setting.getInstance().getCurrentPlayer());
    }
    
    public void pass() {
        if (currentPhase > 1) {
            //go to next phase
            //
            if (currentRound >= 12) {
                currentState.setText("Game ended!");
            } else {
                currentRound++;
                Collections.sort(players);
                Setting.getInstance().setPlayers(players);
                currentPhase = 1;
                currentState.setText("turn:" + currentTurn + " phase:" + currentPhase + " round:" + currentRound);
            }
        } else {
            currentTurn++;
            
            if (currentTurn > Setting.getInstance().getPlayerNum()) {
                currentPhase ++;
                currentTurn = 1;
                //MuleGameWindowController mainController = new MuleGameWindowController();
                //mainController.start();
            }
            Setting.getInstance().setCurrentPlayer(currentTurn - 1, players);
            Setting.getInstance().setCurrentTurn(currentTurn);
            Setting.getInstance().setCurrentPhase(currentPhase);
            Setting.getInstance().setCurrentRound(currentRound);
            Player currentPlayer = players.get(currentTurn - 1);
            currentState.setText("turn:" + currentTurn + " phase:" + currentPhase + " round:" + currentRound);
            this.currentPlayer.setText("current: " + players.get(currentTurn - 1).getName());
        }
    }
   
    @FXML
    private Button getIntoTown;
    
    @FXML
    public void getIntoAndOutOfTown(ActionEvent e) throws IOException {
        Stage stage;
        Parent root;
        if (currentPhase == 2 && e.getSource() == getIntoTown) {
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("MuleTownWindow.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(getIntoTown.getScene().getWindow());
            stage.showAndWait();
        }
    }
    
    @FXML
    public void goInGame(ActionEvent e) throws IOException {
        Platform.runLater(new Runnable() {
            public void run() {             
               new mule.boardview.ChessFX().start(new Stage());
            }
        });
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        if (Setting.getInstance().isOldGame()) {
            initiateButtons();
            plots = new ArrayList<>(45);
                for (int i = 0; i < 45; i++) {
                    if ( i == 4 || i == 13 || i == 31 || i == 40) {
                        plots.add(new Plot(4, 2, 0, 0, true, 0, i));
                    } else if ( i == 2 || i == 10 || i == 26) {
                        plots.add(new Plot(1, 1, 2, 0, false, 1, i));
                    } else if ( i == 28 || i == 33 || i == 38 || i == 44) {
                        plots.add(new Plot(1, 1, 3, 0, false, 1, i));
                    } else if ( i == 6 || i == 17 || i == 18) {
                        plots.add(new Plot(1, 1, 4, 0, false, 1, i));
                    } else {
                        plots.add(new Plot(2, 3, 1, 0, i));
                    }
                }
            
            try {
                
                Class.forName("com.mysql.jdbc.Driver"); 
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/muleGame", "root", "");
                Statement myStmt = myConn.createStatement();
                ResultSet myRs = myStmt.executeQuery("select * from player");
                players = new ArrayList<>();
                int tag = 0;
                Player p;
                while (myRs.next()) {
                    p = new Player(myRs.getString("name"), myRs.getString("race"), Color.valueOf(myRs.getString("color")), tag, Setting.getInstance().getDifficulty());
                    p.setMoney(myRs.getInt("money"));
                    p.setFood(myRs.getInt("food"));
                    p.setEnergy(myRs.getInt("food"));
                    p.setOre(myRs.getInt("ore"));
                    p.setCrystite(myRs.getInt("crystite"));
                    String[] s = myRs.getString("plots").split(" ");
                    for (String str: s) {
                        int plotTag = Integer.parseInt(str);
                        plots.get(plotTag).setOwner(p);
                        plots.get(plotTag).setOwned(true);
                        p.addPlot(plots.get(plotTag));
                        
                        Button b = buttons.get(plotTag);
                        Color currentColor = p.getColor();
                        String hex = String.format( "#%02X%02X%02X",
                        (int)( currentColor.getRed() * 255 ),
                        (int)( currentColor.getGreen() * 255 ),
                        (int)( currentColor.getBlue() * 255 ) );
                        b.setStyle("-fx-base: " + hex + ";");
                    }
                    players.add(p);
                    tag++;
                }
                Setting.getInstance().setPlayers(players);
                
                
                myRs = myStmt.executeQuery("select * from process");
                
                while (myRs.next()) {
                    currentTurn = myRs.getInt("turn");
                    Setting.getInstance().setCurrentTurn(currentTurn);
                    currentPhase = myRs.getInt("phase");
                    Setting.getInstance().setCurrentPhase(currentPhase);
                    currentRound = myRs.getInt("round");
                    Setting.getInstance().setCurrentRound(currentRound);
                }
                
                
                
                allEvents.add(event1);
                allEvents.add(event2);
                allEvents.add(event3);
                allEvents.add(event4);
                allEvents.add(event5);
                allEvents.add(event6);
                allEvents.add(event7);
                allEvents.add(event8);
                allEvents.add(event9);
                allEvents.add(event10);
                allEvents.add(event11);
                allEvents.add(event12);
                goodEvents.add(event1);
                goodEvents.add(event2);
                goodEvents.add(event3);
                goodEvents.add(event4);
                goodEvents.add(event5);
                goodEvents.add(event6);
                
                Setting.getInstance().setCurrentPlayer(currentTurn - 1, players);
                currentState.setText("turn:" + currentTurn + " phase:" + currentPhase + " round:" + currentRound);
                Collections.sort(players);
                Setting.getInstance().setPlayers(players);
                this.currentPlayer.setText("current: " + players.get(currentTurn - 1).getName());
                Setting.getInstance().setPlayerNum(players.size());
                initializeStates();
                
                
                System.out.println("load complete");
            
                myConn.close();
                myStmt.close();
                myRs.close();
            } catch (SQLException ex) {
                System.out.println("An error occurred. Maybe user/password is invalid");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }
        } else {
            initiateButtons();
            plots = new ArrayList<>(45);
                for (int i = 0; i < 45; i++) {
                    if ( i == 4 || i == 13 || i == 31 || i == 40) {
                        plots.add(new Plot(4, 2, 0, 0, true, 0, i));
                    } else if ( i == 2 || i == 10 || i == 26) {
                        plots.add(new Plot(1, 1, 2, 0, false, 1, i));
                    } else if ( i == 28 || i == 33 || i == 38 || i == 44) {
                        plots.add(new Plot(1, 1, 3, 0, false, 1, i));
                    } else if ( i == 6 || i == 17 || i == 18) {
                        plots.add(new Plot(1, 1, 4, 0, false, 1, i));
                    } else {
                        plots.add(new Plot(2, 3, 1, 0, i));
                    }
                }
            currentTurn = 1;
            currentPhase = 1;
            currentRound = 1;
        
            allEvents.add(event1);
            allEvents.add(event2);
            allEvents.add(event3);
            allEvents.add(event4);
            allEvents.add(event5);
            allEvents.add(event6);
            allEvents.add(event7);
            allEvents.add(event8);
            allEvents.add(event9);
            allEvents.add(event10);
            allEvents.add(event11);
            allEvents.add(event12);
            goodEvents.add(event1);
            goodEvents.add(event2);
            goodEvents.add(event3);
            goodEvents.add(event4);
            goodEvents.add(event5);
            goodEvents.add(event6);
      
            Setting.getInstance().setCurrentPlayer(currentTurn - 1, players);
            Setting.getInstance().setCurrentTurn(currentTurn);
            currentState.setText("turn:" + currentTurn + " phase:" + currentPhase + " round:" + currentRound);
            Collections.sort(players);
            Setting.getInstance().setPlayers(players);
            this.currentPlayer.setText("current: " + players.get(currentTurn - 1).getName());
            initializeStates();
        }
        
        
        
        
    }    
    
    public boolean randomBoolean() {
        Random rand = new Random();
        int value = rand.nextInt(100) + 1;
        if (value <= 100) {
            System.out.println("shooting events");
            return true;
        }
        System.out.println("No events");
        return false;
    }
    
    public int randomInt(int i) {
        Random rand = new Random();
        int value = rand.nextInt(31);
        return value % i;
    }
    public boolean isLowestPlayer(Player target) {
        return (target.equals(players.get(0)));
    }
    public void shootGoodEvent(int currRound, Player target) {
        int i = randomInt(6);
        if (randomBoolean()) {   
            goodEvents.get(i).doEvent(i, currRound, target);
        }
    }
    
    public void shootAllEvent(int currRound, Player target) {
        int i = randomInt(12);
        if (randomBoolean()) {
            allEvents.get(i).doEvent(i, currRound, target);
        }
    }    
    
    public void initiateButtons() {
        Collections.addAll(buttons,  P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, P23, P24, P25, P26, P27, P28, P29,
                           P30, P31, P32, P33, P34, P35, P36, P37, P38, P39, P40, P41, P42, P43, P44);
        
    }
    
    public void initializeStates() {
        states.add(player1State);
        states.add(player2State);
        states.add(player3State);
        states.add(player4State);
        for (int i = 0; i < players.size(); i++) {
            states.get(i).setText(players.get(i).getName() + " $:" + players.get(i).getMoney() + " score:" + players.get(i).getScore() + "\nf:" + players.get(i).getFood() + " e:" + players.get(i).getEnergy() + " o:" + players.get(i).getOre() + " c:" + players.get(i).getCrystite());
        }
    }
    
}
