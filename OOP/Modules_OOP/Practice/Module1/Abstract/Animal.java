package Practice.Module1.Abstract;

abstract class Animal {
    private String name;

    public Animal(String name) { // Constructor
        this.name = name;
    }

    // Abstract method - must be implemented by subclasses
    public abstract void makeSound();

    // Concrete method - inherited by all subclasses
    public void sleep() {
        System.out.println(this.name + " is sleeping... Zzz");
    }

    public String getName() {
        return this.name;
    }
}

