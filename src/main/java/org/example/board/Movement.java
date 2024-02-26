package org.example.board;

import java.util.ArrayList;
import java.util.List;

import static org.example.board.Constants.BOARD_SIZE;
import static org.example.board.Piece.isValidPosition;

public class Movement {
    public static List<int[]> getAllVerticalAndHorizontalMovements(int x, int y){
        List<int[]> allPossiblePositionsToMoveTo = new ArrayList<>();
        // horizontal positions
        for (int i = x+1; i < BOARD_SIZE; i++) {
            int[] horizontalPosition = {i,y};
            allPossiblePositionsToMoveTo.add(horizontalPosition);
        }
        // vertical positions
        for (int i = y+1; i < BOARD_SIZE; i++) {
            int[] verticalPosition = {x,i};
            allPossiblePositionsToMoveTo.add(verticalPosition);
        }
        return allPossiblePositionsToMoveTo;
    }

    public static List<int[]> getAllDiagonalMovements(int x, int y, boolean isWhite){
        List<int[]> allPossiblePositionsToMoveTo = new ArrayList<>();
        int[] whiteLeftDiag = {-1, 1};
        int[] whiteRightDiag = {1, 1};
        int[] blackLeftDiag = {-1, -1};
        int[] blackRightDiag = {1, -1};

        int[] leftDiag = isWhite ? whiteLeftDiag : blackLeftDiag;
        int[] rightDiag = isWhite ? whiteRightDiag : blackRightDiag;


        for (int i = 1; i < BOARD_SIZE; i++) {
            // Left diagonal positions
            int newLeftX = x + (leftDiag[0]*i);
            int newLeftY = y + (leftDiag[1]*i);
            // Right diagonal positions
            int newRightX = x + (rightDiag[0]*i);
            int newRightY = y + (rightDiag[1]*i);

            if (isValidPosition(newLeftX, newLeftY)) {
                int[] diagPosition = {newLeftX, newLeftY};
                allPossiblePositionsToMoveTo.add(diagPosition);
            }

            if (isValidPosition(newRightX, newRightY)) {
                int[] diagPosition = {newRightX, newRightY};
                allPossiblePositionsToMoveTo.add(diagPosition);
            }
        }

        return allPossiblePositionsToMoveTo;
    }
}
