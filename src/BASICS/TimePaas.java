package BASICS;

import java.util.Scanner;

public class TimePaas {
    //Develop a java program to find the sum of odd and even numbers in an array.
    public static void main(String[] args) {
        int n;
        Scanner scr = new Scanner(System.in);
        n = scr.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n; i++){
            System.out.print("Enter element at index " + i + ": ");
            arr[i] = scr.nextInt();
        }
        for(int i = 0; i< n;  i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int evenSum = 0;
        int oddSum = 0;
        for(int i = 0; i< n; i++){
            if(arr[i] % 2== 0){
                evenSum+= arr[i];
            }
            else oddSum+= arr[i];
        }
        System.out.println("Sum of even terms in array : "+ evenSum);
        System.out.println("Sum of odd terms in array : "+ oddSum);
    }
}
