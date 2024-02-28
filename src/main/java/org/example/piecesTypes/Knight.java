package org.example.piecesTypes;

import org.example.board.Piece;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Moves in an "L-shape": two squares in one direction and one square perpendicular.
 */
public class Knight extends Piece {

    private static final int[] DX = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] DY = {-1, -2, -2, -1, 1, 2, 2, 1};
    public Knight(int x, int y, boolean isWhite) {
        super("Knight", x, y, isWhite);
    }

    @Override
    public List<int[]> getAllPossiblePositionsToMove() {
        return IntStream.range(0, DX.length)
                .mapToObj(i -> new int[]{x + DX[i], y + DY[i]})
                .filter(position -> isValidPosition(position))
                .collect(Collectors.toList());
    }

    @Override
    public List<int[]> getAllPossiblePositionsToAttack() {
        return getAllPossiblePositionsToMove();
    }

}
