package DP.MEMOIZATION;

public class NthFibonaaci {
    public static  int  fib(int n, int[] dp){
        if( n <= 1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }


    public static int fib_memo(int n){
        int[] dp = new int[n + 1];
        for(int i = 0; i<=n; i++){
            dp[i] = -1;
        }

        return fib(n, dp);
    }

    public static void main(String[] args) {
        int n = fib_memo(8);
        System.out.println(n);
    }
}
