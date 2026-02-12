package BitManipulation;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int a = 10;
        int b = 100;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
