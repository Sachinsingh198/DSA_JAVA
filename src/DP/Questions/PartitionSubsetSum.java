package DP.Questions;

public class PartitionSubsetSum {
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
        dp[idx][target] = (ans) ? 1 : 0;
        return ans;
    }
    public static boolean canPartition(int[] nums){
        int sum = 0;
        for(int el : nums){
            sum += el;
        }
        if(sum % 2 != 0) return false;

        int target = sum/2;
        int[][] dp = new int[arr.length][target + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
       return subset(0, nums, target, dp);
    }
}
