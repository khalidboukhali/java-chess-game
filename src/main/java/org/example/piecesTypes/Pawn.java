package org.example.piecesTypes;

import org.example.board.Board;
import org.example.board.Move;
import org.example.board.Piece;
import org.example.board.Position;

/**
 * Moves forward one square.
 * Optionally moves forward two squares on its first move.
 * Captures diagonally.
 */
public class Pawn extends Piece {
    public Pawn(boolean isWeight){
        super("Pawn", isWeight);
    }

    public boolean isValidMove(Position start, Position end, boolean isCapture, Board board){

        return Move.moveForwardOneSquare(start, end, board) || Move.moveForwardTwoSquare(start, end, board)
                || Move.moveDiagonalOneSquareToCapture(start, end);
    }

    @Override
    public String toString() {
        return isWeight() ? "♙" : "♟";
    }
}
