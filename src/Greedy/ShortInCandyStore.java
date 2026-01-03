package Greedy;

import java.util.Arrays;

public class ShortInCandyStore {
    private static int[] minCost(int[] arr, int k){
        Arrays.sort(arr);
        int minAmount = 0;
        int maxAmount = 0;
        int i = 0, j = arr.length - 1;
        while(i <= j){
            minAmount += arr[i++];
            j -= k;
        }

        i = arr.length - 1;
        j = 0;
        while(i >= j){
            maxAmount += arr[i--];
            j += k;
        }
        return new int[]{maxAmount, minAmount};
    }
    public static void main(String[] args) {
        int[] arr = {3,2,1,4};
        int k = 2;
        System.out.println(Arrays.toString(minCost(arr, k)));
    }
}
