package Queues.InterviewQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*Interleave the First Half of the Queue with Second Half*/
/*
* Given a queue q[] of even size. Your task is to rearrange the queue by interleaving its first half with the second half.

Interleaving is the process of mixing two sequences by alternating their elements while preserving their relative order.
In other words, Interleaving means place the first element from the first half and then first element from the 2nd half and again second element from the first half and then second element from the 2nd half and so on....
* */
/*
* step1 : Move First Half to stack
* step2 : Empty st to queue
* step3 : Move 1st(2nd) half to stack
* step4 : One By One add st.peek & q.peek to queue;
* step5 : Remove the q using stack
 */
public class InterleaveTheFirstHalf {
    public static void rearrangeQueue(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();
        int size = q.size();
        for(int i = 1; i <= size / 2; i++){
            st.push(q.remove());
        } // 5 6 7 8
        while(!st.isEmpty()){
            q.add(st.pop());
        } // 5 6 7 8 4 3 2 1
        for(int i = 1; i <= size / 2; i++){
            st.push(q.remove());
        } // 4 3 2 1

        while(!st.isEmpty()){
            q.add(st.pop());
            q.add(q.remove());
        }

        while(!q.isEmpty()){
            st.push(q.remove());
        }

        while (!st.isEmpty()){
            q.add(st.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= 8; i++){
            q.add(i);
        }

        System.out.println(q);
        rearrangeQueue(q);
        System.out.println(q);
    }
}
