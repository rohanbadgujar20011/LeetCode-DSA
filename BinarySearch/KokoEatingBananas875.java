package BinarySearch;

public class KokoEatingBananas875 {

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxElement(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxHours = maxHours(piles, mid);

            if (maxHours <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;

    }

    public static int maxHours(int [] piles , int m ){
        int maxHours=0;
        for (int i = 0; i < piles.length; i++) {
            maxHours +=(piles[i] + m - 1) / m;
        }
        return maxHours;
    }

    public static int maxElement(int[] piles){
        int max =Integer.MIN_VALUE;
        for (int i = 0; i <piles.length ; i++) {
            if(piles[i] > max){
                max=piles[i];
            }

        }
        return  max;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new  int [] {805306368,805306368,805306368},1000000000));
    }
}
