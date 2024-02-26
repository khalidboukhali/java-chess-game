package org.example.exception;

public class PositionOutOfBoundary extends IllegalArgumentException{
    public PositionOutOfBoundary() {
        super("Position is out of bounds.");
    }
}
