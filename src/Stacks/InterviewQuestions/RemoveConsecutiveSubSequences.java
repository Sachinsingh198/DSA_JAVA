package Stacks.InterviewQuestions;

import java.util.Stack;

public class RemoveConsecutiveSubSequences {
    public static int[] removeSequences(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for(int i = 0; i<n; i++){
            if(st.isEmpty() || st.peek() != arr[i]) st.push(arr[i]);
            else if(arr[i] == st.peek()){
                if(i==n-1 || arr[i] != arr[i+1]) st.pop();
            }
        }
        int[] result = new int[st.size()];
        int m = st.size();
        for(int i = m - 1; i >= 0; i--){
            result[i] = st.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,4,4,5,6};
        int[] result = removeSequences(arr);
        for(int el: result){
            System.out.print(el + " ");
        }
        System.out.println();
    }
}
