package mule.model.chess;

import mule.model.Move;
import mule.model.PieceType;
import mule.model.Position;

/**
 * Created by joe on 10/26/15.
 */
public class PromotionMove extends Move {

    private PieceType promotingTo;

    public PromotionMove(Position start, Position destination,
                         PieceType promotingTo) {
        this(start, destination, false, false, false);
        this.setPromotingTo(promotingTo);
    }

    public PromotionMove(Position start, Position destination, boolean isJump,
                         boolean cannotCapture, boolean mustCapture) {
        super(start, destination, isJump, cannotCapture, mustCapture);
    }

    public PieceType getPromotingTo() {
        return promotingTo;
    }

    public void setPromotingTo(PieceType promotingTo) {
        this.promotingTo = promotingTo;
    }

    @Override
    public String toString() {
        return "PROMO:" + promotingTo.toString() + ":" + super.toString();
    }
}
