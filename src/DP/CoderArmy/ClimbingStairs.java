package DP.CoderArmy;

public class ClimbingStairs {
    private static int paths(int i, int[] dp, int n){
        if(i == n) return 1;
        if(i > n) return 0;
        return ((dp[i] != -1)? dp[i] : (dp[i] = paths(i + 1, dp, n) + paths(i + 2, dp, n)));
    }

    private static int pathsReverse(int i, int[] dp){
        if(i <= 1) return 1;
        return (dp[i] != -1) ? dp[i] : (dp[i] = pathsReverse(i - 1, dp) + pathsReverse(i - 2, dp));
    }

    private static int climbStairs(int n){
        int[] dp = new int[n + 2];
        for(int it = 0; it <= n; it++) dp[it] = -1;
        return pathsReverse(n, dp);
    }

    private static int climbStairsBottomUP(int n){
        int[] dp = new int[n + 2];
        dp[n + 1] = 0;
        dp[n] = 1;
        for(int i = n - 1; i >= 0; i--){
            dp[i] = dp[i + 1] + dp[i + 2];
        }

        return dp[0];
    }
    private static int climbStairsOptimized(int n){
        int prev1 = 0;
        int prev2 = 1;

        int paths = 0;
        for(int i = n - 1; i >= 0; i--){
            paths = prev1 + prev2;
            prev1 = prev2;
            prev2 = paths;
        }
        return paths;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }
}
