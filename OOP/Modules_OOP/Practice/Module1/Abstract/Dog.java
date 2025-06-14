package Practice.Module1.Abstract;

class Dog extends Animal {
    public Dog(String name) {
        super(name); //Calls Parent Constructor
    }
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof!");
    }
}

class DoggoCaller {
    public static void main(String[] args) {
        Dog newDog = new Dog("woofie");
        newDog.makeSound();
        newDog.sleep();
    }
}