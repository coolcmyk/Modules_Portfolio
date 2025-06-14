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