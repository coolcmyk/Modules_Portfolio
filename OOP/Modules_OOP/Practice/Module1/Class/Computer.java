package Practice.Module1.Class;

public class Computer {
    // 1. Fields (Properties)
    private String brand;
    private int ramInGB;
    private boolean isPoweredOn;

    // 2. Constructor: Initializes a new Computer object
    public Computer(String brand, int ramInGB) {
        this.brand = brand;
        this.ramInGB = ramInGB;
        this.isPoweredOn = false;
    }

    // 3. Methods (Behaviors)
    public void powerOn() {
        if (!isPoweredOn) {
            isPoweredOn = true;
            System.out.println(this.brand + " is powering on...");
        } else {
            System.out.println(this.brand + " is already on.");
        }
    }

    public void shutDown() {
        if (isPoweredOn) {
            isPoweredOn = false;
            System.out.println(this.brand + " is shutting down.");
        } else {
            System.out.println(this.brand + " is already off.");
        }
    }

    public void displayInfo() {
        System.out.println("--- Computer Info ---");
        System.out.println("Brand: " + this.brand);
        System.out.println("RAM: " + this.ramInGB + "GB");
        System.out.println("Status: " + (isPoweredOn ? "On" : "Off"));
        System.out.println("---------------------");
    }

    public static void main(String[] args) {
        Computer myLaptop = new Computer("Dell", 16);
        Computer officePC = new Computer("HP", 8);

        myLaptop.displayInfo();
        myLaptop.powerOn();
        myLaptop.displayInfo();

        System.out.println();

        officePC.displayInfo();
        officePC.shutDown();
    }
}

