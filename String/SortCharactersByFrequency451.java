package String;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharactersByFrequency451 {

    public static  String frequencySort(String s) {
        Map<Character ,Integer> characterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            characterMap.put(s.charAt(i) , characterMap.getOrDefault(s.charAt(i) , 0) +1);
        }

        PriorityQueue<Map.Entry<Character ,Integer>> maxHeap =
                new PriorityQueue<>((a,b) ->b.getValue() - a.getValue());

        maxHeap.addAll(characterMap.entrySet());

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()){
            Map.Entry<Character , Integer > entry = maxHeap.poll();
            char ch = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }
        return result.toString();

    }


    public static void main(String[] args) {
        System.out.println(frequencySort("Atree"));
    }


}
