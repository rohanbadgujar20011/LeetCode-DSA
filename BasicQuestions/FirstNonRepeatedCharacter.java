package BasicQuestions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {

    // Approach 1: Classic LinkedHashMap
    public static char firstNonRepeatedCharacterClassic(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '_'; // default if no non-repeated character
    }

    // Approach 2: Stream-based
    public static char firstNonRepeatedCharacterStream(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('_'); // default if no non-repeated character
    }

    public static void main(String[] args) {
        String input = "swiss";

        System.out.println("Input: " + input);
        System.out.println("Classic approach: " + firstNonRepeatedCharacterClassic(input));
        System.out.println("Stream approach: " + firstNonRepeatedCharacterStream(input));
    }
}
