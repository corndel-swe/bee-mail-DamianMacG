package beemail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Message implements AbstractMessage {
    private String id;
    private LocalDateTime timestamp;
    private String content;
    private User from;
    private User to;
    private boolean delivered;
    private boolean read;

    public Message(User from, User to, String content) {
        this.id = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
        this.content = content;
        this.from = from;
        this.to = to;
        this.delivered = false;
        this.read = false;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void markDelivered() {
        this.delivered = true;
    }

    @Override
    public void markRead() {
        this.read = true;
    }

    @Override
    public void log() {
        System.out.println("Message ID: " + id);
        System.out.println("Message from: " + from.getUsername() + " to: " + to.getUsername());
        System.out.println("Timestamp: " + timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("Content: " + content);
        System.out.println("Delivered: " + delivered);
        System.out.println("Read: " + read);
    }
}


