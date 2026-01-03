package ARRAYS;
import java.util.Scanner;
public class MatrixMultiplication {
    private static int[][] multiply(int[][] arr1, int[][] arr2) {

        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;
        int[][] mul = new int[r1][c2];
        if(c1 != r2){
            return mul;
        }

        for(int i = 0; i< r1; i++){    //row number
            for(int j = 0; j < c2; j++){
                int operation = 0;//column number
                for(int k = 0; k < c1; k++) {
                    operation += arr1[i][k] * arr2[k][i];
                }
                mul[i][j] = operation;
            }
        }
        return mul;
    }
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns in the array1");
        int r1= scr.nextInt();
        int c1 = scr.nextInt();
        int[][] arr1 = new int[r1][c1];
        for(int i = 0; i< r1; i++){
            for(int j = 0; j < c1; j++){
                arr1[i][j] = scr.nextInt();
            }
        }

        int r2= scr.nextInt();
        int c2 = scr.nextInt();
        int[][] arr2 = new int[r1][c1];
        for(int i = 0; i< r2; i++){
            for(int j = 0; j < c2; j++){
                arr2[i][j] = scr.nextInt();
            }
        }
        int[][] prod = multiply(arr1,arr2);
        for(int[] row: prod){
            for(int ele: row){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
