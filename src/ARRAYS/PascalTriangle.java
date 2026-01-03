package ARRAYS;
import java.util.Scanner;
public class PascalTriangle {

    static void pascal(int n){
        int[][] ans = new int[n][];
        for(int i = 0; i< n; i++){
            //ith row has i+1 columns
            /*
            * ans[0] = new int[1]
            * ans[1] = new int[2]
            * * */
            ans[i] = new int[i + 1];
            ans[i][0] = ans[i][i] = 1;
            for(int j = 1; j < i;j++){
                ans[i][j] = ans[i-1][j] + ans[i-1][j-1];
            }
        }
        printMatrix(ans);
    }
    static void printMatrix(int[][] matrix){
        for (int[] rows : matrix) {
            for (int ele : rows) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = scr.nextInt();
        pascal(n);
    }
}
