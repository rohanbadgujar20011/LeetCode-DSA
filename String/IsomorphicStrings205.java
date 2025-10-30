
/*

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
 */
package String;


import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205 {

    public static  boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return  false;
        Map<Character ,Character> characterMap = new HashMap<>();
        int i=0;
        while (i<s.length()){
            if (characterMap.containsKey(s.charAt(i))){
                if(t.charAt(i) != characterMap.get(s.charAt(i))){
                    return false;
                }
            }
            else {
                if (characterMap.containsValue(t.charAt(i))) return false;
                else {
                    characterMap.put(s.charAt(i), t.charAt(i));
                }
            }
            i++;
        }
        return true;


    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc" , "baba"));
    }
}
