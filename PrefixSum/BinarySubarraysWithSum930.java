package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum930 {

    public static int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer ,Integer> prefixCount = new HashMap<>();
        prefixCount.put(0,1);
        int n =nums.length;
        int sum =0;
        int count=0;
        for (int num:nums) {
            sum += num;


            if (prefixCount.containsKey(sum - goal)) {
                count += prefixCount.get(sum - goal);
            }

            // Store/update prefix sum frequency
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,0} , 0));
    }
}
