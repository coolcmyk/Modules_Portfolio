
## **Higher-Level Abstraction and Design Patterns**

### **A Recap of the Four Pillars of OOP**

To build advanced software, we must first master the four fundamental pillars of Object-Oriented Programming (OOP):

* **Inheritance** : Allows a class to inherit properties and methods from another, creating an "is-a" relationship.
* **Encapsulation** : Bundles data and methods within a class, protecting data from unauthorized access.
* **Polymorphism** : Enables objects to take on many forms, allowing a single action to be performed in different ways.
* **Abstraction** : Hides complex implementation details, showing only essential functionalities to the user.

**Higher-Level Abstraction** is the art of skillfully combining these four pillars to design software that is efficient, scalable, and easy to maintain. This advanced practice is most effectively applied through the use of **Design Patterns**.

---

## **Design Patterns: Blueprints for Solving Problems**

A **Design Pattern** is a general, reusable solution to a commonly occurring problem in software design. It's not a specific algorithm, but a proven template for structuring your code. By using design patterns, you build on the collective experience of the software development community.

### **1. Creational Patterns**

These patterns provide various object creation mechanisms that increase flexibility and code reuse. They help manage the process of object creation, ensuring it's done in a way that is appropriate for the situation.

**Scenario:** Your application needs a single, globally accessible `AppSettings` object to manage configurations like theme and language. Creating multiple instances would lead to chaos and data inconsistency.

**Solution:** The **Singleton Pattern** is a creational pattern that guarantees a class has only one instance and provides a global point of access to it.

#### **Singleton Pattern: Code Example**

```java
// AppSettings.java
// The Singleton class.
public class AppSettings {
    // 1. The single, static instance of the class. It's private so it can't be accessed directly.
    private static AppSettings instance;

    // Class attributes
    private String theme;

    // 2. The constructor is private to prevent instantiation from other classes.
    private AppSettings() {
        // Default settings
        theme = "Light";
    }

    // 3. The public static method that provides the global access point.
    public static AppSettings getInstance() {
        // Lazy initialization: create the instance only if it doesn't exist yet.
        if (instance == null) {
            instance = new AppSettings();
        }
        return instance;
    }

    // Getters and Setters for the settings
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        // Get the singleton instance from two different places in the code
        AppSettings settings1 = AppSettings.getInstance();
        AppSettings settings2 = AppSettings.getInstance();

        // Check if both variables point to the exact same object
        if (settings1 == settings2) {
            System.out.println("Both settings1 and settings2 are the same instance.");
        }

        // Prove it by changing the theme using one reference
        System.out.println("Initial theme: " + settings1.getTheme());
        settings1.setTheme("Dark");

        // The change is reflected when accessed through the other reference
        System.out.println("Theme after change: " + settings2.getTheme());
    }
}
```

**Output:**

```
Both settings1 and settings2 are the same instance.
Initial theme: Light
Theme after change: Dark
```

---

### **2. Structural Patterns**

These patterns explain how to assemble objects and classes into larger structures while keeping them flexible and efficient. They focus on simplifying the relationships between entities, often by promoting **"Composition over Inheritance."**

**Scenario:** You have a notification system that sends emails. Now, you need to add functionality to also send SMS and Slack notifications. You want to be able to combine these options flexibly (e.g., Email + SMS, or Email + Slack + SMS). Using inheritance would create a complex and rigid class hierarchy.

**Solution:** The **Decorator Pattern** is a structural pattern that allows you to dynamically add new behaviors to objects by placing them inside special wrapper objects.

#### **Decorator Pattern: Code Example**

```java
// Notifier.java
// The component interface.
public interface Notifier {
    void send(String message);
}

// EmailNotifier.java
// A concrete component. This is the base object we'll decorate.
public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email with message: " + message);
    }
}

// NotifierDecorator.java
// The abstract decorator class. It holds a reference to another Notifier object.
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message); // Delegate to the wrapped notifier
    }
}

// SMSNotifierDecorator.java
// A concrete decorator that adds SMS functionality.
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // First, do the original notification
        sendSMS(message);    // Then, add the new functionality
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}

// SlackNotifierDecorator.java
// Another concrete decorator that adds Slack functionality.
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}

// Main.java
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
```

**Output:**
```
Sending notification with all channels enabled:
Sending Email with message: Your order has been shipped!
Sending SMS with message: Your order has been shipped!
Sending Slack message: Your order has been shipped!
```

---

### **3. Behavioral Patterns**

These patterns are concerned with algorithms and the assignment of responsibilities between objects. They define how objects collaborate and communicate, making the system more flexible.

**Scenario:** You are building a shopping cart that needs to process payments. The user should be able to choose from different payment methods, like Credit Card or PayPal. You don't want to clutter your `ShoppingCart` class with `if-else` statements for each payment type.

**Solution:** The **Strategy Pattern** is a behavioral pattern that lets you define a family of algorithms, put each into a separate class, and make their objects interchangeable. The `ShoppingCart` can hold a reference to a payment strategy and delegate the payment action to it, without knowing the specifics of how the payment is processed.

#### **Strategy Pattern: Code Example**

```java
// PaymentStrategy.java
// The strategy interface.
public interface PaymentStrategy {
    void pay(int amount);
}

// CreditCardPayment.java
// A concrete strategy.
class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;

    public CreditCardPayment(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit card " + cardNumber);
    }
}

// PayPalPayment.java
// Another concrete strategy.
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal account " + email);
    }
}

// ShoppingCart.java
// The context class that uses a strategy.
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Method to set the strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        // Delegate the payment call to the strategy object
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay using Credit Card
        PaymentStrategy creditCard = new CreditCardPayment("John Doe", "1234-5678-9012-3456");
        cart.setPaymentStrategy(creditCard);
        cart.checkout(150);

        System.out.println("--- Changing payment method ---");

        // Pay using PayPal
        PaymentStrategy paypal = new PayPalPayment("john.doe@example.com");
        cart.setPaymentStrategy(paypal);
        cart.checkout(200);
    }
}
```

**Output:**
```
150 paid with credit card 1234-5678-9012-3456
--- Changing payment method ---
200 paid using PayPal account john.doe@example.com
```