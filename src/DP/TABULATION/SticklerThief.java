package DP.TABULATION;


public class SticklerThief {

    static int maxLoot(int[] houses){
        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        for(int i = 2; i< houses.length; i++){
            dp[i]  = Math.max(dp[i - 1], dp[i - 2] + houses[i]);
        }
        return dp[houses.length - 1];
    }
    public static void main(String[] args) {
        int[] houses = {6,5,1,7,4};
        System.out.println(maxLoot(houses));
    }
}
