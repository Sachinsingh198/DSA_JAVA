package DP.Questions;

public class UniquePaths {

    static int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return paths(0, 0, m, n);
    }

    private int paths(int row, int col, int m, int n) {
        if(row >= m || col >= n) return 0;
        if(row == m - 1 && col == n - 1) return 1;
        if(dp[row][col] != -1) return dp[row][col];
        int rightWays = paths(row, col + 1, m, n);
        int leftWays = paths(row + 1, col , m , n);
        return dp[row][col] =  rightWays + leftWays;
    }

    public int uniquePathsIterative(int m, int n) {
        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        for(int i = 0; i < m; i++) dp[i][0] = 1;
        for(int j = 0; j < n; j++) dp[0][j] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsSpaceOptimized(int m, int n) {
        int[][] dp = new int[2][n];
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
            dp[1][j] = 1;
        }
        for(int i = 1; i <=m-1; i++){
            for(int j = 1; j < n; j++){
                dp[1][j] = dp[1][j-1] + dp[0][j];
            }
            for(int j = 1 ; j < n; j++){
                dp[0][j] = dp[1][j];
            }
        }
        return dp[1][n - 1];
    }



    public static void main(String[] args) {

    }
}
