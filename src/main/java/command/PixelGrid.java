package command;

public class PixelGrid {
    private boolean[][] grid = new boolean[8][8];
    private int cursorX = 0;
    private int cursorY = 0;

    public void moveUp() {
        if (cursorY > 0) cursorY--;
    }

    public void moveDown() {
        if (cursorY < 7) cursorY++;
    }

    public void moveLeft() {
        if (cursorX > 0) cursorX--;
    }

    public void moveRight() {
        if (cursorX < 7) cursorX++;
    }

    public void togglePixel() {
        grid[cursorY][cursorX] = !grid[cursorY][cursorX];
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public int getCursorX() {
        return cursorX;
    }

    public int getCursorY() {
        return cursorY;
    }
}