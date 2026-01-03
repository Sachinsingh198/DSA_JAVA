package BinarySearch;

import java.util.ArrayList;

public class FirstOccurance {
    private static ArrayList<Integer> firstOccurance(int[] arr, int k) {
        int n = arr.length;
        int hi = n - 1, lo = 0, idx = -1;
        ArrayList<Integer> occurance = new ArrayList<>();

        while(hi >= lo){
            int mid = (lo + hi )/ 2;
            if(arr[mid] > k) hi = mid - 1;
            else if(arr[mid] < k) lo = mid + 1;
            else{
                idx = mid;
                hi = mid - 1;
            }
        }
        occurance.add(idx);

        int idx2 = -1;
        hi = n - 1;
        lo = 0;
        while(lo <= hi) {
            int mid = (hi + lo)/2;
            if(arr[mid] < k) lo = mid + 1;
            else if(arr[mid] > k)hi = mid - 1;
            else {
                idx2 = mid;
                lo = mid + 1;
            }
        }
        occurance.add(idx2);
        return occurance;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,5};
        int k = 4;
        ArrayList<Integer> occ = firstOccurance(arr,5);

        System.out.println(occ.get(0) + " "+ occ.get(1));
    }
}
