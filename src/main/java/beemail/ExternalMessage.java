package beemail;

public class ExternalMessage {
    private String body;
    private boolean read;

    public ExternalMessage(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isRead() {
        return read;
    }

    public void toggleRead() {
        this.read = !this.read;
    }

}
