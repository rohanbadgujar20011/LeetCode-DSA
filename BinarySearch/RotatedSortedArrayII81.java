package BinarySearch;

public class RotatedSortedArrayII81 {

    public static boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        // Perform binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If target is found at mid
            if (nums[mid] == target) {
                return true;
            }

            // If duplicates block the decision of which side is sorted
            if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                low++;
                high--;
            }

            // If left side is uncertain due to same values at low and mid
            else if (nums[mid] == nums[low]) {
                low++;
            }

            // If right side is uncertain due to same values at mid and high
            else if (nums[mid] == nums[high]) {
                high--;
            }

            // If left half is sorted
            else if (nums[low] <= nums[mid]) {
                // If target lies within the sorted left half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Move search to left half
                } else {
                    low = mid + 1;  // Move search to right half
                }
            }

            // If right half is sorted
            else {
                // If target lies within the sorted right half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;  // Move search to right half
                } else {
                    high = mid - 1; // Move search to left half
                }
            }
        }

        // If target not found
        return false;
    }

    public static void main(String[] args) {
        // Test case: Should print true
        System.out.println(search(new int[] {1, 1, 1, 0, 1}, 0));
    }
}
