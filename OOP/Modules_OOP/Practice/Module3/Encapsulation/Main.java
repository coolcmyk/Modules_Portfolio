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