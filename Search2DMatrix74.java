public class Search2DMatrix74 {
    public static  boolean searchMatrix(int[][] matrix, int target) {
        // Get total number of rows and columns
        int rowCount = matrix.length;
        int coloumnCount = matrix[0].length;

        // We treat the 2D matrix as a single 1D sorted array
        // So the first element is at index 0
        // The last element is at index (rowCount * coloumnCount) - 1
        int low = 0;
        int high = rowCount * coloumnCount - 1;

        // Perform binary search on this virtual 1D array
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Convert the 1D index 'mid' back to 2D coordinates:
            // row = mid / number of columns
            // col = mid % number of columns
            int midValue = matrix[mid / coloumnCount][mid % coloumnCount];

            // Check if the middle value matches the target
            if (midValue == target) {
                return true; // Target found
            }
            // If target is less, move to the left half
            else if (target < midValue) {
                high = mid - 1;
            }
            // If target is greater, move to the right half
            else {
                low = mid + 1;
            }
        }

        // If we exit the loop, the target was not found
        return false;
    }

    public static void main(String[] args) {

        System.out.println(searchMatrix(new int[][] {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        },20));

    }
}
