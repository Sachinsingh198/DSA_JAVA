package Recursion;

public class Reverse {

    public static int reverse(int n, int r){
        return (n == 0)? r:(reverse(n / 10, r * 10 + (n % 10)));
    }

    public static void main(String[] args) {
        int n = 2856;
        int r = 0;
        while(n!=0){
            r *= 10;
            r += (n % 10);
            n /= 10;
        }
        System.out.println(reverse(r, 0));
    }
}
