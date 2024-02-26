package org.example.piecesTypes;

import org.example.board.Movement;
import org.example.board.Piece;

import java.util.ArrayList;
import java.util.List;

/**
 * Moves vertically, horizontally, or diagonally any number of squares.
 */
public class Queen extends Piece {
    public Queen(int x, int y, boolean isWhite) {
        super("Queen", x, y, isWhite);
    }


    @Override
    public List<int[]> getAllPossiblePositionsToMove() {
        List<int[]> allPossibleLinePositions = Movement.getAllVerticalAndHorizontalMovements(x, y);
        List<int[]> allPossibleDiagonalPositions = Movement.getAllDiagonalMovements(x, y, isWhite());

        // Create a new list to store the combined results
        List<int[]> allPossiblePositions = new ArrayList<>(allPossibleLinePositions);
        allPossiblePositions.addAll(allPossibleDiagonalPositions);

        return allPossiblePositions;
    }


    @Override
    public List<int[]> getAllPossiblePositionsToAttack() {
        return getAllPossiblePositionsToMove();
    }
}
