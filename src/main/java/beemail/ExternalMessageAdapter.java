package beemail;

public class ExternalMessageAdapter implements AbstractMessage {
    private ExternalMessage externalMessage;
    private User from;
    private User to;

    public ExternalMessageAdapter(User from, User to, ExternalMessage externalMessage) {
        this.externalMessage = externalMessage;
        this.from = from;
        this.to = to;
    }

    @Override
    public String getContent() {
        return externalMessage.getBody();
    }

    @Override
    public void markDelivered() {}

    @Override
    public void markRead() {
        externalMessage.toggleRead();
    }

    @Override
    public void log() {
        System.out.println("External Message Adapter:");
        System.out.println("From: " + from.getUsername() + " to: " + to.getUsername());
        System.out.println("Content: " + externalMessage.getBody());
        System.out.println("Read: " + externalMessage.isRead());
    }
}

