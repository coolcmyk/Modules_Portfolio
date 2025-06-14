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
