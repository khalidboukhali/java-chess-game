import org.example.board.ChessBoard;
import org.example.board.Piece;
import org.example.exception.PositionOutOfBoundary;
import org.example.exception.PositionOutOfPieceMovement;
import org.example.piecesTypes.Bishop;
import org.example.piecesTypes.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BishopTest {
    @Test
    void shouldMove(){
        Piece whiteBishop = new Bishop(2,0,true);
        ChessBoard chessBoard = new ChessBoard(whiteBishop);

        chessBoard.move(whiteBishop, 4, 2);

        assertTrue(chessBoard.isEmpty(2,0));
        assertFalse(chessBoard.isEmpty(4,2));
    }

    @Test
    void shouldCapture(){
        Piece whiteBishop = new Bishop(2,0,true);
        Piece capturedPiece = new Rook(4, 2,false);
        ChessBoard chessBoard = new ChessBoard(whiteBishop, capturedPiece);

        chessBoard.move(whiteBishop, 4, 2);

        assertTrue(chessBoard.isEmpty(2,0));
        assertFalse(chessBoard.isEmpty(4,2));
        assertEquals("Bishop", chessBoard.getPiece(4,2).getName());
    }

    @Test
    void shouldThrowOutOfBoundary(){
        Piece whiteBishop = new Bishop(0,1,true);
        ChessBoard chessBoard = new ChessBoard(whiteBishop);

        assertThrows(PositionOutOfBoundary.class, () -> chessBoard.move(whiteBishop, -1, 3));
    }

    @Test
    void shouldThrowOutOfPieceMovement(){
        Piece whiteBishop = new Bishop(0,1,true);
        ChessBoard chessBoard = new ChessBoard(whiteBishop);

        assertThrows(PositionOutOfPieceMovement.class, () -> chessBoard.move(whiteBishop, 1, 3));
    }
}
