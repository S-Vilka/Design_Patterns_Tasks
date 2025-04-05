package chain_of_responsibility;

public class ContactRequestHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("ContactRequestHandler: Forwarding contact request from " + message.getSenderEmail());
            System.out.println("Message: " + message.getContent());
            System.out.println("Action: Support will reach out via email.\n");
        } else {
            super.handle(message);
        }
    }
}
