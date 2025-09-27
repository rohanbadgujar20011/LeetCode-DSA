package BasicQuestions;

public class SecondLargerst {

    public static  int getSecondHigest(int [] array){

        int higest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0 ; i < array.length ; i++){
            if(array[i]  > higest){
                second = higest;
              higest = array[i];
            }else if(array[i] > second && array[i] != higest){
                second = array[i];
            }

        }
        return second;

    }

    public static void main(String[] args) {
        int [] array = {4,5,2,7,9};
        System.out.println(getSecondHigest(array));

    }
}
