package BitManipulation;

import java.util.List;

public class MinBitwiseArray {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int p = nums.get(i);

            // OR of consecutive integers is always odd → even primes (2) impossible
            if (p == 2) {
                ans[i] = -1;
                continue;
            }

            // If input might contain non-primes or evens (defensive check)
            if ((p & 1) == 0) { // even numbers cannot be expressed
                ans[i] = -1;
                continue;
            }

            // Count trailing ones in p. For odd p, this is >= 1.
            // t = number of trailing ones in p = numberOfTrailingZeros(~p)
            int t = Integer.numberOfTrailingZeros(~p);
            int r = t - 1; // position to subtract power from

            ans[i] = p - (1 << r);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
