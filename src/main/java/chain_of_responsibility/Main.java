package chain_of_responsibility;

public class Main {
    public static void main(String[] args) {

        Handler retakeHandler = new RetakeRequestHandler();
        Handler contactHandler = new ContactRequestHandler();
        Handler suggestionHandler = new DevelopmentSuggestionHandler();
        Handler feedbackHandler = new GeneralFeedbackHandler();

        retakeHandler.setNext(contactHandler);
        contactHandler.setNext(suggestionHandler);
        suggestionHandler.setNext(feedbackHandler);

        Handler handlerChain = retakeHandler;

        Message m1 = new Message(MessageType.RETAKE_REQUEST, "I need to retake the exam for Math 101.", "student1@metropolia.fi", "student");
        Message m2 = new Message(MessageType.CONTACT_REQUEST, "Can someone help me log in?", "student2@metropolia.fi", "student");
        Message m3 = new Message(MessageType.DEVELOPMENT_SUGGESTION, "Add calendar integration to the course page.", "prof.jones@metropolia.fi", "teacher");
        Message m4 = new Message(MessageType.GENERAL_FEEDBACK, "Great online lectures this semester!", "student3@metropolia.fi", "student");

        handlerChain.handle(m1);
        handlerChain.handle(m2);
        handlerChain.handle(m3);
        handlerChain.handle(m4);
    }
}
