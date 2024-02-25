import org.example.board.ChessBoard;
import org.example.board.Position;
import org.example.exception.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PawnTest {
    private final ChessBoard chessBoard = new ChessBoard();

    @Test
    void shouldMovesForwardOneSquare(){
        chessBoard.initialConditions();

        Position start = new Position(0,1);
        Position end = new Position(0,2);

        try {
            chessBoard.play(start, end, false);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertNull(chessBoard.getPiece(start));
        assertNotNull(chessBoard.getPiece(end));
    }

    @Test
    void shouldMovesForwardTwoSquareFirstTime(){
        chessBoard.initialConditions();

        Position start = new Position(0,1);
        Position end = new Position(0,3);

        try {
            chessBoard.play(start, end, false);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertNull(chessBoard.getPiece(start));
        assertNotNull(chessBoard.getPiece(end));
    }

    @Test
    void shouldNotMovesForwardTwoSquare(){
        chessBoard.initialConditions();

        Position start1 = new Position(0,1);
        Position end1 = new Position(0,2);

        try {
            chessBoard.play(start1, end1, false); // first move
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        Position start2 = new Position(0,2);
        Position end2 = new Position(0,4);

        assertThrows(InvalidMoveException.class, () -> {
            chessBoard.play(start2, end2, false); // second move
        });
    }

    @Test
    void shouldNotMovesBack(){
        chessBoard.initialConditions();

        Position start = new Position(0,1);
        Position end = new Position(0,0);

        assertThrows(InvalidMoveException.class, () -> chessBoard.play(start, end, false));
    }

    @Test
    void shouldCapturesDiagonallyPiece(){
        chessBoard.initialConditions();

        Position start = new Position(0,1);
        Position end = new Position(0,3);

        Position capturedStart = new Position(1,6);
        Position capturedEnd = new Position(1,4);

        try {
            chessBoard.play(start, end, false);
            chessBoard.play(capturedStart, capturedEnd, true);
            chessBoard.play(end, capturedEnd, false);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertTrue(chessBoard.getPiece(capturedEnd).isWeight());
        assertEquals("Pawn", chessBoard.getPiece(capturedEnd).getName());
    }
}
