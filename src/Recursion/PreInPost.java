package Recursion;

public class PreInPost {
    public static void prInPost(int n){
        if(n == 0) return;
        System.out.print(n + " ");
        prInPost(n-1);
        System.out.print(n + " ");
        prInPost(n-1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        int n = 3;
        prInPost(n);
    }
}
