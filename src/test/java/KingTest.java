import org.example.board.ChessBoard;
import org.example.board.Piece;
import org.example.exception.PositionOutOfBoundary;
import org.example.exception.PositionOutOfPieceMovement;
import org.example.piecesTypes.King;
import org.example.piecesTypes.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KingTest {
    @Test
    void shouldMove(){
        Piece whiteKing = new King(2,0,true);
        ChessBoard chessBoard = new ChessBoard(whiteKing);

        chessBoard.move(whiteKing, 2, 1);

        assertTrue(chessBoard.isEmpty(2,0));
        assertFalse(chessBoard.isEmpty(2,1));
    }

    @Test
    void shouldCapture(){
        Piece whiteKing = new King(2,0,true);
        Piece capturedPiece = new Rook(2, 1,false);
        ChessBoard chessBoard = new ChessBoard(whiteKing, capturedPiece);

        chessBoard.move(whiteKing, 2, 1);

        assertTrue(chessBoard.isEmpty(2,0));
        assertFalse(chessBoard.isEmpty(2,1));
        assertEquals("King", chessBoard.getPiece(2,1).getName());
    }

    @Test
    void shouldThrowOutOfBoundary(){
        Piece whiteKing = new King(0,1,true);
        ChessBoard chessBoard = new ChessBoard(whiteKing);

        assertThrows(PositionOutOfBoundary.class, () -> chessBoard.move(whiteKing, -1, 3));
    }

    @Test
    void shouldThrowOutOfPieceMovement(){
        Piece whiteKing = new King(0,1,true);
        ChessBoard chessBoard = new ChessBoard(whiteKing);

        assertThrows(PositionOutOfPieceMovement.class, () -> chessBoard.move(whiteKing, 0, 3));
    }

}
