import org.example.board.ChessBoard;
import org.example.board.Position;
import org.example.exception.CantJumpException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {

    private final ChessBoard chessBoard = new ChessBoard();

    @Test
    void shouldNotJump(){
        chessBoard.initialConditions();

        Position startQueen = new Position(3,0);
        Position endQueenDiagonal = new Position(7,4);

        // moves diagonal
        assertThrows(CantJumpException.class, () -> chessBoard.play(startQueen, endQueenDiagonal, false));
    }

    @Test
    void shouldCapture(){
        chessBoard.initialConditions();

        Position startWeightPawn = new Position(4,1);
        Position endWeightPawn = new Position(4,2);

        Position startBlackPawnCaptured = new Position(7,6);
        Position endBlackPawnCaptured = new Position(7,4);

        Position QueenStart = new Position(3,0);

        try {
            chessBoard.play(startWeightPawn, endWeightPawn, false);
            chessBoard.play(startBlackPawnCaptured, endBlackPawnCaptured, true);
            chessBoard.play(QueenStart, endBlackPawnCaptured, false);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertNull(chessBoard.getPiece(QueenStart));
        assertEquals("Queen", chessBoard.getPiece(endBlackPawnCaptured).getName());
        assertTrue(chessBoard.getPiece(endBlackPawnCaptured).isWeight());
    }
}
