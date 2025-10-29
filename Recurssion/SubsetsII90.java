/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */

package Recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII90 {

    static  List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        result.clear();
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>());
        return  result;

    }

    static  void  backtrack(int [] nums , int index , List <Integer> currList ){

        result.add(new ArrayList<>(currList));

        for (int i = index; i <nums.length ; i++) {
            if (i > index && nums[i] == nums[i-1]) continue;
            currList.add(nums[i]);
            backtrack(nums,i+1,currList);
            currList.remove(currList.size()-1);
//            backtrack(nums,i+1,currList);
        }


    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }
}
