package Recursion;

public class Power {
    public static int power(int a, int b){
        return (b == 0)? 1 : a * power(a, b - 1);
    }

    public static int powerOptimized(int a, int b){
        if(b == 0) return 1;
        int call = powerOptimized(a, b/2);
        return (b % 2 == 0)? call * call : a * call * call;

    }
    public static void main(String[] args) {
        int a = 5, b = 5;
        System.out.println(powerOptimized(a,b));
    }
}
