package Recurssion;

import java.util.Stack;

public class SortStack {

    public static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) return;


        int top = st.pop();


        sortStack(st);

        insertInSortedOrder(st, top);
    }

    private static void insertInSortedOrder(Stack<Integer> st, int element) {

        if (st.isEmpty() || st.peek() <= element) {
            st.push(element);
            return;
        }

        int top = st.pop();
        insertInSortedOrder(st, element);

        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        sortStack(stack);

        System.out.println("Sorted Stack (Top to Bottom):");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
