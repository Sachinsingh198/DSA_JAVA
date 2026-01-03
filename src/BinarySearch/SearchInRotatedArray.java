package BinarySearch;

public class SearchInRotatedArray {
    static int target(int[] arr, int tar){
        int lo = 0, hi = arr.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] == tar) return mid;
            else if(arr[lo] <= arr[mid]){
                if(arr[lo] <= tar && tar < arr[mid]) hi = mid -1;
                else lo = mid + 1;
            }
            else {
                if(arr[mid] < tar && tar <= arr[hi]) lo = mid +1;
                else hi = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,9,10,1,2};
        int tar = 9;
        System.out.println(target(arr,tar));
    }
}
