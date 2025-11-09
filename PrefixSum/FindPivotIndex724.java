/*
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.



Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
 */


package PrefixSum;

public class FindPivotIndex724 {
    public static  int pivotIndex(int[] nums) {

        int pivote =-1;
        int n = nums.length;
        int [] prefixSum = new  int [nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1 ; i < nums.length ; i++){
            prefixSum[i] = prefixSum [i-1] + nums[i];
        }

        for (int i = 0 ; i < nums.length ; i++){
            int left , right;
            if(i ==0){
                 left = 0;
                 right = prefixSum[n-1] - nums[i];
            }
            else if(i == n-1){
                left = prefixSum[i] - nums[i];
                right = 0;
            }
            else{
                left = prefixSum[i] - nums[i];
                right = prefixSum[n-1]-prefixSum[i];
            }

            if(left==right){
                pivote= i;
                break;
            }
        }
        return pivote;

    }

    public static void main(String[] args) {

        System.out.println(pivotIndex(new int []{2,1,-1}));

    }
}
