/*
Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.



Example 1:

Input: s = "(1+(2*3)+((8)/4))+1"

Output: 3

Explanation:

Digit 8 is inside of 3 nested parentheses in the string.
 */

package String;

import java.util.Stack;

public class MaximumNestingDepth1614 {


    public static int maxDepth(String s) {
        Stack<Character> countPar = new Stack<>();
        int maxDepthCount = 0 ;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                countPar.add('(');
                maxDepthCount = Math.max(maxDepthCount , countPar.size());
            } else if (s.charAt(i) == ')'){
                countPar.pop();
            }
        }
        return  maxDepthCount;

    }


    public static void main(String[] args) {
        System.out.println(maxDepth("()(())((()()))"));

    }
}
