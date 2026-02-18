package BitManipulation;

public class AlrnatingBits {
    public boolean hasAlternatingBits(int n) {

        int prev = n & 1; // last bit
        n >>= 1;
        while (n > 0) {
            int cur = n & 1;
            if (cur == prev)
                return false; // adjacent equal bits
            prev = cur;
            n >>= 1;
        }
        return true;

    }
}
