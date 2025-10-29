package Recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

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
