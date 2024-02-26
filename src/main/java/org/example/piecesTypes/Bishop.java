package org.example.piecesTypes;

import org.example.board.Movement;
import org.example.board.Piece;

import java.util.List;

/**
 * Moves diagonally any number of squares.
 */
public class Bishop extends Piece {

    public Bishop(int x, int y, boolean isWhite){
        super("Bishop", x, y, isWhite);
    }

    @Override
    public List<int[]> getAllPossiblePositionsToMove() {
        return Movement.getAllDiagonalMovements(x,y,isWhite());
    }

    @Override
    public List<int[]> getAllPossiblePositionsToAttack() {
        return getAllPossiblePositionsToMove();
    }
}