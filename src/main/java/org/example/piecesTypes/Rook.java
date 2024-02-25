package org.example.piecesTypes;

import org.example.board.Board;
import org.example.board.Move;
import org.example.board.Piece;
import org.example.board.Position;
import org.example.exception.CantJumpException;
import org.example.exception.PiecesNotInSameLineException;

/**
 * Moves vertically or horizontally any number of squares.
 */
public class Rook extends Piece {
    public Rook(boolean isWeight) {
        super("Rook", isWeight);
    }

    public boolean isValidMove(Position start, Position end, boolean isCapture, Board board)
            throws PiecesNotInSameLineException, CantJumpException {

        boolean verticalOrHorizontalMoveAllowed = Move.isVerticalOrHorizontalMoveAllowed(start,end,board);
        if(!verticalOrHorizontalMoveAllowed) throw new PiecesNotInSameLineException();

        return true;
    }

    @Override
    public String toString() {
        return isWeight() ? "♖" : "♜";
    }


}
