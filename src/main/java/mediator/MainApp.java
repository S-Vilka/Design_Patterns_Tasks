package mediator;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        ChatMediator chatRoom = new ChatRoom();

        new ChatClientController("Alex", chatRoom);
        new ChatClientController("Max", chatRoom);
        new ChatClientController("Sergei", chatRoom);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//mvn javafx:run