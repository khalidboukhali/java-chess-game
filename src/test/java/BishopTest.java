import org.example.board.ChessBoard;
import org.example.board.Position;
import org.example.exception.CantJumpException;
import org.example.exception.PiecesNotInSameDiagonalException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {
    private final ChessBoard chessBoard = new ChessBoard();

    @Test
    void shouldNotJump(){
        chessBoard.initialConditions();

        Position start = new Position(2,0);
        Position end = new Position(4,2);

        assertThrows(CantJumpException.class, () -> chessBoard.play(start, end, false));
    }

    @Test
    void shouldCapture(){
        chessBoard.initialConditions();

        Position startWeightPawn = new Position(3,1);
        Position endWeightPawn = new Position(3,2);

        Position startBlackPawnCaptured = new Position(7,6);
        Position endBlackPawnCaptured = new Position(7,5);

        Position bishopStart = new Position(2,0);

        try {
            chessBoard.play(startWeightPawn, endWeightPawn, false);
            chessBoard.play(startBlackPawnCaptured, endBlackPawnCaptured, true);
            chessBoard.play(bishopStart, endBlackPawnCaptured, false);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertNull(chessBoard.getPiece(bishopStart));
        assertEquals("Bishop", chessBoard.getPiece(endBlackPawnCaptured).getName());
        assertTrue(chessBoard.getPiece(endBlackPawnCaptured).isWeight());
    }

    @Test
    void piecesNotWithinDiagonal(){
        chessBoard.initialConditions();

        Position startPawn = new Position(2,1);
        Position endPawn = new Position(2,3);
        Position bishopStart = new Position(2,0);

        try {
            chessBoard.play(startPawn, endPawn, false);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertThrows(PiecesNotInSameDiagonalException.class, () -> chessBoard.play(bishopStart, startPawn, false));
    }
}
