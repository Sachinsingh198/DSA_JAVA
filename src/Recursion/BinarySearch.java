package Recursion;

public class BinarySearch {
    public static int helper(int[] arr, int lo, int hi, int target){
        if(lo > hi) return -1;
        int mid = lo + (hi - lo)/2;
        if(arr[mid]== target)return mid;
        return (arr[mid] > target)?helper(arr, lo, mid - 1, target):helper(arr, mid + 1, hi, target);

    }
    public static int search(int[] arr, int target){
        return helper(arr, 0, arr.length - 1, target);
    }
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(search(arr, 9));
    }
}
