package org.example.board;

public abstract class Piece implements IPiece{

    private final boolean isWhite;
    private final String name;
    protected int x;
    protected int y;

    public Piece(String name, int x, int y, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.isWhite = isWhite;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public String getName() {
        return name;
    }

    public static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < Constants.BOARD_SIZE && y >= 0 && y < Constants.BOARD_SIZE;
    }
    public static boolean isValidPosition(int[] position) {
        return position[0] >= 0 && position[0] < Constants.BOARD_SIZE
                && position[1] >= 0 && position[1] < Constants.BOARD_SIZE;
    }

}
