package Recurssion;

import java.util.ArrayList;
import java.util.List;

/*
Count all subsequences with sum K


0

100
Easy

Given an array nums and an integer k.Return the number of non-empty subsequences of nums such that the sum of all elements in the subsequence is equal to k.


Examples:
Input : nums = [4, 9, 2, 5, 1] , k = 10

Output : 2

Explanation : The possible subsets with sum k are [9, 1] , [4, 5, 1].

Input : nums = [4, 2, 10, 5, 1, 3] , k = 5

Output : 3

Explanation : The possible subsets with sum k are [4, 1] , [2, 3] , [5].
 */
import java.util.*;

public class CountSubSeqHaveSum {

    static int count = 0;

    public static int countSubsequenceWithTargetSum(int[] nums, int k) {
        count = 0;
        countSeq(0, nums, 0, k);
        return count;
    }

    static void countSeq(int index, int[] nums, int currentSum, int k) {
        // base case — all elements processed
        if (index == nums.length) {
            if (currentSum == k) {
                count++;
            }
            return;
        }

        // take current element
        countSeq(index + 1, nums, currentSum + nums[index], k);

        // don't take current element
        countSeq(index + 1, nums, currentSum, k);
    }

    public static void main(String[] args) {
        System.out.println(countSubsequenceWithTargetSum(new int[]{4, 2, 10, 5, 1, 3}, 5));
    }
}
