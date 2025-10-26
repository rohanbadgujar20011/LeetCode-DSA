package Recurssion;

public class Pow50 {

    public static  double myPow(double x, int n) {
        if( x==0){
            return 0;
        }
        if( n==0){
            return 1;
        }
        else if(n <0){
            n=n*-1;
            return 1/ (x* myPow(x , n-1));
        }
        else if(n>0){
            return x* myPow(x,n-1);
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000,-2));
    }
}
