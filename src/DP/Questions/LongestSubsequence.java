package DP.Questions;
import java.util.List;

public class LongestSubsequence {
    private int longestSeq(int i, List<Integer> nums, int target, int[][] dp) {
        if(target == 0) return 0;
        if(i == nums.size() || target < 0) return Integer.MIN_VALUE;
        if(dp[i][target] != -1) return dp[i][target];
        int skip = longestSeq(i + 1, nums, target, dp);
        if(target - nums.get(i) < 0) return skip;
        int pick = longestSeq(i + 1, nums, target - nums.get(i), dp);
        if(pick != Integer.MIN_VALUE) pick += 1;
        return dp[i][target] =  Math.max(pick, skip);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()][target + 1];
        for(int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; i++) dp[i][j] = -1;
        int ans = longestSeq(0, nums, target, dp);
        return (ans == Integer.MIN_VALUE) ? -1 : ans;
    }


}
