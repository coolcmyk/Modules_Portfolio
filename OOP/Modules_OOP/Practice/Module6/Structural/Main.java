package Practice.Module6.Structural;

public class Main {
    public static void main(String[] args) {
        // 1. Start with a plain email notifier
        Notifier notifier = new EmailNotifier();

        // 2. Wrap it with the SMS decorator to add SMS functionality
        notifier = new SMSNotifierDecorator(notifier);

        // 3. Wrap it again with the Slack decorator to add Slack functionality
        notifier = new SlackNotifierDecorator(notifier);

        // 4. When send() is called, all functionalities are executed
        System.out.println("Sending notification with all channels enabled:");
        notifier.send("Your order has been shipped!");
    }
}
