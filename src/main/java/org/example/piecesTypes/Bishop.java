package org.example.piecesTypes;

import org.example.board.Board;
import org.example.board.Move;
import org.example.board.Piece;
import org.example.board.Position;
import org.example.exception.CantJumpException;
import org.example.exception.PiecesNotInSameDiagonalException;

/**
 * Moves diagonally any number of squares.
 */
public class Bishop extends Piece {
    public Bishop(boolean isWeight) {
        super("Bishop", isWeight);
    }

    public boolean isValidMove(Position start, Position end, boolean isCapture, Board board)
            throws PiecesNotInSameDiagonalException, CantJumpException {

        return Move.isDiagonalMoveAllowed(start, end, board);
    }

    @Override
    public String toString() {
        return isWeight() ? "♗" : "♝";
    }

}