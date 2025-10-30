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
