package BitManipulation;

public class PowerOfFour {
    boolean isPowerOfTwo(long n){
        return (n & (n - 1)) == 0;
    }
    public boolean isPowerOfFour(int n) {
        return isPowerOfTwo(n) && isSquare(n);
    }

    private boolean isSquare(long n) {
        long root = (long)(Math.sqrt(n));
        return (root * root == n);
    }

    public static void main(String[] args) {

    }
}
