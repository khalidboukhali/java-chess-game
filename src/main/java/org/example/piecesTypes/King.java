package org.example.piecesTypes;

import org.example.board.Board;
import org.example.board.Piece;
import org.example.board.Position;
import org.example.exception.NotWithinOneSquareException;

/**
 * moves one square at a time
 */
public class King extends Piece {
    public King(boolean isWeight) {
        super("King", isWeight);
    }

    public boolean isValidMove(Position start, Position end, boolean isCapture, Board board)
            throws NotWithinOneSquareException {

        boolean isEndOneSquareFromStart = start.isWithinOneSquareOf(end);
        if(!isEndOneSquareFromStart) throw new NotWithinOneSquareException();

        return true;
    }

    @Override
    public String toString() {
        return isWeight() ? "♔" : "♚";
    }
}
