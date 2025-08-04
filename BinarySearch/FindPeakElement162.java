package BinarySearch;

public class FindPeakElement162 {

    public static int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // We're on a descending slope → peak is on the left
                high = mid;
            } else {
                // We're on an ascending slope → peak is on the right
                low = mid + 1;
            }
        }

        return low; // or return high — both are same now
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] {1,2,1,3,5,6,4}));

    }
}
