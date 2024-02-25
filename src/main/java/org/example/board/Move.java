package org.example.board;

import org.example.exception.CantJumpException;
import org.example.exception.PiecesNotInSameDiagonalException;
import org.example.exception.PiecesNotInSameLineException;

public class Move {
    public static boolean isVerticalOrHorizontalMoveAllowed(Position start, Position end, Board board)
            throws CantJumpException, PiecesNotInSameLineException {

        if (start.x() == end.x() || start.y() == end.y()) {
            int minX = Math.min(start.x(), end.x());
            int maxX = Math.max(start.x(), end.x());
            int minY = Math.min(start.y(), end.y());
            int maxY = Math.max(start.y(), end.y());

            // There is something between start and end
            if(minX == maxX){ // Vertical line
                for (int y = minY + 1; y < maxY; y++) {
                    if (!board.isEmpty(new Position(minX, y))) {
                        throw new CantJumpException();
                    }
                }
            }
            if(minY == maxY){ // Horizontal line
                for (int x = minX + 1; x < maxX; x++) {
                    if (!board.isEmpty(new Position(x, minY))) {
                        throw new CantJumpException();
                    }
                }
            }
            // All positions between start and end are empty
            return true;
        }
        // Positions are not on the same line ni Vertical ni Horizontal
        throw new PiecesNotInSameLineException();
    }

    public static boolean isDiagonalMoveAllowed(Position start, Position end, Board board)
            throws CantJumpException, PiecesNotInSameDiagonalException {
        int deltaX = Math.abs(start.x() - end.x());
        int deltaY = Math.abs(start.y() - end.y());

        if (deltaX == deltaY) {
            int minX = Math.min(start.x(), end.x());
            int minY = Math.min(start.y(), end.y());

            for (int i = 1; i < deltaX; i++) {
                int x = minX + i;
                int y = minY + i;

                if (!board.isEmpty(new Position(x, y))) {
                    // There is something between start and end on the diagonal
                     throw new CantJumpException();
                }
            }
            // All positions between start and end are empty on the diagonal
            return true;
        }
        // Positions are not on the same diagonal
        throw new PiecesNotInSameDiagonalException();
    }

    public static boolean moveForwardOneSquare(Position start, Position end, Board board) {
        Piece startPiece = board.getPiece(start);

        boolean sameColumn = start.x() == end.x();
        boolean oneSquareForward = startPiece.isWeight() ? (end.y() - 1 == start.y()) : (end.y() + 1 == start.y());

        return sameColumn && oneSquareForward;
    }

    public static boolean moveForwardTwoSquare(Position start, Position end, Board board) {
        Piece startPiece = board.getPiece(start);

        boolean sameColumn = start.x() == end.x();
        boolean twoSquareForward = startPiece.isWeight() ? (end.y() - 2 == start.y()) : (end.y() + 2 == start.y());
        boolean forwardFirstTime = startPiece.isWeight() ? (start.y() == 1) : (start.y() == 6);

        return sameColumn && twoSquareForward && forwardFirstTime;
    }

    public static boolean moveDiagonalOneSquareToCapture(Position start, Position end){
        int deltaX = Math.abs(start.x() - end.x());
        int deltaY = Math.abs(start.y() - end.y());

        return (deltaX == deltaY);
    }

}