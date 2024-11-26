package beemail;

import java.util.ArrayList;
import java.util.List;

public class App {

    // Static field to hold the single instance of App pour la Singleton pattern
    private static App instance;

    // Array to hold users logged in
    private List<User> users;

    // Private constructor to prevent direct instantiation from outside of App
    private App() {
        users = new ArrayList<>();
    }

    // Create (the single) instance of App
    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    // Add user
    public void addUser(User user) {
        users.add(user);
    }

    // Find user by ID
    public User findUser(String userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public void deliverMessage(String senderId, String recipientId, String content) {
        User sender = findUser(senderId);
        User recipient = findUser(recipientId);

        // Check both exist - sender and recipient
        if (sender != null && recipient != null) {

            // Create the new message, deliver it to recipient, mark as delivered.
            Message message = new Message(sender, recipient, content);
            recipient.receiveMessage(message);
            message.markDelivered();
        }
    }
}

