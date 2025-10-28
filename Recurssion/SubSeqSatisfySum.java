package Recurssion;

import java.util.*;
/*
You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.



Example 1:

Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
[3] -> Min value + max value <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
[3,5,6] -> (3 + 6 <= 9)
[3,6] -> (3 + 6 <= 9)
Example 2:

Input: nums = [3,3,6,8], target = 10
Output: 6
Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
Example 3:

Input: nums = [2,3,3,4,6,7], target = 12
Output: 61
Explanation: There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]).
Number of valid subsequences (63 - 2 = 61).


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 106
1 <= target <= 106
 */
public class SubSeqSatisfySum {

    static final int MOD = 1_000_000_007;

    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        // Precompute powers of 2 (to avoid recomputation)
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1;
        long result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // nums[left] can pair with any subset of elements between left and right
                result = (result + pow2[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(numSubseq(new int[]{3, 5, 6, 7}, 9));  // Output: 4
        System.out.println(numSubseq(new int[]{3, 3, 6, 8}, 10)); // Output: 6
        System.out.println(numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12)); // Output: 61
    }
}
