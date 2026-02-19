package DP.Questions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NthTribonacci {

    // in constant memory
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        int t0 = 0, t1 = 1, t2 = 1;
        for(int i = 3; i <= n; i++){
            int t = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = t;
        }
        return t2;
    }

    // with recursion
    public int tribonacci_recursion(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        return tribonacci_recursion(n-1) + tribonacci_recursion(n-2) + tribonacci_recursion(n - 3);
    }

    // using dp

    public static int helperDp(int n, int[] dp) {
        // Base cases for Tribonacci:
        // T0 = 0, T1 = 1, T2 = 1
        if (n == 0) return dp[0] = 0;
        if (n == 1) return dp[1] = 1;
        if (n == 2) return dp[2] = 1;

        if (dp[n] != -1) return dp[n];

        dp[n] = helperDp(n - 1, dp) + helperDp(n - 2, dp) + helperDp(n - 3, dp);
        return dp[n];
    }

    public int tribonacci_dp(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helperDp(n, dp);
    }

}
