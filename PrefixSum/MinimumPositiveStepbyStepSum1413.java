/*
Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1.



Example 1:

Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
step by step sum
startValue = 4 | startValue = 5 | nums
  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
 */


package PrefixSum;

public class MinimumPositiveStepbyStepSum1413 {
    public static int minStartValue(int[] nums) {
        int n = nums.length;
        int [] preFix = new int[n];
        int minValue = 1;

        for(int i = 0 ; i < n ;i++){
            if(i==0){
                preFix[i] = nums[i] + minValue;
            }
            else{
                preFix[i] = preFix[i-1] + nums[i];
            }

            if(preFix[i] < 1){
                int toIncrease = 1 - preFix[i];
                preFix[i] += toIncrease;
                minValue += toIncrease;

            }
        }
        return minValue;

    }

    public static void main(String[] args) {

        System.out.println(minStartValue(new int[]{-3,2,-3,4,2}));
    }
}
