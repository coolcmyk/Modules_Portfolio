
---

## **Generic Types and Collections in Java**

Generics and Collections are essential features of the Java programming language that provide powerful tools for creating flexible, type-safe, and efficient data structures.

---

## **Generic Types** 

### **What Are Generic Types?**

**Generics** are a feature that allows classes, interfaces, and methods to be parameterized over types. In simple terms, they let you create a single class or method that can work with different data types while providing compile-time **type safety**. Instead of specifying a concrete type like `String` or `Integer`, you use a placeholder, such as `<T>` or `<E>`.

### **Why Use Generics?**

* **Type Safety:** Generics prevent you from accidentally putting the wrong type of object into a structure. The compiler catches these errors, rather than letting them cause a crash at runtime.
* **Reusability:** You can write a class or method once and use it for many different types without rewriting the code.
* **Code Readability:** Generics make your code clearer by explicitly stating the type of data a structure is designed to hold (e.g., `List<String>` is clearly a list of strings).
* **Elimination of Casts:** Before generics, you had to manually cast objects retrieved from collections. Generics make this unnecessary, resulting in cleaner code.

### **How to Use Generics**

You define a generic type using angle brackets (`<>`) with a type parameter inside (e.g., `<T>`). When you create an object of a generic class, you specify the concrete type you want to use (e.g., `Box<Integer>`).

#### **Generic Class Example**

Here is a `Box` class that can hold an object of any type.

```java
package Practice.Module4.Generic;  
  
// The <T> is a type parameter that will be replaced by a real type.  
public class Box<T> {  
    private T value; // The type of 'value' is T  
  
    public Box(T value) {  
        this.value = value;  
    }  
  
    public T getValue() {  
        return value;  
    }  
  
    public void setValue(T value) {  
        this.value = value;  
    }  
  
    public static void main(String[] args) {  
        // Create a Box for Integers  
        Box<Integer> integerBox = new Box<>(10);  
        System.out.println("Integer Value: " + integerBox.getValue());  
  
        // Create a Box for Strings  
        Box<String> stringBox = new Box<>("Hello World");  
        System.out.println("String Value: " + stringBox.getValue());  
    }  
}
```

#### **Generic Method Example**

You can also create methods that accept a generic type.

```java
package Practice.Module4.Generic;  
  
public class GenericMethodTest {  
    // A generic method uses a type parameter before the return type.  
    public static <E> void printArray(E[] inputArray) {  
        for (E element : inputArray) {  
            System.out.printf("%s ", element);  
        }  
        System.out.println();  
    }  
  
    public static void main(String[] args) {  
        // Create arrays of different wrapper types  
        Integer[] intArray = { 1, 2, 3, 4, 5 };  
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };  
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };  
  
        System.out.println("Integer Array contains:");  
        printArray(intArray); // The compiler infers that E is Integer  
  
        System.out.println("\nDouble Array contains:");  
        printArray(doubleArray); // The compiler infers that E is Double  
  
        System.out.println("\nCharacter Array contains:");  
        printArray(charArray); // The compiler infers that E is Character  
    }  
}
```

---

## **The Collections Framework** 

### **What Is a Collection?**

The **Java Collections Framework** is a unified architecture for representing and manipulating groups of objects. It provides a set of interfaces and classes that allow you to create various data structures like lists, sets, and maps.

All collection classes are located in the `java.util` package.

### **Core Collection Interfaces**

There are three main interfaces at the core of the framework:

#### **1. List**

A **`List`** is an **ordered** collection of elements that allows **duplicates**. You can access elements by their integer index (position).

* **Common Implementation: `ArrayList`**
    An `ArrayList` is a resizable array. It's great for storing and accessing data but can be slower for insertions and deletions in the middle of the list.

**`List` Example:**
```java
package Practice.Module4.Collection;  
  
import java.util.ArrayList;  
import java.util.List;  
  
public class ListExample {  
    public static void main(String[] args) {  
        // Create a List of Strings using ArrayList  
        List<String> names = new ArrayList<>();  
        names.add("Kamal");  
        names.add("Emir");  
        names.add("Fairuz");  
  
        System.out.println("Names in the list:");  
        for (String name : names) {  
            System.out.println(name);  
        }  
    }  
}
```

#### **2. Set**

A **`Set`** is a collection that contains **no duplicate** elements. It makes no guarantees about the order of its elements. It's useful when you only care about whether an object is present or not.

* **Common Implementation: `HashSet`**
    A `HashSet` stores its elements in a hash table. It offers very fast performance for adding, removing, and checking for elements.

**`Set` Example:**
```java
package Practice.Module4.Collection;  
  
import java.util.HashSet;  
import java.util.Set;  
  
public class SetExample {  
    public static void main(String[] args) {  
        // Create a Set of Strings using HashSet  
        Set<String> uniqueNames = new HashSet<>();  
        uniqueNames.add("Kamal");  
        uniqueNames.add("Emir");  
        uniqueNames.add("Fairuz");  
        uniqueNames.add("Kamal"); // This duplicate will be ignored  
  
        System.out.println("Unique names in the set:");  
        for (String name : uniqueNames) {  
            System.out.println(name);  
        }  
        System.out.println("Size of set: " + uniqueNames.size()); // Will be 3  
    }  
}
```

#### **3. Map**

A **`Map`** is an object that maps **keys** to **values**. Keys must be unique, but values can be duplicated. It's like a dictionary where you look up a value using a specific key.

* **Common Implementation: `HashMap`**
    A `HashMap` uses a hash table to store its key-value pairs, providing fast retrieval of values when you know the key.

**`Map` Example:**
```java
package Practice.Module4.Collection;  
  
import java.util.HashMap;  
import java.util.Map;  
  
public class MapExample {  
    public static void main(String[] args) {  
        // Create a Map with String keys and Integer values  
        Map<String, Integer> scores = new HashMap<>();  
        scores.put("Kamal", 100);  
        scores.put("Emir", 90);  
        scores.put("Fairuz", 80);  
  
        System.out.println("Student scores:");  
        // Iterate over the keys to get the values  
        for (String name : scores.keySet()) {  
            int score = scores.get(name);  
            System.out.println(name + ": " + score);  
        }  
    }  
}
```