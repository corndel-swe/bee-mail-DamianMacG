package beemail;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String username;
    private List<AbstractMessage> inbox;
    private App app;

    public User(String id, String username) {
        this.id = id;
        this.username = username;
        this.inbox = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<AbstractMessage> getInbox() {
        return inbox;
    }

    public void login(App app) {
        this.app = app;
        app.addUser(this);
    }

    public void sendMessage(String recipientId, String content) {
        Message message = new Message(this, app.findUser(recipientId), content);
        app.deliverMessage(this.id, recipientId, message);
    }

    public void sendExternalMessage(String recipientId, ExternalMessage externalMessage) {
        app.deliverExternalMessage(this.id, recipientId, externalMessage);
    }

    public void receiveMessage(AbstractMessage message) {
        inbox.add(message);
    }

    public void readMessage(int idx) {
        if (idx >= 0 && idx < inbox.size()) {
            AbstractMessage message = inbox.get(idx);
            message.markRead();
            message.log();
        }
    }
}

