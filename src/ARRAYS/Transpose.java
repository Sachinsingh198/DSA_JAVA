package ARRAYS;

import java.util.Scanner;

public class Transpose {

    private static int[][] transpose(int[][] arr, int r, int c) {

        /*For aquare matrix only*/
//        for(int i = 0; i< c; i++){
//            for(int j = i; j < r; j++){
//
//                /*for square matrix only*/
//                int temp = arr[i][j];
//                arr[i][j] = arr[j][i];
//                arr[j][i] = temp;
//            }
//        }
//        return arr;

        /*For non-square matrix*/
        int[][] transpose = new int[c][r];
        for(int i = 0; i<c; i++){
            for (int j = 0; j< r; j++){
                transpose[i][j] = arr[j][i];
            }
        }
        return transpose;
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

        int[][] transposeMatrix = transpose(arr, r, c);
        for(int i = 0; i< c; i++){
            for (int j = 0; j < r; j++){
                System.out.print(transposeMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
