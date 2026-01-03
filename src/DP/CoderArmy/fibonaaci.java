package DP.CoderArmy;

public class fibonaaci {
    private static int fib_memo(int n, int[] dp){  // bottom-up approach
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        return (dp[n] != -1) ? dp[n] : (dp[n] = fib_memo(n - 1, dp) + fib_memo(n - 2, dp));
    }

    private static int fib_(int n){ // top-down approach
        int[] dp = new int[n + 1];
        if(n == 0 || n == 1) return n;
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    private static int fib_optimized_space(int n){
        if(n == 0 || n == 1) return n;
        int prev2 = 0;
        int prev = 1;
        int curr = 0;
        for(int i = 2; i <= n; i++){
            curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }

        return curr;
    }

    private static int fib(int n){
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i] = -1;
        }
        return fib_memo(n, dp);
    }
    public static void main(String[] args) {
        System.out.println(fib_optimized_space(3));
    }
}
