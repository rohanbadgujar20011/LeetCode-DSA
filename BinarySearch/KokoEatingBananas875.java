package BinarySearch;

public class KokoEatingBananas875 {

    /**
     * Main driver function to test the code
     */
    public static void main(String[] args) {
        // Sample test case: Very large piles and large allowed hours
        System.out.println(minEatingSpeed(new int[] {805306368, 805306368, 805306368}, 1000000000));
        // Expected output: 1 (Because with 1 banana/hour, Koko can still finish in time)
    }

    /**
     * LOGIC:
     * We want to find the **minimum eating speed K** such that Koko can finish eating all banana piles within H hours.
     *
     * Approach:
     * - This is a classic **binary search on answer** problem.
     * - We know the minimum possible speed is 1 banana/hour.
     * - The maximum possible speed is the largest pile size (because Koko can eat one full pile per hour).
     * - For each speed `mid`, we simulate how many hours Koko would take.
     *   If hours needed <= h, then it's a valid speed, and we try to minimize it.
     *   Otherwise, we increase the speed.
     */

    // Binary Search function to find the minimum eating speed
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxElement(piles); // Max speed required is the largest pile

        // Binary search to find the smallest valid speed
        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid overflow
            int maxHours = maxHours(piles, mid); // Total hours needed at speed mid

            if (maxHours <= h) {
                // If Koko can finish in h hours or less, try a smaller speed
                high = mid - 1;
            } else {
                // Otherwise, she needs to eat faster
                low = mid + 1;
            }
        }

        // 'low' will point to the minimum valid speed when loop ends
        return low;
    }

    /**
     * This method simulates the total hours Koko needs to eat all piles at speed m.
     * For each pile:
     *   Time = ceil(pile / m) = (pile + m - 1) / m (to avoid using floating-point division)
     */
    public static int maxHours(int[] piles, int m) {
        int maxHours = 0;
        for (int i = 0; i < piles.length; i++) {
            maxHours += (piles[i] + m - 1) / m;
        }
        return maxHours;
    }

    /**
     * Helper method to find the largest pile in the array
     * This gives the upper bound for our binary search range.
     */
    public static int maxElement(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        return max;
    }
}
