package Practice.Module4.Collection;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        // Create a Set of Strings using HashSet
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.add("Kamal");
        uniqueNames.add("Emir");
        uniqueNames.add("Fairuz");
        uniqueNames.add("Kamal"); // This duplicate will be ignored

        System.out.println("Unique names in the set:");
        for (String name : uniqueNames) {
            System.out.println(name);
        }
        System.out.println("Size of set: " + uniqueNames.size()); // Will be 3
    }
}
