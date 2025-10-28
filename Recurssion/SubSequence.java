package Recurssion;

/*
🧩 Problem Statement: Generate All Subsequences of a String
🔹 Problem Description

Given a string S, your task is to generate and print all possible subsequences of the given string.
A subsequence is a sequence that can be derived from the original string by deleting zero or more characters without changing the order of the remaining characters.

Input:
S = "abc"
Output:
[abc, ab, ac, a, bc, b, c, ""]
(The empty string "" is also considered a valid subsequence.)
 */

import java.util.ArrayList;
import java.util.List;

public class SubSequence {

    static List<String> result = new ArrayList<>();

    static void printAllSubSequence(String s , String ans){
        if(s.length() == 0){
            result.add(ans);
            return;
        }

        printAllSubSequence(s.substring(1) , ans +s.charAt(0));
        printAllSubSequence(s.substring(1) , ans );

    }

    public static void main(String[] args) {
        printAllSubSequence("abc" , "");
        System.out.println(result);

    }

}
