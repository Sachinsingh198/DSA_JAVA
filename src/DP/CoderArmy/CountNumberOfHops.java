package DP.CoderArmy;

import java.util.Arrays;

public class CountNumberOfHops {
    // top - bottom
    private static int ways(int n, int[] dp){
        if(n <= 1) return 1;
        if(n == 2) return 2;
        return (dp[n] != -1)?dp[n]: (dp[n] =  ways(n - 1, dp) + ways(n - 2, dp) + ways(n - 3, dp));
    }

    // bottom - up
    private static int waysBottomUp(int n){
        if(n <= 1) return 1;
        if(n == 2) return 2;

        int prev2 = 1;
        int prev1 = 1;
        int prev = 2;
        int curr = 0;

        for(int i = 3; i <= n; i++){
             curr = prev + prev1 + prev2;
             prev2 = prev1;
             prev1 = prev;
             prev = curr;
        }
        return curr;
    }
    private static int waysToNth(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
//        return ways(n, dp);
        return waysBottomUp(n);

    }
    public static void main(String[] args) {
        int ways = waysToNth(6);
        System.out.println(ways);
    }
}
