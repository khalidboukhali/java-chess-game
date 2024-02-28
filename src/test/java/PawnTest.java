import org.example.board.ChessBoard;
import org.example.board.Piece;
import org.example.exception.CantJumpException;
import org.example.exception.PositionOutOfBoundary;
import org.example.exception.PositionOutOfPieceMovement;
import org.example.piecesTypes.Pawn;
import org.example.piecesTypes.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {
    @Test
    void shouldMoveOneSquareForward(){
        Piece whitePawn = new Pawn(0,1,true);
        ChessBoard chessBoard = new ChessBoard(whitePawn);

        chessBoard.move(whitePawn, 0, 2);

        assertTrue(chessBoard.isEmpty(0,1));
        assertFalse(chessBoard.isEmpty(0,2));
    }

    @Test
    void shouldMoveTwoSquareForward(){
        Piece whitePawn = new Pawn(0,1,true);
        ChessBoard chessBoard = new ChessBoard(whitePawn);

        chessBoard.move(whitePawn, 0, 3);

        assertTrue(chessBoard.isEmpty(0,1));
        assertFalse(chessBoard.isEmpty(0,3));
    }

    @Test
    void shouldCapture(){
        Piece whitePawn = new Pawn(0,1,true);
        Piece capturedPiece = new Rook(1, 2,false);
        ChessBoard chessBoard = new ChessBoard(whitePawn, capturedPiece);

        chessBoard.move(whitePawn, 1, 2);

        assertTrue(chessBoard.isEmpty(0,1));
        assertFalse(chessBoard.isEmpty(1,2));
        assertEquals("Pawn", chessBoard.getPiece(1,2).getName());
    }

    @Test
    void shouldThrowOutOfBoundary(){
        Piece whitePawn = new Pawn(0,1,true);
        ChessBoard chessBoard = new ChessBoard(whitePawn);

        assertThrows(PositionOutOfBoundary.class, () -> chessBoard.move(whitePawn, -1, 3));
    }

    @Test
    void shouldThrowOutOfPieceMovement(){
        Piece whitePawn = new Pawn(0,1,true);
        ChessBoard chessBoard = new ChessBoard(whitePawn);

        assertThrows(PositionOutOfPieceMovement.class, () -> chessBoard.move(whitePawn, 1, 3));
    }

    @Test
    void shouldThrowCantJumpException(){
        Piece whitePawn = new Pawn(0,1,true);
        Piece blackPawn = new Pawn(0,2,true);
        ChessBoard chessBoard = new ChessBoard(whitePawn, blackPawn);

        assertThrows(CantJumpException.class, () -> chessBoard.move(whitePawn, 0, 3));
    }
}
