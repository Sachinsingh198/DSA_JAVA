package Recursion;

public class PrintArr {

    public static void helper(int[] arr, int idx){
        if(idx == 0) return;
        helper(arr, idx - 1);
        System.out.print(arr[idx - 1] + " ");
    }

    public static void printArr(int[] arr){
        helper(arr,arr.length);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        printArr(arr);
    }
}
