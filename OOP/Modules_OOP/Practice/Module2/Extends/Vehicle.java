package Practice.Module2.Extends;

// Superclass
class Vehicle {
    void drive() {
        System.out.println("This vehicle is moving...");
    }
}

// Subclass
// The 'Car' class now has access to the drive() method.
class Car extends Vehicle {
    void honk() {
        System.out.println("Beep beep!");
    }
}

// Main class to test the inheritance
class Main {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.drive(); 
        myCar.honk(); 
    }
}
