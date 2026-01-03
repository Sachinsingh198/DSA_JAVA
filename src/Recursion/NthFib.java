package Recursion;

public class NthFib {
    public static int fib(int n){
        return (n == 0 || n == 1)?n:(fib(n-1) + fib(n - 2));
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(fib(n));
    }
}
