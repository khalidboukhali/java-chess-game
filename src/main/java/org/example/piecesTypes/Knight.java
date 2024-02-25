package org.example.piecesTypes;

import org.example.board.Board;
import org.example.board.Piece;
import org.example.board.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Moves in an "L-shape": two squares in one direction and one square perpendicular.
 */
public class Knight extends Piece {

    private static final int[] DX = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] DY = {-1, -2, -2, -1, 1, 2, 2, 1};
    public Knight(boolean isWeight) {
        super("Knight", isWeight);
    }

    public boolean isValidMove(Position start, Position end, boolean isCapture, Board board){
        List<Position> validPositionToMove = getAllPossibleMovements(start);
        return validPositionToMove.stream().anyMatch(position -> position.equals(end));
    }

    private List<Position> getAllPossibleMovements(Position position) {
        return IntStream.range(0, DX.length)
                .mapToObj(i -> position.move(DX[i], DY[i]))
                .filter(Position::isValidPosition)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return isWeight() ? "♘" : "♞";
    }
}
