package PracticalDAA;

public class First {
    public static int fibonacci(int n){
        return (n == 0 || n == 1)?n: fibonacci(n-1) + fibonacci(n-2);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fibonacci(n));
    }
}
