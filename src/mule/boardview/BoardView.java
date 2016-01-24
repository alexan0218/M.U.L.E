package mule.boardview;

import java.util.List;
import java.util.Map;

import mule.gamecontrol.GameController;
import mule.gamecontrol.GameState;
import mule.gamecontrol.NetworkedChessController;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import mule.model.Move;
import mule.model.Piece;
import mule.model.PieceType;
import mule.model.Position;
import mule.model.Side;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import javafx.scene.paint.Color;
import mule.model.IllegalMoveException;
import java.util.Set;
import javafx.scene.control.ChoiceDialog;


/**
 * A class for a view for a chess board. This class must have a reference
 * to a GameController for chess playing chess
 * @author Gustavo
 * @date Oct 20, 2015
 */
public class BoardView {

    /* You may add more instance data if you need it */
    protected GameController controller;
    private GridPane gridPane;
    private Tile[][] tiles;
    private Text sideStatus;
    private Text state;
    private boolean isRotated;
    private Tile movedTile;
    private boolean click;

    //GREEN(Color.rgb(152, 251, 152, 0.5)) possible move
    //RED(Color.rgb(255, 100, 100, 0.5)) promote
    //YELLOW(Color.rgb(255, 255, 153, 0.5)) when selecting
    //LIGHTTAN(Color.rgb(255, 235, 205, 0.5)) moved from
    //TAN(Color.rgb(180, 150, 120, 0.5)) destination

    /**
     * Construct a BoardView with an instance of a GameController
     * and a couple of Text object for displaying info to the user
     * @param controller The controller for the chess game
     * @param state A Text object used to display state to the user
     * @param sideStatus A Text object used to display whose turn it is
     */
    public BoardView(GameController controller, Text state, Text sideStatus) {
        this.controller = controller;
        this.state = state;
        this.sideStatus = sideStatus;
        tiles = new Tile[8][8];
        gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color : goldenrod;");
        reset(controller);
        click = true;
    }

    /**
     * Listener for clicks on a tile
     *
     * @param tile The tile attached to this listener
     * @return The event handler for all tiles.
     */
    private EventHandler<? super MouseEvent> tileListener(Tile tile) {
        return event -> {
            if (controller instanceof NetworkedChessController
                    && controller.getCurrentSide()
                    != ((NetworkedChessController) controller).getLocalSide()) {
                //not your turn!
                return;
            }

            // Don't change the code above this :)
            if (click) {
                firstClick(tile);
            } else if (!click) {
                secondClick(tile);
            }
        };
    }

    /**
     * Perform the first click functions, like displaying
     * which are the valid moves for the piece you clicked.
     * @param tile The TileView that was clicked
     */
    private void firstClick(Tile tile) {
        controller.beginTurn();
        Set<Move> moves = controller.getMovesForPieceAt(tile.getPosition());
        if (moves.isEmpty()) {
            return;
        }
        if (tile.getSymbol().equals("")) {
            return;
        }
        movedTile = tile;
        tile.highlight(Color.rgb(255, 255, 153, 0.5));

        for (Move m : moves) {
            Tile t = getTileAt(m.getDestination());
            if (controller.moveResultsInCapture(m)) {
                t.highlight(Color.rgb(255, 100, 100, 0.5));
            } else {
                t.highlight(Color.rgb(152, 251, 152, 0.5));
            }
        }
        click = false;
    }

    /**
     * Perform the second click functions, like
     * sending moves to the controller but also
     * checking that the user clicked on a valid position.
     * If they click on the same piece they clicked on for the first click
     * then you should reset to click state back to the first click and clear
     * the highlighting effected on the board.
     *
     * @param tile the TileView at which the second click occurred
     */
    private void secondClick(Tile tile) {
        Set<Move> moves = controller.getMovesForPieceAt(
            movedTile.getPosition());
        if (tile.getPosition().equals(movedTile.getPosition())) {
            movedTile.highlight(Color.TRANSPARENT);
            for (Move m : moves) {
                getTileAt(m.getDestination()).highlight(Color.TRANSPARENT);
            }
            click = true;
        } else {
            for (Move m : moves) {
                Position destination = m.getDestination();
                if (tile.getPosition().equals(destination)) {
                    try {
                        controller.makeMove(m);
                        movedTile.highlight(Color.TRANSPARENT);
                        for (Move mm : moves) {
                            getTileAt(mm.getDestination()).highlight(
                                Color.TRANSPARENT);
                        }
                        click = true;
                        controller.endTurn();
                        controller.beginTurn();
                        return;
                    } catch (IllegalMoveException e) {
                        System.out.println(e.getMessage());
                        return;
                    }
                }
            }
        }
    }

    /**
     * This method should be called any time a move is made on the back end.
     * It should update the tiles' highlighting and symbols to reflect the
     * change in the board state.
     *
     * @param moveMade the move to show on the view
     * @param capturedPositions a list of positions where pieces were captured
     *
     */
    public void updateView(Move moveMade, List<Position> capturedPositions) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                try {
                    String s = controller.getSymbolForPieceAt(
                        new Position(row, col));
                    tiles[row][col].clear();
                    tiles[row][col].setSymbol(s);
                } catch (Exception e) {
                    tiles[row][col].clear();
                }
            }
        }
        Tile start = getTileAt(moveMade.getStart());
        Tile destination = getTileAt(moveMade.getDestination());
        start.highlight(Color.rgb(255, 235, 205, 0.5));
        destination.highlight(Color.rgb(255, 235, 205, 0.5));
        for (Position p : capturedPositions) {
            getTileAt(p).highlight(Color.rgb(180, 150, 120, 0.5));
        }
    }

    /**
     * Asks the user which PieceType they want to promote to
     * (suggest using Alert). Then it returns the Piecetype user selected.
     *
     * @return  the PieceType that the user wants to promote their piece to
     */
    private PieceType handlePromotion() {
        List<PieceType> promo = controller.getPromotionTypes();
        ChoiceDialog<PieceType> cd =
            new ChoiceDialog(controller.getDefaultPromotionType(), promo);
        cd.setTitle("Promotion");
        cd.setHeaderText("Which chess piece would you like to promote");
        cd.setContentText("Choose your option.");

        Optional<PieceType> result = cd.showAndWait();
        PieceType p = controller.getDefaultPromotionType();
        if (result.isPresent()) {
            p = result.get();
        } else {
            p = controller.getDefaultPromotionType();
        }
        return p;
    }

    /**
     * Handles a change in the GameState (ie someone in check or stalemate).
     * If the game is over, it should open an Alert and ask to keep
     * playing or exit.
     *
     * @param s The new Game State
     */
    public void handleGameStateChange(GameState s) {
        this.state.setText(s.toString());
        if (s.isGameOver()) {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Game Over");
            a.setHeaderText(s.toString());
            a.setContentText("Continue playing or exit?");

            ButtonType buttonContinue = new ButtonType("Continue");
            ButtonType buttonExit = new ButtonType("Exit");

            a.getButtonTypes().setAll(buttonContinue, buttonExit);

            Optional<ButtonType> result = a.showAndWait();
            if (result.get() == buttonContinue) {
                reset(controller.getNewInstance());
                a.close();
            } else if (result.get() == buttonExit) {
                a.close();
                Platform.exit();
            }
        }
    }

    /**
     * Updates UI that depends upon which Side's turn it is
     *
     * @param s The new Side whose turn it currently is
     */
    public void handleSideChange(Side s) {
        sideStatus.setText(s.toString() + "'s Turn");
    }

    /**
     * Resets this BoardView with a new controller.
     * This moves the chess pieces back to their original configuration
     * and calls startGame() at the end of the method
     * @param newController The new controller for this BoardView
     */
    public void reset(GameController newController) {
        if (controller instanceof NetworkedChessController) {
            ((NetworkedChessController) controller).close();
        }
        controller = newController;
        isRotated = false;
        if (controller instanceof NetworkedChessController) {
            Side mySide
                = ((NetworkedChessController) controller).getLocalSide();
            if (mySide == Side.BLACK) {
                isRotated = true;
            }
        }
        sideStatus.setText(controller.getCurrentSide() + "'s Turn");

        // controller event handlers
        // We must force all of these to run on the UI thread
        controller.addMoveListener(
                (Move move, List<Position> capturePositions) ->
                Platform.runLater(
                    () -> updateView(move, capturePositions)));

        controller.addCurrentSideListener(
                (Side side) -> Platform.runLater(
                    () -> handleSideChange(side)));

        controller.addGameStateChangeListener(
                (GameState state) -> Platform.runLater(
                    () -> handleGameStateChange(state)));

        controller.setPromotionListener(() -> handlePromotion());


        addPieces();
        controller.startGame();
        if (isRotated) {
            setBoardRotation(180);
        } else {
            setBoardRotation(0);
        }
    }

    /**
     * Initializes the gridPane object with the pieces from the GameController.
     * This method should only be called once before starting the game.
     */
    private void addPieces() {
        gridPane.getChildren().clear();
        Map<Piece, Position> pieces = controller.getAllActivePiecesPositions();
        /* Add the tiles */
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Tile tile = new TileView(new Position(row, col));
                gridPane.add(tile.getRootNode(),
                        1 + tile.getPosition().getCol(),
                        1 + tile.getPosition().getRow());
                GridPane.setHgrow(tile.getRootNode(), Priority.ALWAYS);
                GridPane.setVgrow(tile.getRootNode(), Priority.ALWAYS);
                getTiles()[row][col] = tile;
                tile.getRootNode().setOnMouseClicked(
                        tileListener(tile));
                tile.clear();
                tile.setSymbol("");
            }
        }
        /* Add the pieces */
        for (Piece p : pieces.keySet()) {
            Position placeAt = pieces.get(p);
            getTileAt(placeAt).setSymbol(p.getType().getSymbol(p.getSide()));
        }
        /* Add the coordinates around the perimeter */
        for (int i = 1; i <= 8; i++) {
            Text coord1 = new Text((char) (64 + i) + "");
            GridPane.setHalignment(coord1, HPos.CENTER);
            gridPane.add(coord1, i, 0);

            Text coord2 = new Text((char) (64 + i) + "");
            GridPane.setHalignment(coord2, HPos.CENTER);
            gridPane.add(coord2, i, 9);

            Text coord3 = new Text(9 - i + "");
            GridPane.setHalignment(coord3, HPos.CENTER);
            gridPane.add(coord3, 0, i);

            Text coord4 = new Text(9 - i + "");
            GridPane.setHalignment(coord4, HPos.CENTER);
            gridPane.add(coord4, 9, i);
        }
    }

    private void setBoardRotation(int degrees) {
        gridPane.setRotate(degrees);
        for (Node n : gridPane.getChildren()) {
            n.setRotate(degrees);
        }
    }

    /**
     * Gets the view to add to the scene graph
     * @return A pane that is the node for the chess board
     */
    public Pane getView() {
        return gridPane;
    }

    /**
     * Gets the tiles that belong to this board view
     * @return A 2d array of TileView objects
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    private Tile getTileAt(int row, int col) {
        return getTiles()[row][col];
    }

    private Tile getTileAt(Position p) {
        return getTileAt(p.getRow(), p.getCol());
    }

}
