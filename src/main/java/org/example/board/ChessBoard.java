package org.example.board;

import org.example.exception.PositionOutOfBoundary;
import org.example.exception.PositionOutOfPieceMovement;

import static org.example.board.Constants.BOARD_SIZE;

public class ChessBoard {

    protected Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];

    public ChessBoard(Piece ...pieces) {
        for (Piece piece: pieces) {
            board[piece.x][piece.y] = piece;
        }
    }

    public boolean isEmpty(int x, int y){
        return board[x][y] == null;
    }

    public Piece getPiece(int x, int y){
        return board[x][y];
    }

    public void move(Piece start, int targetX, int targetY){
        if(!Piece.isValidPosition(targetX,targetY))
            throw  new PositionOutOfBoundary();
        boolean isValidMove ;
        if(!isEmpty(targetX,targetY)){
            isValidMove = start.getAllPossiblePositionsToAttack().stream()
                    .anyMatch(position -> position[0] == targetX && position[1] == targetY);
        }else {
            isValidMove = start.getAllPossiblePositionsToMove().stream()
                    .anyMatch(position -> position[0] == targetX && position[1] == targetY);
        }
        if(!isValidMove)
            throw new PositionOutOfPieceMovement();
        else {
            board[start.x][start.y] = null;
            start.setX(targetX);
            start.setY(targetY);
            board[targetX][targetY] = start;
        }
    }

}
