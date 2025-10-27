package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {

    static void generate(int n , int leftCount , int rightCount,String curr , List<String> result){

        if (rightCount > leftCount){
            return;
        }

        if(leftCount==n && rightCount==n){
            result.add(curr);
            return;
        }

        if (leftCount < n){
            generate(n,leftCount +1,rightCount,curr+"(",result);
        }
        if (rightCount < n) {
            generate(n,leftCount,rightCount+1,curr+")",result);

        }


    }

    public static  List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        generate(n,0,0,"",result);
        return  result;
    }


    public static void main(String[] args) {

        generateParenthesis(1).forEach(System.out::println);
    }
}
