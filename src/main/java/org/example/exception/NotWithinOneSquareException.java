package org.example.exception;

public class NotWithinOneSquareException extends Exception {

    public NotWithinOneSquareException() {
        super("End position is not within one square of the start position.");
    }

}

