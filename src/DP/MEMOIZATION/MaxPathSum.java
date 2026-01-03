package DP.MEMOIZATION;

public class MaxPathSum {

    static int maxPath(int[][] arr, int r, int c, int[][] dp){
        int n = arr.length, m = arr[0].length;
        if(r == n || c < 0 || c == m) return Integer.MIN_VALUE;
        if(r == n - 1) return arr[r][c];
        if(dp[r][c] != 0) return dp[r][c];
        int left_down = maxPath(arr, r + 1, c - 1, dp);
        int down = maxPath(arr, r + 1, c, dp);
        int right_down = maxPath(arr, r+ 1, c + 1, dp);
        return dp[r][c] = arr[r][c] + Math.max(left_down, Math.max(down, right_down));
    }
    static int maxPathSum(int[][] arr){
        int n = arr.length, m = arr[0].length;
        int ans = -1;
        int[][] dp = new int[n][m];
        for(int j = 0 ; j < m; j++ ){
            ans = Math.max(ans, maxPath(arr, 0, j, dp));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {3,6,1},
                {2,3,4},
                {5,5,1}
        };
        System.out.println(maxPathSum(arr));

    }
}
