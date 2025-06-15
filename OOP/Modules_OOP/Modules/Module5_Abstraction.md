
### **What Is Abstraction?**

**Abstraction** is a core pillar of Object-Oriented Programming (OOP) that focuses on simplifying complex systems by hiding implementation details and showing only the essential features. It allows us to represent real-world objects and ideas in our code by focusing on *what* an object does, rather than *how* it does it.

A simple real-world analogy is driving a car. To drive, you only need to interact with a simple interface: the steering wheel, pedals, and gear stick. You don't need to know the complex mechanics of the engine, transmission, or electrical systems working behind the scenes. Those details are abstracted away, making the car easy to use.

In Java, abstraction is primarily achieved using **abstract classes** and **interfaces**.

### **Why Is Abstraction Important?**

Abstraction is crucial for building large-scale, maintainable applications for several reasons:

* **Reduces Complexity:** It simplifies complex systems by breaking them down into manageable, understandable parts.
* **Improves Security:** By hiding sensitive implementation details, it prevents direct access to an object's internal data, which can help avoid unintended modifications.
* **Enhances Maintainability:** It allows you to change the internal implementation of a class without affecting the other parts of the code that use it. As long as the public interface remains the same, the rest of the application doesn't need to be changed.
* **Increases Reusability:** It helps in creating flexible components that can be reused across different parts of an application or in different projects.

### **Implementing Abstraction in Java**

Java provides two main tools to implement abstraction:

1.  **Abstract Class:** A restricted class that cannot be used to create objects (it cannot be instantiated). It serves as a blueprint for other classes. An abstract class can have both abstract methods (methods without a body) and regular methods (with a body).
2.  **Interface:** A completely abstract blueprint of a class. It can only have abstract methods and `static final` variables. A class `implements` an interface, thereby inheriting its abstract methods.

### **Abstraction Example**

Let's look at an example using an abstract class. The `Vehicle` class defines the general idea of a vehicle, but you can't create a generic "Vehicle" object. Instead, you create specific types like `Car` or `ElectricScooter`, which provide their own unique implementation for the `start()` method.

```java
package Practice.Module5.Abstraction;  
  
// An abstract class serves as a blueprint and cannot be instantiated directly.  
abstract class Vehicle {  
    private String brand;  
  
    // Constructor to initialize the brand  
    public Vehicle(String brand) {  
        this.brand = brand;  
    }  
  
    // A public getter provides access to the private 'brand' field.  
    public String getBrand() {  
        return this.brand;  
    }  
  
    // A public setter allows modification of the private 'brand' field.  
    public void setBrand(String brand) {  
        this.brand = brand;  
    }  
  
    // An abstract method has no implementation.  
    // Subclasses are forced to provide their own implementation.    abstract void start();  
}
```

```java
package Practice.Module5.Abstraction;  
  
// 'Car' is a concrete subclass that inherits from Vehicle.  
class Car extends Vehicle {  
  
    public Car(String brand) {  
        super(brand); // Calls the constructor of the parent class (Vehicle)  
    }  
  
    // Provides a specific implementation for the abstract 'start' method.  
    @Override  
    void start() {  
        System.out.println(getBrand() + " car is starting with a key. 🔑");  
    }  
}
```

```java
package Practice.Module5.Abstraction;  
  
// 'ElectricScooter' is another concrete subclass.  
class ElectricScooter extends Vehicle {  
  
    public ElectricScooter(String brand) {  
        super(brand);  
    }  
  
    // Provides a different implementation for the 'start' method.  
    @Override  
    void start() {  
        System.out.println(getBrand() + " electric scooter is starting with a button. 🛴");  
    }  
}
```

```java
package Practice.Module5.Abstraction;  
  
public class Main {  
    public static void main(String[] args) {  
        // We can create objects of the concrete subclasses.  
        Vehicle myCar = new Car("Toyota");  
        Vehicle myScooter = new ElectricScooter("Xiaomi");  
  
        // The correct 'start()' method is called for each object at runtime.  
        myCar.start();  
        myScooter.start();  
  
        System.out.println("---");  
  
        // We can still use the methods from the abstract superclass.  
        System.out.println("Original car brand: " + myCar.getBrand());  
        myCar.setBrand("Honda");  
        System.out.println("New car brand: " + myCar.getBrand());  
    }  
}
```

**Output:**

![[Pasted image 20250615130227.png]]
In this example, the `Main` class interacts with both `Car` and `ElectricScooter` objects through the common `Vehicle` type. It doesn't need to know the specific details of how each vehicle starts—it just calls the `start()` method. This is the power of abstraction in action.