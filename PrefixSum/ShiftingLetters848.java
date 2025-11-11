/*
You are given a string s of lowercase English letters and an integer array shifts of the same length.

Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.

Return the final string after all such shifts to s are applied.



Example 1:

Input: s = "abc", shifts = [3,5,9]
Output: "rpl"
Explanation: We start with "abc".
After shifting the first 1 letters of s by 3, we have "dbc".
After shifting the first 2 letters of s by 5, we have "igc".
After shifting the first 3 letters of s by 9, we have "rpl", the answer.
 */


package PrefixSum;

public class ShiftingLetters848 {

    public static String shiftingLetters(String s, int[] shifts) {
        StringBuilder result = new StringBuilder();
        int n =shifts.length;
        int initialSum=0;
        int [] newShift = new int[n];
        for(int i = n-1 ; i>=0;i--){
            initialSum += shifts[i];
            initialSum%=26;
            if (122-s.charAt(i) < initialSum){
                System.out.println(initialSum - (122-s.charAt(i)));
                result.append((char)(97 + (initialSum - (122-s.charAt(i)))-1));
            }
            else {
                result.append((char) (s.charAt(i) + initialSum));
            }

        }

        return  result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(shiftingLetters("abc" , new int[]{3,5,9}) );
    }


}
