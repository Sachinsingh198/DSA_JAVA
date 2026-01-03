package SORTING.Selection;

import java.util.Arrays;

public class PairSum {
    public static void main(String[] args) {
        int[] arr = {7,0,4,3,2,8,10};
        int target = 9;
        Boolean sumTarget;

        Arrays.sort(arr);
        int i = 0, j = arr.length -1 ;
        while(i < j){
            if( arr[i] + arr[j] == target)  sumTarget = true;
            else if(arr[i] + arr[j] > target) j--;
            else if(arr[i] + arr[j] < target) i--;
        }
    }
}
