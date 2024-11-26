package beemail;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String username;
    private List<Message> inbox;
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

    public List<Message> getInbox() {
        return inbox;
    }

    public void login(App app) {
        this.app = app;
        app.addUser(this); // refers to the instance that the method is being called on
    }

    public void sendMessage(String recipientId, String content) {
        app.deliverMessage(this.id, recipientId, content);
    }

    public void receiveMessage(Message message) {
        inbox.add(message);
    }

    public void readMessage(int idx) {
        if (idx >= 0 && idx < inbox.size()) {
            Message message = inbox.get(idx);
            message.markRead();
            message.log();
        }
    }
}
