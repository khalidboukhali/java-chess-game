package org.example.board;

import org.example.exception.*;

public abstract class Piece {
    private final boolean isWeight;
    private final String name;

    public Piece(String name, boolean isWeight) {
        this.name = name;
        this.isWeight = isWeight;
    }

    public boolean isWeight() {
        return isWeight;
    }

    public String getName() {
        return name;
    }

    protected abstract boolean isValidMove(Position start, Position end, boolean isCapture, Board board)
            throws PiecesNotInSameLineException, PiecesNotInSameDiagonalException,
            NotWithinOneSquareException, CantJumpException, InvalidMoveException;

    abstract public String toString();
}
