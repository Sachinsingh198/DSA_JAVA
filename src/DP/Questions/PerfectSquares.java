package DP.Questions;

import java.util.Arrays;

public class PerfectSquares {
    public boolean isPerfect(int n){
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
    public int minSquares(int n, int[] dp){
        if(isPerfect(n)) return 1;
        if(dp[n]!=-1) return dp[n];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i*i <= n; i++){
            int count = minSquares(i*i, dp) + minSquares(n-i*i, dp);
            min = Math.min(min, count);
        }
        return dp[n] = min;
    }
    public int numSquares(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return minSquares(n, dp);
    }
    public int minSquaresTabulation(int n){
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            if(isPerfect(i)) dp[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for(int j = 1; j * j <= i; j++){
                    int count = dp[j*j] + dp[i - j*j];
                    min = Math.min(min, count);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}
