package beemail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Message {
    private String id;
    private LocalDateTime timestamp;
    private String content;
    private User from;
    private User to;
    private boolean delivered;
    private boolean read;

    // Constructor automatically generates a unique ID
    public Message(User from, User to, String content) {
        this.id = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
        this.content = content;
        this.from = from;
        this.to = to;
        this.delivered = false;
        this.read = false;
    }

    // Log to the terminal to check everything works
    public void log() {
        System.out.println("Message ID: " + id);
        System.out.println("Message from: " + from.getUsername() + " to: " + to.getUsername());
        System.out.println("Timestamp: " + timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("Content: " + content);
        System.out.println("Delivered: " + delivered);
        System.out.println("Read: " + read);
    }

    public void markDelivered() {
        this.delivered = true;
    }

    public void markRead() {
        this.read = true;
    }
}

