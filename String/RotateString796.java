/*
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 */
package String;

import java.util.Arrays;

public class RotateString796 {
    public static  boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        Arrays.sort(s.toCharArray());
        System.out.println("Print : " + s);
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde" , "cdeab"));
    }
}
