/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */

package Recurssion;

import java.util.*;

public class LetterCombinations17 {

    static Map<Character, String> mapper = new HashMap<>();
    static List<String> result = new ArrayList<>();

    static {
        mapper.put('2', "abc");
        mapper.put('3', "def");
        mapper.put('4', "ghi");
        mapper.put('5', "jkl");
        mapper.put('6', "mno");
        mapper.put('7', "pqrs");
        mapper.put('8', "tuv");
        mapper.put('9', "wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        result.clear(); // reset
        if (digits == null || digits.isEmpty()) return result;
        backTrack(digits, 0, new StringBuilder());
        return result;
    }

    static void backTrack(String digits, int index, StringBuilder tempString) {
        if (index == digits.length()) {
            result.add(tempString.toString());
            return;
        }

        String letters = mapper.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            tempString.append(c);
            backTrack(digits, index + 1, tempString);
            tempString.deleteCharAt(tempString.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
}
