package BinarySearch;

public class FloorInSorted {

    public static int printFloor(int[]arr, int k){
        int lo = 0, hi = arr.length, idx = -1;

        while(lo < hi){
            int mid = hi + (lo - hi)/2;
            if(arr[mid] > k){
                hi = mid -1;
            }
            else if(arr[mid] <= k){
                idx = mid;
                lo = mid + 1;
            }
        }
        return idx;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,10,10,12,19};

        System.out.println(printFloor(arr,5));
    }
}
