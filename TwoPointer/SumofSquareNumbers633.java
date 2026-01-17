package TwoPointer;

public class SumofSquareNumbers633 {
    public static boolean judgeSquareSum(int c) {

        if(c==0||c==1){
            return false;
        }

        int left =1;
        int right = findRight(c);
        System.out.println(right);

        while(left < right){
            if((left*left + right * right)==c){
                return true;
            }
            else if ((left*left + right * right) < c){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }

    static int findRight(int c){
        int left=1;
        int right =c;
        while(left < right){
            int mid = left +(right-left)/2;
            if(mid *mid < c){
                left=mid;
            }
            else{
                right=mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
    }
}
