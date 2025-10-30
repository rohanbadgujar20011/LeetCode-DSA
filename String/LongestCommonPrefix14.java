package String;

public class LongestCommonPrefix14 {

    public static String longestCommonPrefix(String[] strs) {
        String prefix=strs[0];
        for (int i = 1; i <strs.length ; i++) {
            if (strs[i].length()==0) return "";
            int index = 0;
            while ((index < strs[i].length() && index < prefix.length()) && prefix.charAt(index)==strs[i].charAt(index) ){
                index++;
            }
            prefix=strs[i].substring(0,index);
        }
        return  prefix;

    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String [] {"dog","racecar","car"}));
    }
}
