/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:

Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */


package PreFix;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray525 {
    public static int findMaxLength(int[] nums) {
        int maxLength=0;
        Map<Integer,Integer> mapper = new HashMap<>();
        mapper.put(0,-1);
        int [] prefixSum = new  int[nums.length];
        prefixSum[0] = nums[0] == 0 ? -1 : 1;
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i]==0){
                prefixSum[i]=prefixSum[i-1]+-1;
            }
            else {
                prefixSum[i]=prefixSum[i-1]+1;
            }

        }

        for(int num = 0 ; num < prefixSum.length ; num++){
           if(mapper.containsKey(prefixSum[num])){
               maxLength = Math.max(maxLength ,num-mapper.get(prefixSum[num]));
           }
           else {
               mapper.put(prefixSum[num] , num);
           }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int [] {0,1,1,1,1,1,0,0,0}));
    }
}
