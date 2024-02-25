package org.example.board;

import org.example.exception.*;
import org.example.piecesTypes.*;

public class ChessBoard extends Board {
    public ChessBoard() {
        board = new Piece[8][8];
    }

    /**
     * Initializes the player pieces on the chessboard.
     * The first two lines set up pieces for the white player,
     * while the last two lines set up pieces for the black player.
     */
    public void initialConditions() {
        int boardSize = 8;

        Pawn weightPawn = new Pawn(true);
        Pawn blackPawn = new Pawn(false);

        for (int x = 0; x < boardSize; x++) {
            board[x][1] = weightPawn;
            board[x][6] = blackPawn;
        }

        Rook weightRook = new Rook(true);
        Rook blackRook = new Rook(false);
        board[0][0] = weightRook;
        board[7][0] = weightRook;
        board[0][7] = blackRook;
        board[7][7] = blackRook;

        Knight weightKnight = new Knight(true);
        Knight blackKnight = new Knight(false);
        board[1][0] = weightKnight;
        board[6][0] = weightKnight;
        board[1][7] = blackKnight;
        board[6][7] = blackKnight;

        Bishop weightBishop = new Bishop(true);
        Bishop blackBishop = new Bishop(false);
        board[2][0] = weightBishop;
        board[5][0] = weightBishop;
        board[2][7] = blackBishop;
        board[5][7] = blackBishop;

        King weightKing = new King(true);
        King blackKing = new King(false);
        board[4][0] = weightKing;
        board[4][7] = blackKing;

        Queen weightQueen = new Queen(true);
        Queen blackQueen = new Queen(false);
        board[3][0] = weightQueen;
        board[3][7] = blackQueen;
    }

    public void play(Position start, Position end, boolean isBlackTour)
            throws NotYourTurnException, PiecesNotInSameLineException, NotWithinOneSquareException, InvalidMoveException,
            PiecesNotInSameDiagonalException, CantJumpException {

        if(isSamePlayerPieces(start, end, this))
            throw new InvalidMoveException("The move from " + start + " to " + end + " is not valid.");

        if(!checkIsPlayerTour(start, isBlackTour))
            throw new NotYourTurnException();

        Piece startPiece = super.getPiece(start);
        boolean isValidMove = startPiece.isValidMove(start, end, !isEmpty(end), this);
        if(isValidMove){
            super.setToNull(start);
            super.setPiece(end, startPiece);
        } else {
            throw new InvalidMoveException("The move from " + start + " to " + end + " is not valid.");
        }
    }

    private boolean isSamePlayerPieces(Position start, Position end, Board board){
        Piece startPiece = board.getPiece(start);
        Piece endPiece = board.getPiece(end);

        return startPiece != null && endPiece != null && startPiece.isWeight() == endPiece.isWeight();
    }

    private boolean checkIsPlayerTour(Position start, boolean isBlackTour){
        Piece startPiece = board[start.x()][start.y()];
        return ((!startPiece.isWeight() && isBlackTour) || (startPiece.isWeight() && !isBlackTour));
    }

}
