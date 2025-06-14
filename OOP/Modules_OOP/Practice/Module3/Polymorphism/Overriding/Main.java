package Practice.Module3.Polymorphism.Overriding;

// Superclass
class Animal {
    public void makeSound() {
        System.out.println("The animal makes a sound.");
    }
}

// Subclass
class Dog extends Animal {
    // This method overrides the one in the Animal class
    @Override
    public void makeSound() {
        System.out.println("The dog barks: Woof! Woof!");
    }
}

// Another subclass
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The cat meows: Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog(); // Polymorphism: Dog object treated as an Animal
        Animal myCat = new Cat(); // Polymorphism: Cat object treated as an Animal

        myAnimal.makeSound(); // Executes Animal's method
        myDog.makeSound();    // Executes Dog's overridden method
        myCat.makeSound();    // Executes Cat's overridden method
    }
}