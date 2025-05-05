package mediator;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatClientController {
    private String username;
    private ChatMediator mediator;
    private TextArea chatArea;
    private TextField messageField;
    private TextField recipientField;

    public ChatClientController(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.registerClient(this);
        createWindow();
    }

    private void createWindow() {
        Stage stage = new Stage();
        stage.setTitle("Chat - " + username);

        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setPrefHeight(300);

        recipientField = new TextField();
        recipientField.setPromptText("Recipient username");

        messageField = new TextField();
        messageField.setPromptText("Type your message...");

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> {
            String recipient = recipientField.getText().trim();
            String message = messageField.getText().trim();
            if (!recipient.isEmpty() && !message.isEmpty()) {
                mediator.sendMessage(username, recipient, message);
                messageField.clear();
            }
        });

        VBox root = new VBox(10, chatArea, recipientField, messageField, sendButton);
        root.setPadding(new Insets(10));

        stage.setScene(new Scene(root, 400, 400));
        stage.show();
    }

    public String getUsername() {
        return username;
    }

    public void receiveMessage(String sender, String message) {
        chatArea.appendText(sender + ": " + message + "\n");
    }
}