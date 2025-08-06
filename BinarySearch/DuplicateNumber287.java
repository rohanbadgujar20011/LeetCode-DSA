package BinarySearch;

import java.util.HashMap;
import java.util.Map;

public class DuplicateNumber287 {

    public static int findDuplicate(int[] nums) {
        Map<Integer ,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
         map.put(nums[i] , map.getOrDefault(nums[i],1)+1);
        }

        for (Map.Entry<Integer , Integer> entry :map.entrySet() ){
            if (entry.getValue() > 1){
                return  entry.getKey();
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{3,3,3,3}));
    }
}
