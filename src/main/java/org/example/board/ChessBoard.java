package org.example.board;

import org.example.exception.CantJumpException;
import org.example.exception.PositionOutOfBoundary;
import org.example.exception.PositionOutOfPieceMovement;
import org.example.piecesTypes.Knight;

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

    public void move(Piece start, int targetX, int targetY) {
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
        else if(!isPathEmpty(start.x, start.y, targetX, targetY))
            throw new CantJumpException();
        else {
            board[start.x][start.y] = null;
            start.setX(targetX);
            start.setY(targetY);
            board[targetX][targetY] = start;
        }
    }

    public boolean isPathEmpty(int startX, int startY, int targetX, int targetY) {

        // make Knight out of this logic
        if(board[startX][startY] instanceof Knight) return true;

        int deltaRow = targetX - startX;
        int deltaCol = targetY - startY;

        if (deltaRow == 0) {
            int step = deltaCol > 0 ? 1 : -1;
            for (int col = startY + step; col != targetY; col += step) {
                if (!isEmpty(startX,col)) {
                    return false;
                }
            }
        } else if (deltaCol == 0) {
            int step = deltaRow > 0 ? 1 : -1;
            for (int row = startX + step; row != targetX; row += step) {
                if (!isEmpty(row,startY)) {
                    return false;
                }
            }
        } else if (Math.abs(deltaRow) == Math.abs(deltaCol)) {
            int stepRow = deltaRow > 0 ? 1 : -1;
            int stepCol = deltaCol > 0 ? 1 : -1;
            for (int row = startX + stepRow, col = startY + stepCol; row != targetX; row += stepRow, col += stepCol) {
                if (!isEmpty(row,col)) {
                    return false;
                }
            }
        } else {
            // Invalid movement (not horizontal, vertical, or diagonal)
            return false;
        }

        return true;
    }

}
