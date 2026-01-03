package PatternPrinting;

import java.util.Scanner;

public class PrintNumbers {

    static  void printAlphabet(int n){
        for(int i = 0; i< n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print((char)(j + 64) + " ");
            }
            System.out.println();
        }
    }

    static void printNumbers(int n){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<= n; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        printAlphabet(n);

    }
}
