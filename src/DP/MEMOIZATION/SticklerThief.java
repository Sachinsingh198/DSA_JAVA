package DP.MEMOIZATION;

import java.util.Arrays;

public class SticklerThief {

    public static int maxLoot(int[] arr, int idx, int[] dp){
        if(idx >= arr.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int steal = arr[idx] + maxLoot(arr, idx + 2, dp);
        int skip = maxLoot(arr, idx + 1 , dp);
        return dp[idx] = Math.max(steal, skip);
    }
    public static  int findMaxSum(int[] arr){
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return maxLoot(arr, 0, dp);
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        System.out.println("Max Loot : " + findMaxSum(arr));
    }
}
