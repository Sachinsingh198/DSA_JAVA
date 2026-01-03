package Stacks.InterviewQuestions;

import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalancedBracket(String str){
        if(str.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(') st.push(str.charAt(i));
            else{
                if(st.isEmpty()) return false;
                if(st.peek() == '(') st.pop();
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()((()";
        System.out.println(isBalancedBracket(str));
    }
}
