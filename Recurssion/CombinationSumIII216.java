/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.



Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
 */

package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        result.clear();
        int [] nums = {1,2,3,4,5,6,7,8,9};
        backTrack(nums,0,k,n,0,new ArrayList<>());
        return  result;
    }

    static  void backTrack(int [] nums , int index,int k , int n ,int curSum, List<Integer> currList){

        if(currList.size() == k ){
            if (curSum == n){
                result.add(new ArrayList<>(currList));
            }
            return;
        }
        if (index == nums.length){
            return;
        }
        if (currList.size() > k || curSum > n ){
            return;
        }
        currList.add(nums[index]);
        backTrack(nums,index+1,k,n,curSum+nums[index] , currList);
        currList.remove(currList.size()-1);
        backTrack(nums , index+1 , k,n,curSum , currList);
    }

    public static void main(String[] args) {
        System.out.println( combinationSum3(4,1));
    }


}
