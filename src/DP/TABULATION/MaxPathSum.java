package DP.TABULATION;

public class MaxPathSum {

    static int maxPathSum(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                if(i == 0) dp[i][j] = arr[i][j];
                else if(j == 0 || j == n - 1){
                    if(j == 0){
                        dp[i][j] = arr[i][j] + dp[i - 1][j + 1];
                    }
                    else dp[i][j] =  arr[i][j] + dp[i - 1][j - 1];
                }
                else dp[i][j] = Math.max(arr[i][j] + dp[i - 1][j - 1], arr[i][j] + dp[i - 1][j + 1]);
            }
        }
        int ans = dp[m - 1][0];
        for(int j = 1; j < n; j++){
            ans = Math.max(dp[m - 1][j], ans);
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
