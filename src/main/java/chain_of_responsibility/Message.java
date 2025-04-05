package chain_of_responsibility;

public class Message {
    private MessageType type;
    private String content;
    private String senderEmail;
    private String senderRole;

    public Message(MessageType type, String content, String senderEmail, String senderRole) {
        this.type = type;
        this.content = content;
        this.senderEmail = senderEmail;
        this.senderRole = senderRole;
    }

    public MessageType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getSenderRole() {
        return senderRole;
    }
}
