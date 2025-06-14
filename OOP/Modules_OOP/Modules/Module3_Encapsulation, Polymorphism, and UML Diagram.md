
---
## **Encapsulation**

**Encapsulation** is a fundamental concept in Object-Oriented Programming (OOP) that involves bundling an object's data (fields) and the methods that operate on that data into a single unit, or **class**. Its primary goal is to achieve **data hiding**, which means the internal state of an object is protected from outside access.

Instead of allowing direct access to data fields, encapsulation provides controlled access through public methods. This prevents other parts of your program from accidentally or maliciously modifying an object's data into an inconsistent or invalid state.

In Java, you achieve encapsulation by declaring an object's fields as `private`. This makes them inaccessible from outside the class. To allow controlled access, you then provide `public` methods known as **getters** and **setters**.

* **Getter (Accessor):** A method used to retrieve or **get** the value of a private field.
* **Setter (Mutator):** A method used to modify or **set** the value of a private field. Setters can include validation logic to ensure the new value is appropriate.
### Example

Consider a `Car` class where the `model` is a private field.

**Car.java**
```java
package Practice.Module3.Encapsulation;

public class Car {
    // 1. The field is private to hide it from direct outside access.
    private String model;

    // Constructor to initialize the object
    public Car(String model) {
        this.model = model;
    }

    // 2. Public getter to allow read-only access to the model.
    public String getModel() {
        return this.model;
    }

    // 3. Public setter to allow controlled modification of the model.
    public void setModel(String newModel) {
        // Adding validation logic, For example, prevent the model from being set to null or an empty string.
        if (newModel != null && !newModel.trim().isEmpty()) {
            this.model = newModel;
        } else {
            System.out.println("Error: Model name cannot be empty.");
        }
    }
}

```

**Main.java**
```java
package Practice.Module3.Encapsulation;

public class Main {
    public static void main(String[] args) {
        // Create a new Car object
        Car myCar = new Car("Focus");
        System.out.println("Original model: " + myCar.getModel()); // Access using the getter

        // --- Correct way to change the model ---
        // Use the public setter method.
        myCar.setModel("Ranger");
        System.out.println("Updated model: " + myCar.getModel()); // "Ranger"

        // --- Incorrect way (will cause a compile error) ---
        // myCar.model = "F-150"; // Error: The field 'model' is private in 'Car'
    }
}
```

Output:
![[Pasted image 20250615045731.png]]
### **Why Use Encapsulation?**

* **Control and Validation:** You can control the values assigned to fields. A setter can validate input before changing a field's value.
* **Data Hiding:** It protects an object's internal state from outside interference, which is crucial for maintaining data integrity.
* **Flexibility and Maintenance:** You can change the internal implementation of a class (e.g., how data is stored) without breaking the code that uses it, as long as the public methods remain the same.
* **Read-Only or Write-Only Classes:** You can create read-only classes by providing only getters, or write-only classes by providing only setters.

---

## **Polymorphism**

**Polymorphism**, which means "many forms," is another core OOP concept. It allows objects, methods, or operators to behave differently in different contexts. In simple terms, it's the ability to perform a single action in different ways.

A real-world analogy is the verb "to draw." You can draw a shape, draw a conclusion, or draw a weapon—the same action ("draw") has different outcomes depending on the context.

In Java, polymorphism is primarily achieved through two mechanisms: **method overloading** (compile-time polymorphism) and **method overriding** (run-time polymorphism).

### **1. Method Overloading (Compile-Time Polymorphism)**

**Method overloading** occurs when two or more methods within the same class have the **same name** but **different parameters**. The difference can be in the number of parameters, the type of parameters, or both. The correct method to call is determined by the compiler at compile time based on the arguments provided.

**Key Rules for Overloading:**
* Method names must be the same.
* The parameter list must be different.
* The return type can be the same or different.

**Overloading Example**
```java
package Practice.Module3.Polymorphism.Overloading;

class Printer {
    // Method to print a string
    public void print(String text) {
        System.out.println("Printing text: " + text);
    }

    // Overloaded method to print a number
    public void print(int number) {
        System.out.println("Printing number: " + number);
    }

    // Overloaded method to print both
    public void print(String text, int number) {
        System.out.println("Printing text: " + text + ", and number: " + number);
    }
}

public class Main {
    public static void main(String[] args) {
        Printer myPrinter = new Printer();
        myPrinter.print("Hello World");     // Calls the first method
        myPrinter.print(123);               // Calls the second method
        myPrinter.print("Page", 42);        // Calls the third method
    }
}
```

### **2. Method Overriding (Run-Time Polymorphism)**

**Method overriding** occurs when a **subclass** provides a specific implementation for a method that is already defined in its **superclass**. The version of the method that gets executed is determined at run-time based on the object's actual type.

This is a key feature of inheritance, allowing a child class to modify the behavior inherited from its parent.

**Key Rules for Overriding:**
* The method must have the same name and parameter list as in the parent class.
* The access modifier must be the same or less restrictive (e.g., you can override a `protected` method with `public`, but not with `private`).
* It's a best practice to use the `@Override` annotation.

**Overriding Example**
```java
package Practice.Module3.Polymorphism.Overriding;

// Superclass
class Animal {
    public void makeSound() {
        System.out.println("The animal makes a sound.");
    }
}

// Subclass
class Dog extends Animal {
    // This method overrides the one in the Animal class
    @Override
    public void makeSound() {
        System.out.println("The dog barks: Woof! Woof!");
    }
}

// Another subclass
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The cat meows: Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog(); // Polymorphism: Dog object treated as an Animal
        Animal myCat = new Cat(); // Polymorphism: Cat object treated as an Animal

        myAnimal.makeSound(); // Executes Animal's method
        myDog.makeSound();    // Executes Dog's overridden method
        myCat.makeSound();    // Executes Cat's overridden method
    }
}
```

---

## **UML (Unified Modeling Language)**

The **Unified Modeling Language (UML)** is a standardized visual language used to design, specify, visualize, and document software systems. It provides a set of graphical notations to create abstract models of a system.

For Java developers, the most common type of UML diagram is the **UML Class Diagram**.

### **UML Class Diagram**

A **UML Class Diagram** describes the static structure of a system by showing its classes, their attributes (fields), methods, and the relationships between them (like inheritance or association). It serves as a blueprint for the program's architecture.

A typical class diagram includes:
* **Class Name:** The name of the class.
* **Attributes:** The fields or variables of the class, often including their data types and access modifiers (`+` for public, `-` for private, `#` for protected).
* **Methods:** The functions of the class, including their parameters, return types, and access modifiers.
* **Relationships:** Lines connecting classes to show inheritance (`extends`), implementation (`implements`), association, and other relationships.