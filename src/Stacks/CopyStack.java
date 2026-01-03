package Stacks;

import java.util.Stack;

public class CopyStack {

    public static void displayStack(Stack<Integer> st){
        if(st.isEmpty()) {
            return;
        }
        int top = st.pop();
        System.out.print(top + " ");
        displayStack(st);
        st.push(top);

    }

    public static Stack<Integer> copyStack(Stack<Integer> st){
        Stack<Integer> reverse = new Stack<>();
        Stack<Integer> copy = new Stack<>();

        while(!st.isEmpty()){
            reverse.push(st.pop());
        }

        while(!reverse.isEmpty()){
            copy.push(reverse.pop());
        }

        return copy;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        System.out.println(st);
        Stack<Integer> copy = copyStack(st);
        System.out.println(copy);

        displayStack(copy);
    }
}
