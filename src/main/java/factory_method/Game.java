package factory_method;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {

    @Override
    public void start(Stage primaryStage) {
        Map map = createMap("1");
        map.generateMap();

        int tileSize = 64;
        Canvas canvas = new Canvas(map.getCols() * tileSize, map.getRows() * tileSize);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        MapRenderer.render(gc, map, tileSize);

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("RPG Map");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Map createMap(String type) {
        switch (type) {
            case "1":
                return new CityMap();
            case "2":
                return new WildernessMap();
            default:
                return null;
        }
    }
}