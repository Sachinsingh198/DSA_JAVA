package DP.Questions;

import java.util.Arrays;

public class TargetSum {

    static int sum;
    public int ways(int i,int currsum, int[] nums, int target, int[][] dp){

        if(i == nums.length) {
            return (currsum == target) ? 1 : 0;
        }
        if(dp[i][currsum + sum] != -1) return dp[i][currsum + sum];
        int negative = ways(i + 1,currsum + nums[i], nums, target, dp);
        int positive = ways(i + 1, currsum - nums[i], nums, target, dp);
        return dp[i][currsum + sum] = negative + positive;
    }
    public int findTargetSumWays(int[] nums, int target) {
        sum = 0;
        for(int el : nums) sum += el;
        int[][] dp = new int[nums.length][2*sum + 1];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return ways(0,0, nums, target, dp);
    }
}
