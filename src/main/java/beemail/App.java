package beemail;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static App instance;
    private List<User> users;

    private App() {
        users = new ArrayList<>();
    }

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findUser(String userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public void deliverMessage(String senderId, String recipientId, AbstractMessage message) {
        User sender = findUser(senderId);
        User recipient = findUser(recipientId);

        if (sender != null && recipient != null && message != null) {
            recipient.receiveMessage(message);
            message.markDelivered();
        }
    }

    public void deliverExternalMessage(String senderId, String recipientId, ExternalMessage externalMessage) {
        User sender = findUser(senderId);
        User recipient = findUser(recipientId);

        if (sender != null && recipient != null) {
            ExternalMessageAdapter adapter = new ExternalMessageAdapter(sender, recipient, externalMessage);
            deliverMessage(senderId, recipientId, adapter);
        }
    }
}


