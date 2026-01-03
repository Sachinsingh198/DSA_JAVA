package BinarySearch;

public class MountainArray {
    public static int peakIndex(int[] arr){

        int hi = arr.length - 2, lo = 1; // 1st and last index can't be peak index


        while(lo < hi){
            int mid = hi + (lo - hi)/2;
            if(arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1])return mid;
            else if(arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]){
                //increasing part
                lo = mid + 1;//go right
            }
            else if(arr[mid - 1] > arr[mid] && arr[mid] > arr[mid+ 1]){
                //decreasing part
                hi = mid - 1;//go left
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,5,6,8,6,3};
        System.out.println(peakIndex(arr) + " "+ arr[peakIndex(arr)]);
    }
}
