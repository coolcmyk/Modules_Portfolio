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
