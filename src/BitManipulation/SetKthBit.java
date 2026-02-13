package BitManipulation;

public class SetKthBit {
    static int setKthBit(int n, int k) {
        // code here
        int x = 1;
        x = x << k;
        return n | x;
    }
}
