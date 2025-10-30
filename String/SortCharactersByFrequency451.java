/*
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.



Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */
package String;

import java.util.*;


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
