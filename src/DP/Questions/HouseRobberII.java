package DP.Questions;

public class HouseRobberII {

    public int get(int[] arr, int start, int end){
        if (start == end) return arr[start]; // only one house
        if (end - start == 1) return Math.max(arr[start], arr[end]); // two houses

        int prev1 = arr[start];
        int prev2 = Math.max(arr[start], arr[start + 1]);

        for(int i = start + 2; i <= end; i++){
            int curr = Math.max(prev2, arr[i] + prev1);
            prev1 = prev2;
            prev2 = curr;

        }
        return prev2;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // edge case: only one house
        int chooseFirst = get(nums, 0, n - 2);
        int chooseSecond = get(nums, 1, n -1);
        return Math.max(chooseFirst, chooseSecond);
    }
}
