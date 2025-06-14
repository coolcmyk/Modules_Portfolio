package Practice.Module2.Overriding;

class Character {
    void useAbility() {
        System.out.println("Using a generic ability.");
    }
}

class Mage extends Character {
    @Override // Best practice!
    void useAbility() {
        System.out.println("Casting a fireball! 🔥");
    }
}

class CharacterMain {
    public static void main(String[] args) {
        //comparison between original Character class and extended class Mage

        Character originalChar = new Character();
        originalChar.useAbility();

        
        Mage newMage = new Mage();
        newMage.useAbility();
    }
}