package org.example.exception;

public class CantJumpException extends IllegalArgumentException{
    public CantJumpException() {
        super("This piece can't jump over other pieces.");
    }
}
