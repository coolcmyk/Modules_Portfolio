package Practice.Module4.Collection;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // Create a List of Strings using ArrayList
        List<String> names = new ArrayList<>();
        names.add("Kamal");
        names.add("Emir");
        names.add("Fairuz");

        System.out.println("Names in the list:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
