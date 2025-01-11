package beemail;

public class Main {
    public static void main(String[] args) {
        App app = App.getInstance();

        User user1 = new User("1", "Alice");
        User user2 = new User("2", "Bob");
        user1.login(app);
        user2.login(app);

        user1.sendMessage("2", "Hello, Bob!");

        ExternalMessage extMessage = new ExternalMessage("This is an external message.");
        user1.sendExternalMessage("2", extMessage);

        System.out.println("----- Bob's Inbox --------------------------------");
        for (int i = 0; i < user2.getInbox().size(); i++) {
            user2.readMessage(i);
        }
    }
}



