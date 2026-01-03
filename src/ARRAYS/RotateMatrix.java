package ARRAYS;

import java.util.Scanner;

import static java.util.Collections.rotate;

public class RotateMatrix {

    private static int[][] transpose(int[][] arr, int r, int c) {

        int[][] transpose = new int[c][r];
        for(int i = 0; i<c; i++){
            for (int j = 0; j< r; j++){
                transpose[i][j] = arr[j][i];
            }
        }
        return transpose;
    }

    static void reverseArray(int[] arr){
        int i = 0, j = arr.length - 1;
        while( i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    private static int[][] rotate(int[][] arr, int r, int c) {
        int[][] rotated = transpose(arr, r,c);
        for(int i = 0; i< c; i++){
            reverseArray(rotated[i]);
        }
        return  rotated;
    }
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int r = scr.nextInt();
        int c = scr.nextInt();
        int[][] arr = new int[r][c];
        for(int i = 0; i< r; i++){
            for(int j = 0; j < c; j++){
                arr[i][j] = scr.nextInt();
            }
        }

        int[][] RotateMatrix = rotate(arr, r, c);
        for(int i = 0; i< c; i++){
            for (int j = 0; j < r; j++){
                System.out.print(RotateMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
