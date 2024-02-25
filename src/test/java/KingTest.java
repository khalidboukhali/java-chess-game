import org.example.board.ChessBoard;
import org.example.board.Position;
import org.example.exception.InvalidMoveException;
import org.example.exception.NotWithinOneSquareException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KingTest {
    private final ChessBoard chessBoard = new ChessBoard();

    @Test
    void shouldNotJump(){
        chessBoard.initialConditions();

        Position startKing = new Position(4,0);
        Position endKing = new Position(4,1);

        assertThrows(InvalidMoveException.class, () -> chessBoard.play(startKing, endKing, false));
    }

    @Test
    void targetNotWithinOneSquare(){
        chessBoard.initialConditions();

        Position startKing = new Position(4,0);
        Position endKing = new Position(5,2);

        assertThrows(NotWithinOneSquareException.class, () -> chessBoard.play(startKing, endKing, false));
    }

}
