package mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatRoom implements ChatMediator {
    private Map<String, ChatClientController> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClientController client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String sender, String recipient, String message) {
        ChatClientController receiver = clients.get(recipient);
        if (receiver != null) {
            receiver.receiveMessage(sender, message);
        } else {
            ChatClientController senderClient = clients.get(sender);
            if (senderClient != null) {
                senderClient.receiveMessage("System", "User '" + recipient + "' not found.");
            }
        }
    }
}