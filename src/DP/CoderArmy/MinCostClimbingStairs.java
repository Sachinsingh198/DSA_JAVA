package DP.CoderArmy;

import java.util.Arrays;

public class MinCostClimbingStairs {
    // top to bottom
    private static int findCost(int[] cost, int i, int[] dp){
        if(i == 0 || i == 1  ) return 0;
        return (dp[i] != -1)?dp[i] : (dp[i] =  Math.min(cost[i - 1] + findCost(cost, i - 1, dp),cost[i - 2] + findCost(cost, i - 2, dp)));
    }

    // bottom -up
    private static int findCostBUp(int[] cost, int[]dp){
        dp[0] = 0; dp[1] = 0;
        for(int i = 2; i <= cost.length; i++){
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }
        return dp[cost.length ];
    }

    // bottom -up Optimized
    private static int findCostBUpOptimized(int[] cost){
        int prev = 0;
        int prev2 = 0;
        int curr = 0;
        for(int i = 2; i <= cost.length; i++){
            curr = Math.min(cost[i - 1] + prev, cost[i - 2] + prev2);
            prev = prev2;
            prev2 = curr;
        }
        return curr;
    }
    private static int minCost(int[] cost){
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);

//        return findCost(cost, cost.length, dp);
//        return findCostBUp(cost,  dp);
        return findCostBUpOptimized(cost);
    }
    public static void main(String[] args) {
        int[] cost = {20, 10, 24, 2};
        System.out.println(minCost(cost));
    }
}
