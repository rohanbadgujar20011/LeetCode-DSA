package Recurssion;

import java.util.Stack;

public class ReverseStack {

    public static  void reverseStack(Stack<Integer> st) {

        if(st.isEmpty()){
            return;

        }
        int peek = st.pop();
        reverseStack(st);
        insertElements(st,peek);

    }

    public static void insertElements(Stack<Integer> st , int insertElement){
        if(st.isEmpty()){
            st.add(insertElement);
            return;
        }
        int temValue= st.pop();
        insertElements(st,insertElement);
        st.add(temValue);

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
