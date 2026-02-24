package DP.Questions;

import java.util.Arrays;

public class HouseRobber {
    static int[] dp;
    public static int robberyUsingTabulation(int[] arr){
        int[] dpArr = new int[arr.length];
        dpArr[0] = arr[0];
        dpArr[1] = Math.max(arr[0], arr[1]);

        for(int i = 2; i < arr.length; i++){
            dpArr[i] = Math.max(dpArr[i - 1], arr[i] + dpArr[i - 2]);
        }
        return dp[arr.length - 1];
    }
    public int rob(int[] arr) {
        if(arr.length == 1) return arr[0];

        int prev1 = arr[0];
        int prev2 = Math.max(arr[0], arr[1]);

        for(int i = 2; i < arr.length; i++){
            int curr = Math.max(prev2, arr[i] + prev1);
            prev1 = prev2;
            prev2 = curr;

        }
        return prev2;
    }


    public static int helper(int[] arr, int idx){
        if(idx >= arr.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int take = arr[idx] + helper(arr, idx + 2);
        int skip = helper(arr, idx + 1);
        return dp[idx] =  Math.max(take, skip);
    }
    public static int maxRobbery(int[] arr){
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, 0);
    }
    public static void main(String[] args) {
        int ans = maxRobbery(new int[0]);
    }
}
