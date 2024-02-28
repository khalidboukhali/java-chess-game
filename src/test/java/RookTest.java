import org.example.board.ChessBoard;
import org.example.board.Piece;
import org.example.exception.CantJumpException;
import org.example.exception.PositionOutOfBoundary;
import org.example.exception.PositionOutOfPieceMovement;
import org.example.piecesTypes.Pawn;
import org.example.piecesTypes.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RookTest {
    @Test
    void shouldMoveVertically(){
        Piece whiteRook = new Rook(0,0,true);
        ChessBoard chessBoard = new ChessBoard(whiteRook);

        chessBoard.move(whiteRook, 0, 7);

        assertTrue(chessBoard.isEmpty(0,0));
        assertFalse(chessBoard.isEmpty(0,7));
    }

    @Test
    void shouldMoveHorizontally(){
        Piece whiteRook = new Rook(0,0,true);
        ChessBoard chessBoard = new ChessBoard(whiteRook);

        chessBoard.move(whiteRook, 7, 0);

        assertTrue(chessBoard.isEmpty(0,0));
        assertFalse(chessBoard.isEmpty(7,0));
    }

    @Test
    void shouldCaptureVertically(){
        Piece whiteRook = new Rook(0,0,true);
        Piece capturedPiece = new Pawn(0, 5,false);
        ChessBoard chessBoard = new ChessBoard(whiteRook, capturedPiece);

        chessBoard.move(whiteRook, 0, 5);

        assertTrue(chessBoard.isEmpty(0,0));
        assertFalse(chessBoard.isEmpty(0,5));
        assertEquals("Rook", chessBoard.getPiece(0,5).getName());
    }

    @Test
    void shouldCaptureHorizontally(){
        Piece whiteRook = new Rook(0,0,true);
        Piece capturedPiece = new Pawn(6, 0,false);
        ChessBoard chessBoard = new ChessBoard(whiteRook, capturedPiece);

        chessBoard.move(whiteRook, 6, 0);

        assertTrue(chessBoard.isEmpty(0,0));
        assertFalse(chessBoard.isEmpty(6,0));
        assertEquals("Rook", chessBoard.getPiece(6,0).getName());
    }

    @Test
    void shouldThrowOutOfBoundary(){
        Piece whiteRook = new Rook(0,1,true);
        ChessBoard chessBoard = new ChessBoard(whiteRook);

        assertThrows(PositionOutOfBoundary.class, () -> chessBoard.move(whiteRook, 1, 8));
    }

    @Test
    void shouldThrowOutOfPieceMovement(){
        Piece whiteRook = new Rook(0,1,true);
        ChessBoard chessBoard = new ChessBoard(whiteRook);

        assertThrows(PositionOutOfPieceMovement.class, () -> chessBoard.move(whiteRook, 1, 3));
    }

    @Test
    void shouldThrowCantJumpException(){
        Piece whiteRook = new Rook(0,0,true);
        Piece blackPawn = new Pawn(0,4,false);
        ChessBoard chessBoard = new ChessBoard(whiteRook, blackPawn);

        assertThrows(CantJumpException.class, () -> chessBoard.move(whiteRook, 0, 5));
    }
}

