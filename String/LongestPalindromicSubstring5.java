package String;

public class LongestPalindromicSubstring5 {

    public static  String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;

        int start = 0, maxLen = 1;

        for(int i = 0; i < n; i++){
            // Odd length palindrome (like "racecar")
            int len1 = expand(s, i, i);

            // Even length palindrome (like "abba")
            int len2 = expand(s, i, i+1);

            int len = Math.max(len1, len2);

            if(len > maxLen){
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private static int expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome found
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("cbbd"));
    }
}
