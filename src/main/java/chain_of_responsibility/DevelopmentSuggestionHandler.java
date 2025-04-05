package chain_of_responsibility;

public class DevelopmentSuggestionHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("DevelopmentSuggestionHandler: Suggestion received from " + message.getSenderEmail());
            System.out.println("Message: " + message.getContent());
            System.out.println("Action: Logged to improvement backlog.\n");
        } else {
            super.handle(message);
        }
    }
}
