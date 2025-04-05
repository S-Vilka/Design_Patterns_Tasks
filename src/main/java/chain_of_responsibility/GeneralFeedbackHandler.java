package chain_of_responsibility;

public class GeneralFeedbackHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("GeneralFeedbackHandler: Feedback received from " + message.getSenderEmail());
            System.out.println("Message: " + message.getContent());
            System.out.println("Action: Thank you for your feedback!\n");
        } else {
            super.handle(message);
        }
    }
}
