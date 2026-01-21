package BitManipulation;

import java.util.List;

public class MinBitwiseArray2 {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int p = nums.get(i);

            // If p is even (the only prime that is even is 2) -> impossible
            if ((p & 1) == 0) {     // p % 2 == 0
                ans[i] = -1;
                continue;
            }

            // Count trailing ones in p
            int s = 0;
            while (((p >> s) & 1) == 1) {
                s++;
            }
            // s >= 1 here because p is odd

            // Minimal x = p - 2^(s - 1)
            ans[i] = p - (1 << (s - 1));
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
