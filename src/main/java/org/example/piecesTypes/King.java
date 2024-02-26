package org.example.piecesTypes;

import org.example.board.Piece;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * moves one square at a time
 */
public class King extends Piece {
    private static final int[] DX = {-1, 0, +1, +1, 1, 0, -1, -1};
    private static final int[] DY = {-1, -1, -1, 0, 1, +1, +1, 0};
    public King(int x, int y, boolean isWhite) {
        super("King", x, y, isWhite);
    }

    @Override
    public List<int[]> getAllPossiblePositionsToMove() {
        return IntStream.range(0,DX.length)
                .mapToObj(i -> {
                    int[] position = {x + DX[i], y + DY[i]};
                    return position;
                }).filter(position -> isValidPosition(position))
                .collect(Collectors.toList());
    }

    @Override
    public List<int[]> getAllPossiblePositionsToAttack() {
        return getAllPossiblePositionsToMove();
    }
}
