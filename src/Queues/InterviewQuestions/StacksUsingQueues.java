package Queues.InterviewQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class StacksUsingQueues {
    public static class MyStack{
        Queue<Integer> q= new LinkedList<>();

        public MyStack(){}

        public void push(int x){
            q.add(x);
        }

        public int peek(){
           for(int i = 0; i < q.size() - 1; i++){
                q.add(q.remove());
            }

            int x =  q.peek();
            q.add(q.remove());

            return x;
        }

        public boolean isEmpty(){
            return q.isEmpty();
        }
    }
    public static void main(String[] args) {

    }
}
