package mediator;

public interface ChatMediator {
    void registerClient(ChatClientController client);
    void sendMessage(String sender, String recipient, String message);
}