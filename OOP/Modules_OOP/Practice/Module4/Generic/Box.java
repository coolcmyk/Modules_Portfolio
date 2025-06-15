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
