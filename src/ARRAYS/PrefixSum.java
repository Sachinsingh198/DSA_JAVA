package ARRAYS;

import java.util.Scanner;


public class PrefixSum {
    private static int rectangleSum(int[][] arr, int r, int c, int l1, int r1, int l2, int r2) {
        int sum = 0;
        for(int i = l1; i <= l2; i++){
            for(int j = r1; j <= r2; j++){
                sum += arr[i][j];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns: ");
        int r = scr.nextInt();
        int c = scr.nextInt();

        int[][] arr = new int[r][c];
        System.out.println("Enter the elements of array: ");
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                arr[i][j] = scr.nextInt();
            }
        }
        System.out.println("Enter the initial coordinates of the rectangle: ");
        int l1 = scr.nextInt();
        int r1 = scr.nextInt();
        System.out.println("Enter the final coordinates of the rectangle: ");
        int l2 = scr.nextInt();
        int r2 = scr.nextInt();
        int recSum = rectangleSum(arr, r, c, l1, r1, l2, r2);
        System.out.println("the sum of the rectangle is : "+ recSum);
    }
}
