package Recursion;

public class GCD {
    public static int gcd(int n, int m, int div){
        return (n % div == 0 && m % div == 0)?div: gcd(n, m, div - 1);
    }
    public static void main(String[] args) {
        int n = 60, m = 18;
        System.out.println(gcd(n,m, (n > m)?n: m));
    }
}
