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
    // Subclasses are forced to provide their own implementation.
    abstract void start();
}
