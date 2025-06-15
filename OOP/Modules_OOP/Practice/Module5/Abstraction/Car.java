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
