package DP.Questions;

import java.util.Arrays;

public class FriendsPairingProblem {
    static long[] dp;

    public long countFriendsPairings(int n) {
        dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return pair(n);
    }

    public long pair(int n) {
        if (n <= 2) return n; // f(1)=1, f(2)=2
        if (dp[n] != -1) return dp[n];

        dp[n] = pair(n - 1) + (n - 1) * pair(n - 2);
        return dp[n];
    }
    public static long friend(int n){

        dp[1] = 1;
        int prev1 = 1;
        int prev2 = 0;

        if(n > 1) prev2  = 2;
        for(int i = 3; i <= n; i++){

            int curr = prev2 + (i - 1) * prev1;
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
}
