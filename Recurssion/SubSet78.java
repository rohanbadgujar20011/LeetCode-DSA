package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class SubSet78 {
    public static  List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        insertList(0, nums, new ArrayList<>(), result);
        return  result;

    }
    public static  void insertList(int i,int[] nums , List<Integer> tempList , List<List<Integer>> result){

        if(i == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }

        insertList(i+1,nums,tempList,result);
        tempList.add(nums[i]);
        insertList(i+1,nums,tempList,result);
        tempList.remove(tempList.size()-1);

    }


    public static void main(String[] args) {


        System.out.println(subsets(new int [] {1,2,3}));

    }
}
