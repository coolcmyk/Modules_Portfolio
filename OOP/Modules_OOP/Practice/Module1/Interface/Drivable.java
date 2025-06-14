package Practice.Module1.Interface;

// Drivable.java (Interface)
public interface Drivable {
    void turnOn();      // Abstract method
    void accelerate();  // Abstract method
    void brake();       // Abstract method
}

class Car implements Drivable {
    @Override
    public void turnOn() {
        System.out.println("Car engine starts.");
    }
    @Override
    public void accelerate() {
        System.out.println("Car is speeding up.");
    }
    @Override
    public void brake() {
        System.out.println("Car is slowing down.");
    }
}

class Bicycle implements Drivable {
    @Override
    public void turnOn() {
        System.out.println("Bicycle is ready to go (no engine).");
    }
    @Override
    public void accelerate() {
        System.out.println("Pedaling faster.");
    }
    @Override
    public void brake() {
        System.out.println("Squeezing hand brakes.");
    }
}

class DrivableImplementation {
    public static void main(String[] args) {
        Car newCar = new Car();
        newCar.turnOn();

        Bicycle newBike = new Bicycle();
        newBike.turnOn();
    }
}