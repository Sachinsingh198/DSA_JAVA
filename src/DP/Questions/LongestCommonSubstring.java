package DP.Questions;

public class LongestCommonSubstring {
    public int longCommSubstr(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[2][n + 1];
        int max = Integer.MIN_VALUE;
//        for (int[] row : dp) Arrays.fill(row, -1);
//        return lcs(m - 1, n - 1, a, b, dp);

        // Using Tabulation
        for(int i = 1;i <= m; i++){
            for (int j = 1;j <= n; j++){
                if(a.charAt(i - 1) == b.charAt(j - 1)) dp[1][j] =  1 + dp[0][j-1];
                else {
                    dp[1][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
            for(int j = 0; j <= n; j++) dp[0][j] = dp[1][j];

        }
        return max;
    }
    public static void main(String[] args) {

    }
}
