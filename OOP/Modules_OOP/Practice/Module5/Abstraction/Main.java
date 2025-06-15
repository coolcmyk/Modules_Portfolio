package Practice.Module5.Abstraction;

public class Main {
    public static void main(String[] args) {
        // We can create objects of the concrete subclasses.
        Vehicle myCar = new Car("Toyota");
        Vehicle myScooter = new ElectricScooter("Xiaomi");

        // The correct 'start()' method is called for each object at runtime.
        myCar.start();
        myScooter.start();

        System.out.println("---");

        // We can still use the methods from the abstract superclass.
        System.out.println("Original car brand: " + myCar.getBrand());
        myCar.setBrand("Honda");
        System.out.println("New car brand: " + myCar.getBrand());
    }
}
