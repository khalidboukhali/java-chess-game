package org.example.piecesTypes;

import org.example.board.Board;
import org.example.board.Move;
import org.example.board.Piece;
import org.example.board.Position;
import org.example.exception.*;

/**
 * Moves vertically, horizontally, or diagonally any number of squares.
 */
public class Queen extends Piece {
    public Queen(boolean isWeight) {
        super("Queen", isWeight);
    }

    public boolean isValidMove(Position start, Position end, boolean isCapture, Board board)
            throws PiecesNotInSameLineException, PiecesNotInSameDiagonalException, CantJumpException{

        return Move.isDiagonalMoveAllowed(start, end, board) ||
                Move.isVerticalOrHorizontalMoveAllowed(start, end, board);

    }

    @Override
    public String toString() {
        return isWeight() ? "♕" : "♛";
    }

}
