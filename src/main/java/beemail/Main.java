package beemail;

public class Main {
    public static void main(String[] args) {
        // Get the singleton instance of the App
        App app = App.getInstance();

        // Create users, log them in, send some messages
        User user1 = new User("1", "Alice");
        User user2 = new User("2", "Bob");
        user1.login(app);
        user2.login(app);
        user1.sendMessage("2", "Hey Bob, I just adopted a kitten! His name is Whiskers.");
        user1.sendMessage("2", "He's so playful and cute, I can't stop watching him chase toys!");
        user2.sendMessage("1", "Aww, that's amazing Alice! I love kittens. What's Whiskers' favorite toy?");
        user2.sendMessage("1", "I have a kitten too! His name is Shadow, and he loves playing with laser pointers.");
        user1.sendMessage("2", "Whiskers is obsessed with this little mouse toy. He carries it everywhere!");
        user2.sendMessage("1", "Shadow loves his laser pointer so much, he gets so hyper! It's so funny to watch him zoom around.");

        // Print out their inboxes
        System.out.println("----- Alice's Inbox --------------------------------------------");
        for (int i = 0; i < user1.getInbox().size(); i++) {
            user1.readMessage(i);
        }

        System.out.println("----- Bob's Inbox ----------------------------------------------");
        for (int i = 0; i < user2.getInbox().size(); i++) {
            user2.readMessage(i);
        }
    }
}


