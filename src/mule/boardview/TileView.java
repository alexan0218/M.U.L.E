package mule.boardview;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import mule.model.Position;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 * View class for a tile on a chess board
 * A tile should be able to display a chess piece
 * as well as highlight itself during the game.
 *
 * @author XueYing Huang
 */
public class TileView implements Tile {

    private StackPane stack;
    private Rectangle rec, highlightedRec;
    private Position position;
    private Label symbol;

    /**
     * Creates a TileView with a specified position
     * @param p
     */
    public TileView(Position p) {
        this.position = p;
        this.stack = new StackPane();
        this.symbol = new Label("");
        this.symbol.setFont(Font.font("Calibri", 50));
        if ((p.getRow() + p.getCol()) % 2 == 0) {
            this.rec = new Rectangle(75, 75, Color.WHITE);
        } else {
            this.rec = new Rectangle(75, 75, Color.LIGHTGRAY);
        }
        this.highlightedRec = new Rectangle(75, 75, Color.TRANSPARENT);
        this.stack.getChildren().addAll(rec, highlightedRec, symbol);
    }


    @Override
    public Position getPosition() {
        return position;
    }


    @Override
    public Node getRootNode() {
        stack.getChildren().clear();
        stack.getChildren().addAll(rec, highlightedRec, symbol);
        return stack;
    }

    @Override
    public void setSymbol(String symbol) {
        this.symbol.setText(symbol);
    }


    @Override
    public String getSymbol() {
        return symbol.getText();
    }

    @Override
    public void highlight(Color color) {
        this.highlightedRec.setFill(color);
    }

    @Override
    public void clear() {
        this.highlightedRec.setFill(Color.TRANSPARENT);
        this.setSymbol("");
    }
}
