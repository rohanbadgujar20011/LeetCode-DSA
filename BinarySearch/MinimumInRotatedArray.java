package BinarySearch;

//Find Minimum in Rotated Sorted Array
public class MinimumInRotatedArray {

    public static int findMin(int[] nums) {

        // Initialize pointers to the start and end of the array
        int low = 0, high = nums.length - 1;

        // Perform binary search while the search space has more than one element
        while (low < high) {

            // Calculate the middle index
            int mid = low + (high - low) / 2;

            // If the subarray between low and high is already sorted,
            // then the smallest element is at the low index
            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            // If the left half (from low to mid) is sorted,
            // then the minimum must be in the right half
            else if (nums[low] <= nums[mid]) {
                low = mid + 1; // search in the right half
            }

            // Otherwise, the minimum is in the left half including mid
            else {
                high = mid; // search in the left half
            }
        }

        // When low == high, we've found the minimum element
        return nums[low];
    }



    public static void main(String[] args) {

        System.out.println(findMin(new  int [] {3,4,5,1,2}));

    }
}
