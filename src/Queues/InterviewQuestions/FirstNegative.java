package Queues.InterviewQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* First negative in each window of size k */
public class FirstNegative {

    private static long[] printFirstNegativeInteger(long[] arr,int N, int k) {
        long[] res = new long[N - k + 1];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0) q.add(i);
        }

        for(int i = 0; i < N - k + 1; i++){
            if(q.peek() < i) q.remove();
            else if(q.peek() < i + k - 1) {
                res[i] = arr[q.peek()];
            }
            else{
                res[i] = 0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        long[] arr = {12, -1, -7, 8, -15, 30, 16, 28};

        long[] res = printFirstNegativeInteger(arr,8, 3);
    }

}
