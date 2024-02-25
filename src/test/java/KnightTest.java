import org.example.board.ChessBoard;
import org.example.board.Position;
import org.example.exception.InvalidMoveException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
    private final ChessBoard chessBoard = new ChessBoard();

    @Test
    void shouldJump(){
        chessBoard.initialConditions();

        Position start = new Position(1,0);
        Position end = new Position(2,2);

        try {
            chessBoard.play(start, end, false);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertNull(chessBoard.getPiece(start));
        assertTrue(chessBoard.getPiece(end).isWeight());
        assertEquals("Knight", chessBoard.getPiece(end).getName());
    }

    @Test
    void shouldCapture(){
        chessBoard.initialConditions();

        Position start = new Position(1,0);
        Position end1 = new Position(2,2);
        Position end2 = new Position(1,4);
        Position capturedPiecePosition = new Position(2,6);

        try {
            chessBoard.play(start, end1, false);
            chessBoard.play(end1, end2, false);
            chessBoard.play(end2, capturedPiecePosition, false);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertNull(chessBoard.getPiece(start));
        assertNull(chessBoard.getPiece(end1));
        assertNull(chessBoard.getPiece(end2));
        assertTrue(chessBoard.getPiece(capturedPiecePosition).isWeight());
        assertEquals("Knight", chessBoard.getPiece(capturedPiecePosition).getName());
    }

    /**
     * Verifies that the knight cannot make moves that do not adhere to the L-shape rule.
     */
    @Test
    void shouldNotMove(){
        chessBoard.initialConditions();

        Position start = new Position(1,0);
        Position end = new Position(2,3);

        assertThrows(InvalidMoveException.class, () -> chessBoard.play(start, end, false));
    }
}
