package DP.Questions;

public class Knapsack {
    public static int profit(int i, int C, int[] val, int[] wt, int[][] dp){
        if(i < 0) return 0;
        if(dp[i][C] != -1) return dp[i][C];
        int skip = profit(i - 1, C, val, wt, dp);
        if(wt[i] > C) return dp[i][C] = skip;
        int take = val[i] + profit(i -1, C-wt[i], val, wt, dp);

        return dp[i][C] = Math.max(take , skip);
    }

    public static void main(String[] args) {
        int[] val = {5,3, 9, 16};
        int[] wt = {1,2,8,10};
        int C = 8;
        int n = wt.length;
        int[][] dp = new int[n][C+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        for(int i = 0; i < n; i++){
            for(int c = 0; c < C+1; c++){
                int skip =(i>0) ? dp[i-1][c] : 0;
                if(wt[i] > c)  dp[i][c] = skip;
                else{
                    int take = (i > 0) ? dp[i-1][c-wt[i]] : 0;
                    dp[i][c] = Math.max(take , skip);
                }
            }
        }
//        System.out.println(profit(n-1, C, val, wt, dp));
    }
}
