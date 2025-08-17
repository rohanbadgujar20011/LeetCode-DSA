package BasicQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    // 🔹 Approach 1: Using HashSet
    public static String removeDuplicatesHashSet(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seen.add(c)) {   // add returns false if already present
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // 🔹 Approach 2: Using Streams
    public static String removeDuplicatesStream(String s) {
        return s.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .distinct()
                .collect(Collectors.joining());
    }

    // 🔹 Approach 3: Using LinkedHashSet
    public static String removeDuplicatesLinkedHashSet(String s) {
        Set<Character> set = new LinkedHashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : set) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "programming";

        System.out.println("Input: " + input);
        System.out.println("HashSet approach: " + removeDuplicatesHashSet(input));
        System.out.println("Streams approach: " + removeDuplicatesStream(input));
        System.out.println("LinkedHashSet approach: " + removeDuplicatesLinkedHashSet(input));
    }
}
