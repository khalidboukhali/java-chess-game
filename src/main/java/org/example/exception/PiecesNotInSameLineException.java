package org.example.exception;

public class PiecesNotInSameLineException extends Exception{

    public PiecesNotInSameLineException() {
        super("The two pieces are not in the same line (horizontal or vertical).");
    }

}
