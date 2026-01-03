package Recursion;

public class SumNaturalNum {
    public static int sum(int n){
        return (n == 1)? n:(n + sum(n - 1));
    }
    public static  int ap(int n){
        return n * (n + 1)/2;
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(sum(n));
        System.out.println(ap(n));
    }
}
