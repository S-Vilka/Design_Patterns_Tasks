package factory_method;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.image.PixelWriter;

import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {

    private static final Map<String, Image> graphics = new HashMap<>();
    private static final int TILE_SIZE = 64;

    public static Image getTileGraphic(String tileType) {
        if (!graphics.containsKey(tileType)) {
            graphics.put(tileType, createImageForType(tileType));
        }
        return graphics.get(tileType);
    }

    private static Image createImageForType(String tileType) {
        WritableImage img = new WritableImage(TILE_SIZE, TILE_SIZE);
        PixelWriter pw = img.getPixelWriter();
        Color color;

        switch (tileType) {
            case "forest": color = Color.GREEN; break;
            case "road": color = Color.GRAY; break;
            case "building": color = Color.BROWN; break;
            case "swamp": color = Color.DARKOLIVEGREEN; break;
            case "water": color = Color.BLUE; break;
            default: color = Color.BLACK; break;
        }

        for (int y = 0; y < TILE_SIZE; y++) {
            for (int x = 0; x < TILE_SIZE; x++) {
                pw.setColor(x, y, color);
            }
        }

        return img;
    }
}