package org.example.board;

public record Position(int x, int y) {
    public boolean isValidPosition(){
        return (this.x >= 0 && this.x <= 7) && (this.y >= 0 && this.y <= 7);
    }

    public Position move(int dx, int dy) {
        return new Position(x + dx, y + dy);
    }

    public boolean isWithinOneSquareOf(Position other) {
        int deltaX = Math.abs(this.x - other.x);
        int deltaY = Math.abs(this.y - other.y);

        return deltaX <= 1 && deltaY <= 1;
    }

}
