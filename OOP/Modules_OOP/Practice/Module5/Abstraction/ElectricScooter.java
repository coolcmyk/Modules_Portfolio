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
