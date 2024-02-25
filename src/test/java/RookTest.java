import org.example.board.ChessBoard;
import org.example.board.Position;
import org.example.exception.CantJumpException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RookTest {
    private final ChessBoard chessBoard = new ChessBoard();

    @Test
    void shouldMovesVertically(){
        chessBoard.initialConditions();

        Position startPawn = new Position(0,1);
        Position endPawn = new Position(0,3);

        Position startRook = new Position(0,0);
        Position endRook = new Position(0,2);

        try {
            chessBoard.play(startPawn, endPawn, false);
            chessBoard.play(startRook, endRook, false);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertNull(chessBoard.getPiece(startRook));
        assertNotNull(chessBoard.getPiece(endRook));
    }

    @Test
    void shouldMovesHorizontally(){
        chessBoard.initialConditions();

        Position startPawn = new Position(0,1);
        Position endPawn = new Position(0,3);

        Position startRookVertical = new Position(0,0);
        Position endRookVertical = new Position(0,2);

        Position endRookHorizontal = new Position(7,2);

        try {
            chessBoard.play(startPawn, endPawn, false);
            chessBoard.play(startRookVertical, endRookVertical, false);
            chessBoard.play(endRookVertical, endRookHorizontal, false);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertNull(chessBoard.getPiece(endRookVertical));
        assertNotNull(chessBoard.getPiece(endRookHorizontal));
    }

    @Test
    void shouldNotJump(){
        chessBoard.initialConditions();

        Position start = new Position(0,0);
        Position end = new Position(0,5);

        assertThrows(CantJumpException.class, () -> chessBoard.play(start, end, false));
    }

    @Test
    void shouldCapture(){
        chessBoard.initialConditions();

        Position startPawn = new Position(0,1);
        Position endPawn = new Position(0,3);

        Position startRookVertical = new Position(0,0);
        Position endRookVertical = new Position(0,2);

        Position endRookHorizontal = new Position(7,2);

        Position capturedPiece = new Position(7,6);

        try {
            chessBoard.play(startPawn, endPawn, false);
            chessBoard.play(startRookVertical, endRookVertical, false);
            chessBoard.play(endRookVertical, endRookHorizontal, false);
            chessBoard.play(endRookHorizontal, capturedPiece, false);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertTrue(chessBoard.getPiece(capturedPiece).isWeight());
        assertEquals("Rook", chessBoard.getPiece(capturedPiece).getName());
    }

}

