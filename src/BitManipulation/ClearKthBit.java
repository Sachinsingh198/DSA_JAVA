package BitManipulation;

public class ClearKthBit {
    static int clearKthBit(int n, int k) {
        return n & (~(1 << k));
    }
}
