
---

## **Java: Core Concepts for Object-Oriented Programming**

Java is a powerful, high-level, object-oriented programming language first released in 1995. Its core philosophy is **"Write Once, Run Anywhere" (WORA)**. This is possible because Java code isn't compiled into machine-specific code, but into an intermediate format called **bytecode**. This bytecode can run on any device that has a **Java Virtual Machine (JVM)** installed, making Java platform-independent.

Java is a cornerstone of modern software development, widely used for:

- **Web Applications:** Powering the backend of countless websites and services using frameworks like Spring and Jakarta EE.
- **Mobile Apps:** It is the foundational language for native Android development.
- **Big Data:** Frameworks like Hadoop and Spark are built with Java.
- **Enterprise Software:** Its stability and security make it a top choice for large-scale business applications.

### **Key Strengths of Java**

- **Platform Independence:** The JVM acts as an abstraction layer, allowing the same Java program to run on Windows, macOS, and Linux without modification.
- **Object-Oriented Programming (OOP):** Java is built around the concepts of classes and objects, promoting modular, flexible, and reusable code through principles like inheritance, encapsulation, and polymorphism.
- **Strong Security:** Java was designed with security in mind. It runs code in a sandboxed environment (the JVM), lacks explicit pointers to prevent unauthorized memory access, and has a Security Manager to define access policies.
- **Rich Standard Library:** Java provides a vast collection of pre-built classes and methods for everything from networking and database connectivity to data structures and file I/O, significantly speeding up development.
- **Multithreading:** Java has built-in support for multithreading, allowing programs to perform multiple tasks concurrently. This is essential for building responsive applications and high-performance servers.

---

### **Data Types: The Building Blocks** 

Every variable in Java has a data type, which determines the size and type of value it can hold. They are split into two main categories.

- #### Primitive Types
    
    These are the most basic data types and store simple, single values. They are always lowercase.

| **Data Type** | **Size** | **Description**                                                                                    |
| ------------- | -------- | -------------------------------------------------------------------------------------------------- |
| `byte`        | 1 byte   | Stores whole numbers from -128 to 127.                                                             |
| `short`       | 2 bytes  | Stores whole numbers from -32,768 to 32,767.                                                       |
| `int`         | 4 bytes  | Stores whole numbers from -2.1 billion to 2.1 billion. The most common integer type.               |
| `long`        | 8 bytes  | Stores very large whole numbers. Use an `L` suffix (e.g., `long num = 15000000000L;`).             |
| `float`       | 4 bytes  | Stores fractional numbers (6-7 decimal digits). Use an `f` suffix (e.g., `float pi = 3.14f;`).     |
| `double`      | 8 bytes  | Stores fractional numbers (up to 15 decimal digits). The most common decimal type.                 |
| `boolean`     | 1 bit    | Stores only `true` or `false` values.                                                              |
| `char`        | 2 bytes  | Stores a single character, letter, or ASCII value. Uses single quotes (e.g., `char grade = 'A';`). |


---

#### Non-Primitive (Reference) Types

These types refer to objects and are more complex. They don't store the actual data but a _reference_ (a memory address) to where the object is stored.

**Key Differences:**

| **Primitive**                                      | **Non-Primitive (Reference)**                           |
| -------------------------------------------------- | ------------------------------------------------------- |
| Must have a value.                                 | Can be `null` (meaning it doesn't refer to any object). |
| Stores a single, simple value.                     | Can hold complex data and have associated methods.      |
| Name starts with a lowercase letter (e.g., `int`). | Name starts with an uppercase letter (e.g., `String`).  |
| Fixed memory size.                                 | Memory size varies depending on the object.             |

Examples include **`String`**, **Arrays**, **Classes**, and **Interfaces**.
---

### **Class: The Blueprint for Objects** blueprints

A **class** is a blueprint or template for creating objects. It defines a set of common properties (**fields** or variables) and behaviors (**methods** or functions) that its objects will share. An **object** is a specific instance of a class.

Think of it this way: `Car` is a class. It defines properties like `color` and `maxSpeed`, and methods like `startEngine()` and `drive()`. Your specific car, a red Ferrari (`myCar`), is an object of the `Car` class.

#### **Core Components of a Class**

1. **Fields (Variables):** Store the state of an object (e.g., `String color;`, `int year;`).
2. **Methods (Functions):** Define the behavior of an object. They are blocks of code that run when called.
3. **Constructors:** A special method that is called automatically when a new object is created. Its primary job is to initialize the object's fields. A constructor's name must be identical to the class name.
4. **Access Modifiers:** Keywords that set the visibility and accessibility of classes, fields, and methods.

|                        |           |             |              |           |
| ---------------------- | --------- | ----------- | ------------ | --------- |
| **Modifier**           | **Class** | **Package** | **Subclass** | **World** |
| `public`               | ✅         | ✅           | ✅            | ✅         |
| `protected`            | ✅         | ✅           | ✅            | ❌         |
| `default` (no keyword) | ✅         | ✅           | ❌            | ❌         |
| `private`              | ✅         | ❌           | ❌            | ❌         |

#### **The `main` Method: Your Program's Entry Point** 

A Java program begins execution in the `main` method. The JVM looks for this exact signature to start the program.

Java

```
public static void main(String[] args) {
    // Your program starts here
}
```

- `public`: It can be called from anywhere.
- `static`: It belongs to the class, not an object. It can be run without creating an instance of the class.
- `void`: It does not return any value.
- `main`: The name of the method.
- `String[] args`: An array of strings that can be used to pass command-line arguments to the program.

#### **Tutorial: Creating a `Computer` Class**

Let's build a `Computer` class and create objects from it.

**1. Create the `Computer.java` file.**


```java=
// Computer.java

public class Computer {
    // 1. Fields (Properties)
    private String brand;
    private int ramInGB;
    private boolean isPoweredOn;

    // 2. Constructor: Initializes a new Computer object
    public Computer(String brand, int ramInGB) {
        this.brand = brand;
        this.ramInGB = ramInGB;
        this.isPoweredOn = false; // A computer is off by default
    }

    // 3. Methods (Behaviors)
    public void powerOn() {
        if (!isPoweredOn) {
            isPoweredOn = true;
            System.out.println(this.brand + " is powering on...");
        } else {
            System.out.println(this.brand + " is already on.");
        }
    }

    public void shutDown() {
        if (isPoweredOn) {
            isPoweredOn = false;
            System.out.println(this.brand + " is shutting down.");
        } else {
            System.out.println(this.brand + " is already off.");
        }
    }

    public void displayInfo() {
        System.out.println("--- Computer Info ---");
        System.out.println("Brand: " + this.brand);
        System.out.println("RAM: " + this.ramInGB + "GB");
        System.out.println("Status: " + (isPoweredOn ? "On" : "Off"));
        System.out.println("---------------------");
    }

    // 4. The main method to run the program
    public static void main(String[] args) {
        // Create two objects (instances) of the Computer class
        Computer myLaptop = new Computer("Dell", 16);
        Computer officePC = new Computer("HP", 8);

        // Interact with the objects
        myLaptop.displayInfo(); // Display initial state
        myLaptop.powerOn();     // Turn it on
        myLaptop.displayInfo(); // Display new state

        System.out.println(); // Add a blank line for readability

        officePC.displayInfo();
        officePC.shutDown();    // Try to shut down a computer that's already off
    }
}
```

**Output:**

```
--- Computer Info ---
Brand: Dell
RAM: 16GB
Status: Off
---------------------
Dell is powering on...
--- Computer Info ---
Brand: Dell
RAM: 16GB
Status: On
---------------------

--- Computer Info ---
Brand: HP
RAM: 8GB
Status: Off
---------------------
HP is already off.
```

---

### **Enumeration (`enum`): For Fixed Sets of Constants** 

An **enumeration (`enum`)** is a special class that represents a group of fixed constants. Use enums when you have a variable that can only take one value from a small, predefined set, such as days of the week, compass directions, or user roles.

Enums improve type safety and code readability. Using `TrafficLight.GREEN` is much clearer and safer than using a raw integer like `2`.

#### **Enhanced `enum` Example**

Enums can have fields, constructors, and methods, making them incredibly powerful.

```java=
// Day.java
public enum Day {
    // Enum constants with associated values
    SUNDAY("Weekend"),
    MONDAY("Weekday"),
    TUESDAY("Weekday"),
    WEDNESDAY("Weekday"),
    THURSDAY("Weekday"),
    FRIDAY("Weekday"),
    SATURDAY("Weekend");

    // Field for each enum constant
    private final String dayType;

    // Constructor (is implicitly private)
    Day(String dayType) {
        this.dayType = dayType;
    }

    // Method
    public void printDayType() {
        System.out.println(this.name() + " is a " + this.dayType);
    }

    public static void main(String[] args) {
        Day today = Day.MONDAY;
        Day weekend = Day.SATURDAY;

        today.printDayType();    // Output: MONDAY is a Weekday
        weekend.printDayType();  // Output: SATURDAY is a Weekend
    }
}
```

---

### **Interface vs. Abstract Class**

Both interfaces and abstract classes are used for abstraction, but they serve different purposes. **Abstraction** means hiding complex implementation details and showing only the essential features of an object.

#### **Interface: A 100% Abstract Contract** 

An **interface** is a completely abstract type that defines a contract of _what_ a class can do, without specifying _how_. A class that `implements` an interface must provide an implementation for all its abstract methods.

Think of an interface as a job contract. It lists the duties (`work()`, `submitReport()`), but it's up to the employee (the class) to figure out how to perform them.

**Key Features:**

- All methods are `public` and `abstract` by default.
- All variables are `public`, `static`, and `final` (constants) by default.
- A class can implement **multiple** interfaces.
- Since Java 8, interfaces can have `default` and `static` methods with implementations, providing more flexibility.

```java=
// Drivable.java (Interface)
public interface Drivable {
    void turnOn();      // Abstract method
    void accelerate();  // Abstract method
    void brake();       // Abstract method
}

// Car.java
class Car implements Drivable {
    @Override
    public void turnOn() {
        System.out.println("Car engine starts.");
    }
    @Override
    public void accelerate() {
        System.out.println("Car is speeding up.");
    }
    @Override
    public void brake() {
        System.out.println("Car is slowing down.");
    }
}

// Bicycle.java
class Bicycle implements Drivable {
    @Override
    public void turnOn() {
        System.out.println("Bicycle is ready to go (no engine).");
    }
    @Override
    public void accelerate() {
        System.out.println("Pedaling faster.");
    }
    @Override
    public void brake() {
        System.out.println("Squeezing hand brakes.");
    }
}
```

#### **Abstract Class: A Partial Blueprint** 

An **abstract class** is a class that cannot be instantiated on its own and is meant to be subclassed. It can contain a mix of abstract methods (without a body) and concrete methods (with an implementation).

Think of an abstract class as a general concept, like `Animal`. You can't have just an "Animal," but you can have specific types like `Dog` or `Cat` that inherit common traits (like `name`) and behaviors (like `eat()`) but have their own unique way of making a sound (`makeSound()`).

**Key Features:**

- Can have abstract and non-abstract methods.
- Can have fields that are not static or final.
- Can have constructors, which are called by subclasses.
- A class can **extend** only **one** abstract class.

```java=
// Animal.java (Abstract Class)
abstract class Animal {
    private String name;

    public Animal(String name) { // Constructor
        this.name = name;
    }

    // Abstract method - must be implemented by subclasses
    public abstract void makeSound();

    // Concrete method - inherited by all subclasses
    public void sleep() {
        System.out.println(this.name + " is sleeping... Zzz");
    }

    public String getName() {
        return this.name;
    }
}

// Dog.java
class Dog extends Animal {
    public Dog(String name) {
        super(name); // Call the parent constructor
    }
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof!");
    }
}
```

#### **When to Use Which?**

| **Feature**              | **Interface**                                                            | **Abstract Class**                                                 |
| ------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------ |
| **Multiple Inheritance** | ✅ A class can implement many interfaces.                                 | ❌ A class can extend only one class.                               |
| **Purpose**              | Defines a contract of _capabilities_ (e.g., `Serializable`, `Drivable`). | Defines the _identity_ of an object and shares common code.        |
| **Methods**              | Historically all abstract. Now allows `default` and `static` methods.    | Can have a mix of abstract and concrete methods.                   |
| **Fields**               | Only `public static final` constants.                                    | Can have any type of instance field.                               |
| **Constructor**          | ❌ No constructor.                                                        | ✅ Has constructors for subclass initialization.                    |
| **When to use...**       | When you want to define behavior for unrelated classes.                  | When you want to share code among several closely related classes. |

---

## **Git and GitHub: Essential Tools for Developers**

It's crucial to understand the difference:

- **Git** is the **tool**. It's a distributed version control system (VCS) that runs on your local machine to track changes in your code.
- **GitHub** is the **service**. It's a web-based platform that hosts your Git repositories, enabling collaboration, code review, and project management.

### **Git: Tracking Your Project's History** 

Git saves "snapshots" (called **commits**) of your files, allowing you to go back to any previous state. It's incredibly powerful for working on features without breaking your main codebase, thanks to a feature called **branching**.
![[Module1_Github.png]]
#### **Basic Git Workflow Tutorial**

1. **Initialize or Clone**
    
    - To start a new repository in your project folder: `git init`
    - To download an existing repository from a platform like GitHub: `git clone <URL>`
2. The Three Stages
    
    Your files exist in one of three states:
    
    - **Working Directory:** The files you are currently modifying.
    - **Staging Area (Index):** A "drafting" area where you prepare the changes you want to include in the next commit.
    - **Repository (`.git` directory):** Where Git permanently stores your committed snapshots.
3. **Add & Commit**
    
    - Check the status of your files: `git status`
    - Add a modified file to the staging area: `git add <filename>` or `git add .` (to add all changes).
    - Save the staged changes to your repository with a descriptive message: `git commit -m "Your descriptive message"`
4. Branching
    
    Branches let you work on new features or bug fixes in isolation.
    
    - Create a new branch: `git branch <new-branch-name>`
    - Switch to that branch: `git checkout <new-branch-name>`
    - Create and switch in one step: `git checkout -b <new-branch-name>`
5. **Sync with a Remote (like GitHub)**
    
    - Push your commits to a remote repository: `git push origin <branch-name>`
    - Pull updates from a remote repository: `git pull origin <branch-name>`

### **GitHub: Collaborating on Code** 

GitHub builds on top of Git by providing a central place for teams to work together.

#### **Key GitHub Feature: The Pull Request**

A **Pull Request (PR)** is the heart of collaboration on GitHub. It's a way of saying, "I've made some changes on my branch, please review them and merge them into the main branch." This allows for code review, discussion, and automated checks before new code is integrated.

#### **Basic GitHub Contribution Workflow**

1. **Fork the Repository:** Create your own personal copy of a project on GitHub.
2. **Clone Your Fork:** Download your forked repository to your local machine using `git clone`.
3. **Create a Branch:** Create a new branch for your feature (`git checkout -b my-new-feature`).
4. **Code & Commit:** Make your changes, then `git add` and `git commit` them.
5. **Push to Your Fork:** Push your new branch and its commits to your fork on GitHub (`git push origin my-new-feature`).
6. **Open a Pull Request:** Go to the original repository on GitHub. You'll see a prompt to create a Pull Request from your new branch. Fill out the details, and the project maintainers will be notified to review your work.