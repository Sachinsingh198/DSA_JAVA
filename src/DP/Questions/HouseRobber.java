package DP.Questions;

import java.util.Arrays;

public class HouseRobber {
    static int[] dp;
    public int helper(int[] arr, int idx){
        if(idx >= arr.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int take = arr[idx] + helper(arr, idx + 2);
        int skip = helper(arr, idx + 1);
        return dp[idx] =  Math.max(take, skip);
    }
    public int maxRobbery(int[] arr){
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, 0);
    }
    public static void main(String[] args) {

    }
}
