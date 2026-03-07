package DP.Questions;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static int lcs(int i, int j, StringBuilder a, StringBuilder b, int[][] dp) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return dp[i][j] =  1 + lcs(i - 1, j - 1, a, b, dp);
        else {
            return  dp[i][j] = Math.max(lcs(i, j - 1, a, b, dp), lcs(i-1, j, a, b, dp));
        }
    }
    public static int longestCommonSubsequence(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];
//        for (int[] row : dp) Arrays.fill(row, -1);
//        return lcs(m - 1, n - 1, a, b, dp);

        // Using Tabulation
        for(int i = 1;i <= m; i++){
            for (int j = 1;j <= n; j++){
                if(a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] =  1 + dp[i-1][j-1];
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {

    }
}
