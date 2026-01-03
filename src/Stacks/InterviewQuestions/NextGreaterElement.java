package Stacks.InterviewQuestions;

import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreater1(int[] arr){
        int[] result = new int[arr.length];

        for(int i = 0; i<arr.length; i++){
            result[i] = -1;
            for(int j = i + 1; j< arr.length; j++){
                if(arr[j] > arr[i]){
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }

    public static  int[] nextGreater(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        res[arr.length - 1] = -1;

        st.push(arr[arr.length - 1]);

        for(int i = arr.length - 2; i >= 0; i--){

                while(!st.isEmpty() && st.peek() < arr[i]  ){
                    st.pop();
                }
                if(st.isEmpty()){
                    res[i] = -1;
                }
                else{
                    res[i] = st.peek();
                }
                st.push(arr[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,2,1,8,6,3,4};
        int[] result1 = nextGreater1(arr);
        int[] result2 = nextGreater(arr);
        for(int el: result1){
            System.out.print(el + " ");
        }
        System.out.println();

        for(int el: result2){
            System.out.print(el + " ");
        }
        System.out.println();
    }
}
