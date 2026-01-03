package BinarySearch;

public class KthMissingPositiveNumber {
    static int kthMissing(int[] arr, int k){

        int lo = 0, hi = arr.length -1;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int correctNo = mid + 1;
            int missing = arr[mid] - correctNo;
            if(missing == k) hi = mid -1;
            else lo = mid + 1;
        }

        return hi + 1 + k;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,5,7,8};
        int k = 2;
        System.out.println(kthMissing(arr, k));
    }
}
