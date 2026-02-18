package BitManipulation;

public class NumberOfSetBits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            int cur = n & 1;
            if (cur == 1)
                count++;
            n >>= 1;
        }
        return count;
    }
}
