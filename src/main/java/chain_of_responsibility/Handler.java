package chain_of_responsibility;

public abstract class Handler {
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public void handle(Message message) {
        if (next != null) {
            next.handle(message);
        } else {
            System.out.println("No handler found for message: " + message.getType());
        }
    }
}
