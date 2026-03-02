package DP.Questions;

public class SubsetSum {

    private static boolean subset(int idx,int[] arr, int target, int[][] dp) {
        if(idx == arr.length){
            if(target == 0) return true;
            else return false;
        }
        if(dp[idx][target] != -1) return dp[idx][target] ==1;
        boolean ans = false;
        boolean skip = subset(idx + 1,  arr, target, dp);
        if(target - arr[idx] < 0  ) {
            ans = skip;
        }
        else {
            boolean pick = subset(idx + 1, arr, target - arr[idx], dp);
            ans = pick || skip;
        }
        if(ans) dp[idx][target] = 1;
        else dp[idx][target] = 0;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {8, 5, 2, 4};
        int target = 9;
        int[][] dp = new int[arr.length][target + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(subset(0, arr, target, dp));
    }


}
