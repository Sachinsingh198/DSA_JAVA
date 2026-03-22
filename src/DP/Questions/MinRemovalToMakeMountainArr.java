package DP.Questions;

public class MinRemovalToMakeMountainArr {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        // LIS
        int[] dp1 = new int[n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(nums[j] < nums[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j]);
                }
            }
            dp1[i] += 1;
        }

        // RLIS
        int[] dp2 = new int[n];
        for(int i = n-1; i >= 0; i--){
            for(int j = i+1; j <= n-1; j++){
                if(nums[j] < nums[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j]);
                }
            }
            dp2[i] += 1;
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            if(dp1[i] > 1 && dp2[i] > 1){
                int len = dp1[i] + dp2[i] - 1;
                max = Math.max(len, max);
            }

        }

        if(max < 3) return 0;
        return n - max;
    }
}
