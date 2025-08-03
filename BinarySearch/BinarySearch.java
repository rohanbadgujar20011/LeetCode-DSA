package BinarySearch;

public class BinarySearch {

    // This method implements binary search on a sorted array
    public static int search(int[] nums, int target) {

        // Initialize the start (low) and end (high) pointers
        int low = 0, high = nums.length - 1;

        // Continue searching while the search range is valid
        while (low <= high) {
            // Find the middle index to avoid overflow
            int mid = low + (high - low) / 2;

            // If the mid element is the target, return the index
            if (nums[mid] == target) {
                return mid;
            }
            // If the target is smaller, search in the left half
            else if (target < nums[mid]) {
                high = mid - 1;
            }
            // If the target is larger, search in the right half
            else {
                low = mid + 1;
            }
        }

        // If not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        // Example usage: Search for 3 in a sorted array
        // Output should be the index of 3, which is 2
        System.out.println(search(new int[] {-1, 0, 3, 5, 9, 12}, 3));
    }
}
