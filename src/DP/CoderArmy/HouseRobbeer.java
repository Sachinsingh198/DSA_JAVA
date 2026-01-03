package DP.CoderArmy;

import java.util.Arrays;

public class HouseRobbeer {

    //bottom up
    private static int profitBUp(int[] arr){
        int prev = arr[0];
        int prev2 = Math.max(arr[0], arr[1]);
        int curr = 0;

        for(int i = 2; i < arr.length; i++){
            curr = Math.max(arr[i] + prev, prev2);
            prev = prev2;
            prev2 = curr;
        }
        return curr;
    }

    //top-bottom
    private static int profit(int[] arr, int i, int[] dp){
        if(i == 0) return arr[0];
        if(i == 1) return Math.max(arr[0], arr[1]);
        return (dp[i] != -1) ? dp[i] : ( dp[i] =  Math.max(arr[i] + profit(arr, i - 2, dp), profit(arr, i - 1, dp) ));
    }
    private static int maxProfit(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
//        return profit(arr, arr.length - 1, dp);
        return profitBUp(arr);
    }
    public static void main(String[] args) {
        int[] arr = {7,3,2,8,2,1,10};
        System.out.println(maxProfit(arr));
    }
}
