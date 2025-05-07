package command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditorGUI extends Application {

    public void start(Stage primaryStage) {
        PixelGrid grid = new PixelGrid();
        PixelGridView view = new PixelGridView(grid);

        Command moveUp = new MoveCursorUpCommand(grid);
        Command moveDown = new MoveCursorDownCommand(grid);
        Command moveLeft = new MoveCursorLeftCommand(grid);
        Command moveRight = new MoveCursorRightCommand(grid);
        Command toggle = new TogglePixelCommand(grid);
        Command generateCode = new GenerateCodeCommand(grid);

        view.setFocusTraversable(true);

        view.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP -> moveUp.execute();
                case DOWN -> moveDown.execute();
                case LEFT -> moveLeft.execute();
                case RIGHT -> moveRight.execute();
                case SPACE -> toggle.execute();
            }
            view.draw();
        });

        Button codeButton = new Button("Create Code");
        codeButton.setOnAction(e -> generateCode.execute());

        VBox controls = new VBox(10, codeButton);

        BorderPane root = new BorderPane();
        root.setCenter(view);
        root.setRight(controls);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// mvn clean compile exec:java