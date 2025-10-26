package String;

import java.util.ArrayList;

public class ReverseWords {

    public static  String reverseWords(String s) {
        s = s.trim();


        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder word  = new StringBuilder();

        for (int i = 0; i <s.length() ; i++) {

            if (s.charAt(i) != ' '){
                word.append(s.charAt(i));
            }
            else {
                if (word.length() > 0){
                    arrayList.add(word.toString());
                    word.setLength(0);
                }
            }
        }

        if (word.length() > 0){
            arrayList.add(word.toString());
        }

        StringBuilder result = new StringBuilder();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            result.append(arrayList.get(i));
            if (i != 0) result.append(" ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println((reverseWords("  hello world  ")));
    }
}
