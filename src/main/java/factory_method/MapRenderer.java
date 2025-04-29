package factory_method;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MapRenderer {

    public static void render(GraphicsContext gc, Map map, int tileSize) {
        for (int row = 0; row < map.getRows(); row++) {
            for (int col = 0; col < map.getCols(); col++) {
                Tile tile = map.getTileAt(row, col);
                if (tile != null) {
                    Image img = TileGraphicFactory.getTileGraphic(tile.getType());
                    gc.drawImage(img, col * tileSize, row * tileSize, tileSize, tileSize);
                }
            }
        }
    }
}