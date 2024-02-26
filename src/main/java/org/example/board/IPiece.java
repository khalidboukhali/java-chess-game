package org.example.board;

import java.util.List;

public interface IPiece {
    List<int[]> getAllPossiblePositionsToMove();
    List<int[]> getAllPossiblePositionsToAttack();
}
