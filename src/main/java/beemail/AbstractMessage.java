package beemail;

public interface AbstractMessage {
    String getContent();
    void markDelivered();
    void markRead();
    void log();
}

