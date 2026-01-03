package Recursion;

public class DecresingIncreasing {
    public static  void printDecInc(int n){
        if(n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printDecInc(n-1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        int n = 8;
        printDecInc(n);
    }
}
