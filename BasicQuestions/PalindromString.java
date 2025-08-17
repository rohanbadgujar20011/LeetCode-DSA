package BasicQuestions;

public class PalindromString {

    public static boolean isPalindrom(String s){

        return s.equals(new StringBuilder(s).reverse().toString());

    }
    public static void main(String[] args) {

        System.out.println(isPalindrom("mada"));

    }
}
