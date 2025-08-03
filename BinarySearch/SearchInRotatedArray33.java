package BinarySearch;

public class SearchInRotatedArray33 {

    // Function to search for a target in a rotated sorted array
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        // Binary search loop
        while (low <= high) {
            // Calculate mid index
            int mid = low + (high - low) / 2;

            // If target is found at mid
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[low] <= nums[mid]) {
                // If target lies in the sorted left half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Move search to left
                } else {
                    low = mid + 1;  // Move search to right
                }
            }

            // Else, the right half must be sorted
            else {
                // If target lies in the sorted right half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;  // Move search to right
                } else {
                    high = mid - 1; // Move search to left
                }
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        // Example test case
        // The array [1, 3] is sorted and not rotated. Target = 3 should be found at index 1.
        System.out.println(search(new int[] {1, 3}, 3));
    }
}