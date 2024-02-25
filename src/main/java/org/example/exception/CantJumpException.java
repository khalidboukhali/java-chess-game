package org.example.exception;

public class CantJumpException extends Exception {

    public CantJumpException() {
        super("This piece can't jump over other pieces.");
    }

}