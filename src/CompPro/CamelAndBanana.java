package CompPro;

public class CamelAndBanana {
    static int[] dp ;

    public static int banana_calc(int banana, int dis, int quantity){
        if(dis == 0) return 0;
        if(banana == 0){
            banana_calc(banana, dis - 1, quantity - 1);
        }
        if(dp[dis] != -1) return dp[dis];
        return Math.max(banana_calc(banana-1, dis + 1, quantity - 1 ), banana_calc(banana - 1,dis - 1,quantity - 1));
    }
    public static int banana_(int banana, int dis, int quantity){
        dp = new int[quantity];

        return banana_calc(banana, dis, quantity);
    }
}
