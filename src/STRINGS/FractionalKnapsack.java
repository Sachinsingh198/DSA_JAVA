package STRINGS;

public class FractionalKnapsack {

    public static int profit(int i, int C, int[] val, int[] wt, int[][] dp){
        if(i == wt.length) return 0;
        if(dp[i][C] != -1) return dp[i][C];
        int skip = profit(i + 1, C, val, wt, dp);
        if(wt[i] > C) return dp[i][C] = skip;
        int take = val[i] + profit(i + 1, C-wt[i], val, wt, dp);

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
        System.out.println(profit(0, C, val, wt, dp));
    }
}
