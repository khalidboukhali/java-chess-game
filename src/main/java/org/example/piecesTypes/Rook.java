package org.example.piecesTypes;

import org.example.board.*;

import java.util.List;

/**
 * Moves vertically or horizontally any number of squares.
 */
public class Rook extends Piece{
    public Rook(int x, int y, boolean isWhite){
        super("Rook", x, y, isWhite);
    }

    @Override
    public List<int[]> getAllPossiblePositionsToMove() {
        return Movement.getAllVerticalAndHorizontalMovements(x,y);
    }

    @Override
    public List<int[]> getAllPossiblePositionsToAttack() {
        return getAllPossiblePositionsToMove();
    }
}
