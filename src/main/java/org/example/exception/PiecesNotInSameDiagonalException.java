package org.example.exception;

public class PiecesNotInSameDiagonalException extends Exception {

    public PiecesNotInSameDiagonalException() {
        super("The two pieces are not in the same diagonal.");
    }

}

