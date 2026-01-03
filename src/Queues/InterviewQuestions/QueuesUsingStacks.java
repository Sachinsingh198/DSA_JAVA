package Queues.InterviewQuestions;

import java.util.Stack;

public class QueuesUsingStacks {

    public static class MyQueue{
        Stack<Integer> st = new Stack<>();
        Stack<Integer> helper = new Stack<>();

        public MyQueue(){

        }

        public void push(int x){
            st.push(x);
        }

        public int pop(){
            while(st.size() != 1){
                helper.push(st.pop());
            }
            int popped = st.pop();

            while(!helper.isEmpty()){
                st.push(helper.pop());
            }
            return popped;
        }

        public int peek(){
            while(st.size() != 1){
                helper.push(st.pop());
            }
            int peeked = st.peek();

            while(!helper.isEmpty()){
                st.push(helper.pop());
            }
            return peeked;
        }

        public boolean empty(){
            return st.isEmpty();
        }
    }

    public static void main(String[] args) {

    }
}
