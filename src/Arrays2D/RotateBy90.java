package Arrays2D;

public class RotateBy90 {

    public static void print(int[][] arr){
        for(int[] row: arr){
            for(int el: row){
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    public static void rotateBy90(int[][] arr){

        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j< i; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }


        for(int i = 0; i < arr.length ; i++){
            int start = 0, end = arr[0].length - 1;
            while(start < end){
                int temp = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = temp;
                start++;
                end--;
            }
        }

    }

    public static void main(String[] args) {
                int[][] arr = {
                {1,2,3,9},
                {5,6,7,8},
                {4,13,2,1},
                {3,4,5,6}
        };
        rotateBy90(arr);

        print(arr);
    }
}
