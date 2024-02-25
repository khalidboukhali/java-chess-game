package org.example.board;

public class Board{
    protected Piece[][] board;

    public boolean isEmpty(Position position){
        return board[position.x()][position.y()] == null;
    }
    public Piece getPiece(Position position){
        return board[position.x()][position.y()];
    }

    public void setToNull(Position position){
        this.board[position.x()][position.y()] = null;
    }

    public void setPiece(Position position, Piece piece){
        board[position.x()][position.y()] = piece;
    }

}
