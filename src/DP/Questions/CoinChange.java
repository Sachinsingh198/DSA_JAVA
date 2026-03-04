package DP.Questions;

public class CoinChange {
    public static long coinCount(int i, int[] coins, int amount, long[][] dp){
        if(i == coins.length){
            if(amount == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[i][amount] != -1) return dp[i][amount];
        long skip = coinCount(i + 1, coins, amount, dp);
        if(amount - coins[i] < 0) return skip;
        long pick = 1 + coinCount(i, coins, amount - coins[i], dp);

        return dp[i][amount] =  Math.min(skip, pick);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[n][amount + 1];
//        for(int i = 0; i < dp.length; i++)
//            for(int j = 0; j < dp[0].length; j++)
//                dp[i][j] = -1;
//

        // Using Tabulation
        for(int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                long skip =(i > 0) ?  dp[i-1][j] : (j == 0 ? 0 : Integer.MAX_VALUE);
                if(j - coins[i] < 0)  dp[i][j] = skip;
                else {
                    long pick = 1 + dp[i][j - coins[i]];

                     dp[i][j] = Math.min(skip, pick);
                }
            }
        }

        int ans = (int) dp[n-1][amount];
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
