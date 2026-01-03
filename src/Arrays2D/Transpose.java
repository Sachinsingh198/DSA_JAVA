package Arrays2D;

public class Transpose {
    public static void print(int[][] arr){
        for(int[] row: arr){
            for(int el: row){
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    public static void transpose(int[][] arr){

        for(int i = 0; i<arr[0].length;i++){
            for(int j = 0; j < i; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][j];
                arr[j][i] = temp;
            }
        }
        print(arr);
    }
    public static int[][] matrixTranspose(int[][] arr){
        int[][] transpose = new int[arr[0].length][arr.length];

        for(int i = 0; i< arr[0].length; i++){
            for(int j = 0; j< arr.length; j++){
                transpose[i][j] = arr[j][i];
            }
        }

        return transpose;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,9},
                {5,6,7,8},
                {4,13,2,1},
                {3,4,5,6}
        };

//        int[][] transpose = matrixTranspose(arr);


    }

}
