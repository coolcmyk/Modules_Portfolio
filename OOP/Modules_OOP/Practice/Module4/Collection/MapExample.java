package Practice.Module4.Collection;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // Create a Map with String keys and Integer values
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Kamal", 100);
        scores.put("Emir", 90);
        scores.put("Fairuz", 80);

        System.out.println("Student scores:");
        // Iterate over the keys to get the values
        for (String name : scores.keySet()) {
            int score = scores.get(name);
            System.out.println(name + ": " + score);
        }
    }
}
