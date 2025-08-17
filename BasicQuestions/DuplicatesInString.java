package BasicQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// Find the Duplicate in the String
public class DuplicatesInString {

    public static void duplicatedInString(String s) {

        // ✅ Approach 1: Using HashMap
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println("Approach 1:");
        map.forEach((k, v) -> {
            if (v > 1) {
                System.out.println(k + " : " + v);
            }
        });

        // ✅ Approach 2: Using Streams
        System.out.println("\nApproach 2:");
        s.chars()
                .mapToObj(c -> (char) c)  // convert int -> char
                .collect(Collectors.groupingBy(
                        Function.identity(),    // group by character
                        LinkedHashMap::new,     // preserve order
                        Collectors.counting()   // count frequency
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // keep only duplicates
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }

    public static void main(String[] args) {
        duplicatedInString("programming");
    }
}
