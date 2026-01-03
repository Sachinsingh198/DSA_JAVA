package ARRAYS;
import java.util.Scanner;
public class SpiralMatrix {
    static void printSpiralMatrix(int[][] matrix, int n, int m) {
        int topRow = 0, bottomRow = n - 1, leftCol = 0, rightCol = m - 1;
        int totalElement = 0;

        while(totalElement <  n * m){
            //top row -> leftCol to RightCol
            for (int j = leftCol; j <= rightCol  && totalElement <  n * m; j++) {
                System.out.print(matrix[topRow][j] + " ");
                totalElement++;
            }
            topRow++;
            // Right Col -> topRow to bottomRow
            for(int i = topRow; i <= bottomRow  && totalElement <  n * m; i++){
                System.out.print(matrix[i][rightCol] + " ");
                totalElement++;
            }
            rightCol--;
            //BottomRow -> RightCol to LeftCol
            for(int j = rightCol; j >= leftCol  && totalElement <  n * m; j--){
                System.out.print(matrix[bottomRow][j] + " ");
                totalElement++;
            }
            bottomRow--;
            //LeftCol -> BottomRow to topRow
            for(int i = bottomRow; i >= topRow && totalElement <  n * m; i--){
                System.out.print(matrix[i][leftCol] + " ");
                totalElement++;
            }
            leftCol++;
        }

    }

    static int[][] generateSpiralMatrix(int n, int m){
        int[][] spiralMatrix = new int[n][m];
        int count = 1;
        int topRow = 0, bottomRow = n - 1, leftCol = 0, rightCol = m - 1;
        int totalElement = 0;

        while(count <=  n * m){
            //top row -> leftCol to RightCol
            for (int j = leftCol; j <= rightCol  &&  count <=  n * m; j++) {
                spiralMatrix[topRow][j] = count;
                count++;
            }
            topRow++;
            // Right Col -> topRow to bottomRow
            for(int i = topRow; i <= bottomRow  &&  count <=  n * m; i++){
                spiralMatrix[i][rightCol] = count;
                count++;
            }
            rightCol--;
            //BottomRow -> RightCol to LeftCol
            for(int j = rightCol; j >= leftCol  && count <=  n * m; j--){
                spiralMatrix[bottomRow][j] = count;
                count++;
            }
            bottomRow--;
            //LeftCol -> BottomRow to topRow
            for(int i = bottomRow; i >= topRow && count <=  n * m; i--){
                spiralMatrix[i][leftCol] = count;
                count++;
            }
            leftCol++;
        }
        return spiralMatrix;
    }
    static void printMatrix(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter the number of rows in a matrix: ");
        int n = scr.nextInt();
        System.out.print("Enter the number of columns in a matrix: ");
        int m = scr.nextInt();
//        int[][] matrix = new int[n][m];

//        System.out.println("Enter the elements of the Matrix: ");
//        for(int i = 0; i< n; i++){
//            for(int j = 0; j < m; j++){
//                matrix[i][j] = scr.nextInt();
//            }
//        }
//        printSpiralMatrix(matrix,n,m);
        int[][] matrix = generateSpiralMatrix(n,m);
        printMatrix(matrix);
    }
}
