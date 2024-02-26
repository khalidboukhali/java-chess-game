package org.example;

import org.example.board.ChessBoard;
import org.example.board.Piece;
import org.example.piecesTypes.Pawn;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!"+ "♟️");

        Piece whitePawn = new Pawn(0,0,true);
        ChessBoard chessBoard = new ChessBoard(whitePawn);

        chessBoard.move(whitePawn, 7, 0);
    }
}