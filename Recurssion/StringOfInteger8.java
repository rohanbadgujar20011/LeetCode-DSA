package Recurssion;

public class StringOfInteger8 {
    public static  int myAtoi(String s) {
        s=s.trim();
        if (s.isEmpty()){
            return 0;
        }
        int i=0;
        int n = s.length();
        int sign =1;
        if( s.charAt(i) =='+' || s.charAt(i) == '-'){
            sign = (s.charAt(i)=='+') ? 1: -1;
            i++;
        }

        long num = 0;
        while (i< n && Character.isDigit(s.charAt(i))){
            num=num * 10 + (s.charAt(i)-'0');

            if(num *sign > Integer.MAX_VALUE){
                return  Integer.MAX_VALUE ;
            }
            if (num *sign < Integer.MIN_VALUE){
                return Integer.MIN_VALUE * sign;
            }
            i++;
        }
        return (int) num * sign;

    }

    public static void main(String [] args) {

        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("    -042"));
        System.out.println(myAtoi("1337c0d3"));
        System.out.println(myAtoi("0-1"));
        System.out.println(myAtoi("words and 987"));
    }
}
