package chain_of_responsibility;

public class RetakeRequestHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.RETAKE_REQUEST) {
            System.out.println("RetakeRequestHandler: Processing retake request from " + message.getSenderEmail());
            System.out.println("Role: " + message.getSenderRole());
            System.out.println("Message: " + message.getContent());
            System.out.println("Action: Retake request forwarded to course instructor.\n");
        } else {
            super.handle(message);
        }
    }
}
