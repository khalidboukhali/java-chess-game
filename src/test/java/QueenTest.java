import org.example.board.ChessBoard;
import org.example.board.Piece;
import org.example.exception.CantJumpException;
import org.example.exception.PositionOutOfBoundary;
import org.example.exception.PositionOutOfPieceMovement;
import org.example.piecesTypes.King;
import org.example.piecesTypes.Pawn;
import org.example.piecesTypes.Queen;
import org.example.piecesTypes.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueenTest {
    @Test
    void shouldMoveVertically(){
        Piece whiteQueen = new Queen(0,0,true);
        ChessBoard chessBoard = new ChessBoard(whiteQueen);

        chessBoard.move(whiteQueen, 0, 7);

        assertTrue(chessBoard.isEmpty(0,0));
        assertFalse(chessBoard.isEmpty(0,7));
    }

    @Test
    void shouldMoveHorizontally(){
        Piece whiteQueen = new Queen(0,0,true);
        ChessBoard chessBoard = new ChessBoard(whiteQueen);

        chessBoard.move(whiteQueen, 7, 0);

        assertTrue(chessBoard.isEmpty(0,0));
        assertFalse(chessBoard.isEmpty(7,0));
    }

    @Test
    void shouldMoveDiagonally(){
        Piece whiteQueen = new Queen(2,0,true);
        ChessBoard chessBoard = new ChessBoard(whiteQueen);

        chessBoard.move(whiteQueen, 4, 2);

        assertTrue(chessBoard.isEmpty(2,0));
        assertFalse(chessBoard.isEmpty(4,2));
    }

    @Test
    void shouldCaptureDiagonally(){
        Piece whiteQueen = new Queen(2,0,true);
        Piece capturedPiece = new Rook(4, 2,false);
        ChessBoard chessBoard = new ChessBoard(whiteQueen, capturedPiece);

        chessBoard.move(whiteQueen, 4, 2);

        assertTrue(chessBoard.isEmpty(2,0));
        assertFalse(chessBoard.isEmpty(4,2));
        assertEquals("Queen", chessBoard.getPiece(4,2).getName());
    }

    @Test
    void shouldCaptureVertically(){
        Piece whiteQueen = new Queen(0,0,true);
        Piece capturedPiece = new Pawn(0, 5,false);
        ChessBoard chessBoard = new ChessBoard(whiteQueen, capturedPiece);

        chessBoard.move(whiteQueen, 0, 5);

        assertTrue(chessBoard.isEmpty(0,0));
        assertFalse(chessBoard.isEmpty(0,5));
        assertEquals("Queen", chessBoard.getPiece(0,5).getName());
    }

    @Test
    void shouldCaptureHorizontally(){
        Piece whiteQueen = new Queen(0,0,true);
        Piece capturedPiece = new Pawn(6, 0,false);
        ChessBoard chessBoard = new ChessBoard(whiteQueen, capturedPiece);

        chessBoard.move(whiteQueen, 6, 0);

        assertTrue(chessBoard.isEmpty(0,0));
        assertFalse(chessBoard.isEmpty(6,0));
        assertEquals("Queen", chessBoard.getPiece(6,0).getName());
    }

    @Test
    void shouldThrowOutOfBoundary(){
        Piece whiteQueen = new Queen(0,1,true);
        ChessBoard chessBoard = new ChessBoard(whiteQueen);

        assertThrows(PositionOutOfBoundary.class, () -> chessBoard.move(whiteQueen, -1, 3));
    }

    @Test
    void shouldThrowOutOfPieceMovement(){
        Piece whiteQueen = new Queen(0,1,true);
        ChessBoard chessBoard = new ChessBoard(whiteQueen);

        assertThrows(PositionOutOfPieceMovement.class, () -> chessBoard.move(whiteQueen, 1, 3));
    }

    @Test
    void shouldThrowCantJumpException(){
        Piece whiteQueen = new Queen(3,0,true);
        Piece whiteKing = new King(4,0,true);
        Piece whitePawn1 = new Pawn(3,1,true);
        Piece whitePawn2 = new Pawn(4,1,true);
        ChessBoard chessBoard = new ChessBoard(whiteQueen, whiteKing, whitePawn1, whitePawn2);

        assertThrows(CantJumpException.class, () -> chessBoard.move(whiteQueen, 5, 0));
        assertThrows(CantJumpException.class, () -> chessBoard.move(whiteQueen, 3, 2));
        assertThrows(CantJumpException.class, () -> chessBoard.move(whiteQueen, 5, 2));
    }
}
