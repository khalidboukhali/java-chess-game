package org.example.exception;

public class PositionOutOfPieceMovement extends IllegalArgumentException{
    public PositionOutOfPieceMovement() {
        super("Invalid position for piece movement");
    }
}
