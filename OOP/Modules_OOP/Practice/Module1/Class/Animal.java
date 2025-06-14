package Practice.Module1.Class;

public class Animal {
    private int age;
    private String fullName; 

    public Animal(int age, String fullName){
        this.age = age;
        this.fullName = fullName;
    }

    public void displayString(){
        System.out.println(this.fullName);
        System.out.println(this.age);
    }

    public static void main(String[] args) {
       Animal animalExample = new Animal(19, "Lion");
       animalExample.displayString();
    }
}
