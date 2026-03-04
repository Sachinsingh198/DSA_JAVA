package DP.Questions;

public class SubsetSum {

    private static boolean subset(int i,int[] nums, int target, int[][] dp) {
        if(i == nums.length){
            if(target == 0) return true;
            else return false;
        }
        if(dp[i][target] != -1) return dp[i][target] ==1;
        boolean ans = false;
        boolean skip = subset(i + 1,  nums, target, dp);
        if(target - nums[i] < 0  ) {
            ans = skip;
        }
        else {
            boolean pick = subset(i + 1, nums, target - nums[i], dp);
            ans = pick || skip;
        }
        dp[i][target] = (ans) ? 1 : 0;
        return ans;
    }

    public static boolean canPartition(int[] nums){
        int sum = 0, n = nums.length;
        for(int el : nums) sum += el;
        if(sum % 2 != 0) return false;

        int target = sum / 2;
        int[][] dp = new int[n][target + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                boolean ans = false;
                boolean skip = (i > 0) ? (dp[i-1][j] == 1) :(j == 0) ;
                if(j - nums[i] < 0  ) {
                    ans = skip;
                }
                else {
                    boolean pick = (i > 0) ? (dp[i-1][j - nums[i]] == 1) : j == 0 ;
                    ans = pick || skip;
                }
                dp[i][j] = (ans) ? 1 : 0;
            }
        }

        return dp[n-1][target] == 1;
    }

    public static void main(String[] args) {
        int[] nums = {8, 5, 2, 4};
        int target = 9;
        int[][] dp = new int[nums.length][target + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(subset(0, nums, target, dp));
    }


}
