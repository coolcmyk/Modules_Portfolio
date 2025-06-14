
---

## **Inheritance and Access Modifiers in Java**

Inheritance and access modifiers are fundamental concepts in Object-Oriented Programming (OOP) that allow you to create clean, reusable, and secure code. Inheritance establishes relationships between classes, while access modifiers control the visibility and accessibility of your code's members.

---

## **Inheritance**

### **What is Inheritance?**

**Inheritance** is a core OOP principle that allows one class (the **subclass**) to inherit the fields and methods of another class (the **superclass**). This creates an "is-a" relationship between the two. For example, a `Car` **is-a** `Vehicle`. The `Car` class can automatically reuse the properties and behaviors of the `Vehicle` class, such as having a `speed` or a `drive()` method, also here's another example of Inheritance with Animal as the Class example
![[Module2_Inheritance.png]]
By using inheritance, you can avoid code duplication and build a logical hierarchy between your classes.

**Key Terminology:**

- **Superclass (or Parent Class):** The class whose features are inherited.
- **Subclass (or Child Class):** The class that inherits from another class. It can add its own unique fields and methods or **override** inherited ones.

### **The `extends` Keyword**

In Java, you use the `extends` keyword to establish an inheritance relationship.


```java=
// Superclass
class Vehicle {
    void drive() {
        System.out.println("This vehicle is moving...");
    }
}

// Subclass
// The 'Car' class now has access to the drive() method.
class Car extends Vehicle {
    void honk() {
        System.out.println("Beep beep!");
    }
}

// Main class to test the inheritance
class Main {
    public static void main(String[] args) {
        // Create an object of the subclass
        Car myCar = new Car();

        myCar.drive(); // Calls the inherited method from Vehicle
        myCar.honk();  // Calls its own method
    }
}
```

**Output:**

```
This vehicle is moving...
Beep beep!
```

### **The `super` Keyword**

The `super` keyword is used within a subclass to refer to its immediate superclass. It has two primary uses:

1. **To call the superclass's constructor:** `super()` is used to call the constructor of the parent class. If used, it **must be the very first line** in the subclass's constructor. This ensures the parent part of the object is properly initialized first.
2. **To call a superclass's method:** `super.methodName()` can be used to access a method from the parent class, which is especially useful when the subclass has overridden that method but you still need the parent's original behavior.

### **Method Overriding**

Method overriding occurs when a subclass provides a specific implementation for a method that is already defined in1 its superclass. This allows for polymorphic behavior, where the exact method that gets called depends on the object's actual type at runtime.

It's a best practice to use the `@Override` annotation, which tells the compiler you intend to override a method. The compiler will then produce an error if you make a mistake, such as misspelling the method name.

```java=
class Character {
    void useAbility() {
        System.out.println("Using a generic ability.");
    }
}

class Mage extends Character {
    @Override // Best practice!
    void useAbility() {
        System.out.println("Casting a fireball! 🔥");
    }
}
```

### **Types of Inheritance in Java**

Java supports several types of inheritance, primarily through classes and interfaces.

1. **Single Inheritance:** A subclass inherits from only one superclass. This is the most common form of inheritance in Java (e.g., `class B extends A`).
2. **Multilevel Inheritance:** A class inherits from a subclass, creating a chain of inheritance (e.g., `class C extends B`, and `class B extends A`).
3. **Hierarchical Inheritance:** One superclass is extended by multiple subclasses (e.g., `class B extends A` and `class C extends A`).
4. **Multiple Inheritance (Through Interfaces):** Java does **not** support inheriting from multiple _classes_ to avoid complexity (the "Diamond Problem"). However, a class can **implement** multiple interfaces, achieving a form of multiple inheritance.
5. **Hybrid Inheritance (Through Interfaces):** A combination of different inheritance types, which is also achievable in Java through a mix of class extension and interface implementation.

### **Upcasting and Downcasting**

Type casting in OOP refers to treating an object of one type as an object of another type.

#### **Upcasting (Generalization)**

**Upcasting** is casting a subclass object to a superclass reference. This is always safe and happens implicitly, so you don't need to write any special syntax. You use upcasting to write more general code.

```java=
// Implicit upcasting: treating a 'Child' as a 'Parent'.
Parent a = new Child();
```

After upcasting, you can only access the methods and variables defined in the superclass (`Parent`). This is because the reference type determines what is accessible.

#### **Downcasting (Specialization)**

**Downcasting** is casting a superclass reference back to its original subclass type. This is potentially unsafe because the object might not actually be of the target subclass type. Therefore, downcasting must be done **explicitly**.

If you attempt an incorrect downcast, Java will throw a `ClassCastException` at runtime.


```java=
Parent parent = new Child(); // Upcasting

// To safely downcast, first check the object's type with 'instanceof'
if (parent instanceof Child) {
    Child child = (Child) parent; // Explicit downcasting
    child.childSpecificMethod(); // Now you can access Child-specific methods
}
```

---

## **Access Modifiers**

**Access modifiers** are keywords that set the accessibility or scope of a class, constructor, variable, or method. They are a crucial part of **encapsulation**, as they protect data from unauthorized access.

### **Types of Access Modifiers**

Java has four access modifiers:

1. **`public`**: The member is accessible from anywhere, both inside and outside the package. This is the least restrictive modifier.
2. **`protected`**: The member is accessible within its own package and by subclasses in other packages.
3. **`default` (no keyword)**: If you don't specify a modifier, it's `default`. The member is accessible only within its own package. It cannot be accessed from outside the package, even by a subclass.
4. **`private`**: The member is accessible **only** within its own class. This is the most restrictive modifier and is commonly used for fields to enforce encapsulation.

#### **Summary of Access Levels**

|                 |                  |                    |                              |                             |
| --------------- | ---------------- | ------------------ | ---------------------------- | --------------------------- |
| **Modifier**    | **Within Class** | **Within Package** | **Subclass (different pkg)** | **Outside Package (World)** |
| **`public`**    | ✅                | ✅                  | ✅                            | ✅                           |
| **`protected`** | ✅                | ✅                  | ✅                            | ❌                           |
| **`default`**   | ✅                | ✅                  | ❌                            | ❌                           |
| **`private`**   | ✅                | ❌                  | ❌                            | ❌                           |

### **The `final` Keyword (Non-Access Modifier)**

While not an access modifier, the `final` keyword is often discussed alongside them. It is used to apply restrictions.

- **`final` variable**: Its value cannot be changed once assigned. It creates a **constant**.
    ```java=
    final double PI = 3.14159;
    ```
- **`final` method**: It **cannot be overridden** by a subclass.
- **`final` class**: It **cannot be extended** (inherited from). Classes like `String` and `Integer` are `final` for security and consistency reasons.