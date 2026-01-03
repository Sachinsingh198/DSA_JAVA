package DP.TABULATION;

public class NthFibonacci {
    static int nthFibonacci(int n){

        int[] dp = new int[n + 1];
        if(n > 0) dp[1] = 1;
        for(int i = 2; i< n + 1; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(nthFibonacci(0));
    }
}
