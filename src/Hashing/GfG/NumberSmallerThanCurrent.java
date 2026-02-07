package Hashing.GfG;

import java.util.Arrays;
import java.util.HashMap;

public class NumberSmallerThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> firstIndex = new HashMap<>();
        for(int i = 0; i < n; i++){
            firstIndex.putIfAbsent(sorted[i], i);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = firstIndex.get(nums[i]);
        }
        return ans;
    }
}
