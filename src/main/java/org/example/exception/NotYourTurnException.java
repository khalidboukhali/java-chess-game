package org.example.exception;

public class NotYourTurnException extends Exception {

    public NotYourTurnException() {
        super("It's not your turn to make a move.");
    }

}

