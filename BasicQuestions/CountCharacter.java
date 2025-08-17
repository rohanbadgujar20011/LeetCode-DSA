package BasicQuestions;


//Count the chacter in Given String
public class CountCharacter {
    public static int countCharacter(String s , char c) {
//
//        //TODO:Approach 1 without in build function;
//        int count = 0;
//        for (char a : s.toCharArray()) {
//            if (a == c)
//                count++;
//
//        }
//        return count;

        //TODO:Approcah 2
        return (int) s.chars().filter(i->i==c).count();
    }

    public static void main(String[] args) {
        System.out.println(countCharacter("programming",'m'));
    }
}
