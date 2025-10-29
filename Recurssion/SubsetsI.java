package Recurssion;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of n integers. Return array of sum of all subsets of the array nums.



Output can be returned in any order.


Examples:
Input : nums = [2, 3]

Output : [0, 2, 3, 5]

Explanation :

When no elements is taken then Sum = 0.

When only 2 is taken then Sum = 2.

When only 3 is taken then Sum = 3.

When element 2 and 3 are taken then sum = 2+3 = 5.

Input : nums = [5, 2, 1]

Output : [0, 1, 2, 3, 5, 6, 7, 8]

Explanation :

When no elements is taken then Sum = 0.

When only 5 is taken then Sum = 5.

When only 2 is taken then Sum = 2.

When only 1 is taken then Sum = 1.

When element 2 and 1 are taken then sum = 2+1 = 3.

Input : nums = [1]
 */
public class SubsetsI {

    static List<Integer> result = new ArrayList<>();
    public static List<Integer> subsetSums(int[] nums) {
      result.clear();
      helper(0 , nums , 0);
      return  result;
    }


    static void helper(int index , int []nums , int currSum){
        if (index == nums.length){
            result.add(currSum);
            return;
        }

//        result.add(currSum);
        helper(index+1 , nums , currSum+nums[index]);

        helper(index+1 , nums , currSum);

    }

    public static void main(String[] args) {
        System.out.println(subsetSums(new int [] {2,3} ));
    }
}
