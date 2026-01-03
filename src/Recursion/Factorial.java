package Recursion;

public class Factorial {
    public static int printFactorial(int n){
        if (n==0) return 1;
        return n * printFactorial(n-1);
    }
    public static void main(String[] args) {
        System.out.println(printFactorial(5));
    }
}
