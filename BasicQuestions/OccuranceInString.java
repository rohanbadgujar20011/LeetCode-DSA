package BasicQuestions;

import java.util.HashMap;

public class OccuranceInString {
    public static void main(String[] args) {
        String s = "Rohanoa";

        HashMap <Character , Integer> hashMap = new HashMap<>();

        for (int i = 0 ; i < s.length() ; i++){
            hashMap.put(s.charAt(i) , hashMap.getOrDefault(s.charAt(i),0)+1);
        }
        System.out.println(hashMap);
    }
}
