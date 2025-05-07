package command;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PixelGridView extends Canvas {
    private PixelGrid grid;
    private static final int CELL_SIZE = 40;

    public PixelGridView(PixelGrid grid) {
        super(8 * CELL_SIZE, 8 * CELL_SIZE);
        this.grid = grid;
        draw();
    }

    public void draw() {
        GraphicsContext gc = getGraphicsContext2D();

        // Clear background
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, getWidth(), getHeight());

        boolean[][] pixels = grid.getGrid();

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (pixels[y][x]) {
                    // ON pixel — fill with your custom color
                    gc.setFill(Color.DODGERBLUE);
                    gc.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                } else {
                    // OFF pixel — white background with border
                    gc.setFill(Color.WHITE);
                    gc.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    gc.setStroke(Color.LIGHTGRAY);
                    gc.strokeRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }

        // Draw the red cursor
        gc.setStroke(Color.RED);
        gc.setLineWidth(2);
        gc.strokeRect(
                grid.getCursorX() * CELL_SIZE,
                grid.getCursorY() * CELL_SIZE,
                CELL_SIZE, CELL_SIZE
        );
    }
}