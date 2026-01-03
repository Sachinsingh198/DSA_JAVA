package Arrays2D;

public class MinOutOfMaxInEachRow {
    public static int minOutOfMax(int[][] arr){

        int min = Integer.MAX_VALUE;
        for(int i = 0; i< arr.length;i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0; j< arr[0].length; j++){
                if(arr[i][j] > max) max = arr[i][j];
            }
            min = Integer.min(min, max);
        }
        return min;
    }

    public static void printColumnwise(int[][] arr){

        for(int i = 0; i< arr[0].length; i++){
            for(int j =0 ; j< arr.length; j++){
                System.out.print(arr[j][i]+ " ");
            }
            System.out.println();
        }
    }

    public static void forEach(int[][] arr){
        for(int[] row : arr){
            for(int el : row){
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,9},
                       {5,6,7,8},
                       {4,13,2,1}};
        System.out.println(minOutOfMax(arr));
        forEach(arr);
    }
}
