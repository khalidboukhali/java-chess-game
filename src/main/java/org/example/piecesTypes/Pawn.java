package org.example.piecesTypes;

import org.example.board.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Moves forward one square.
 * Optionally moves forward two squares on its first move.
 * Captures diagonally.
 */
public class Pawn extends Piece{

    public Pawn(int x, int y, boolean isWhite){
        super("Pawn", x, y, isWhite);
    }

    @Override
    public List<int[]> getAllPossiblePositionsToMove() {
        List<int[]> allPossiblePositions = new ArrayList<>();
        int forwardDirection = isWhite() ? 1 : -1;
        int initialMoveOffset = isWhite() ? 2 : -2;

        // Move one square forward
        int[] forwardOne = {x, y + forwardDirection};
        if (isValidPosition(forwardOne)) {
            allPossiblePositions.add(forwardOne);
        }

        // Initial move: Move two squares forward
        if ((isWhite() && y == 1) || (!isWhite() && y == 6)) {
            int[] initialMove = {x, y + initialMoveOffset};
            if (isValidPosition(initialMove)) {
                allPossiblePositions.add(initialMove);
            }
        }

        return allPossiblePositions;
    }

    @Override
    public List<int[]> getAllPossiblePositionsToAttack(){
        List<int[]> allPossiblePositions = new ArrayList<>();
        int forwardDirection = isWhite() ? 1 : -1;
        // Diagonal capture positions
        int[] captureLeft = {x - 1, y + forwardDirection};
        int[] captureRight = {x + 1, y + forwardDirection};
        if (isValidPosition(captureLeft)) {
            allPossiblePositions.add(captureLeft);
        }
        if (isValidPosition(captureRight)) {
            allPossiblePositions.add(captureRight);
        }

        return allPossiblePositions;
    }

}
