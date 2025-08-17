package BasicQuestions;

import java.util.Arrays;

public class ReverseString344 {

    public static  void reverseString(char[] s) {
       int  i = 0 , j =s.length-1;
       int mid = i +(j-i)/2;
       while (i<j){
           char c = s[i];
           s[i] = s[j];
           s[j]=c;
           i++;
           j--;
       }

    }
    public static void main(String[] args) {

        char[] s =  {'h','e','l','l','o'};
        reverseString(s);
        for (char c : s) {
            System.out.println(c);
        }
    }
}
