package Arrays2D;

public class RowWithMaxSum {
    public static int rowWithMaxSum(int[][] arr){
        int sum = 0;
        int max_sum_row = -1;

        for(int i = 0; i< arr.length; i++){
            int row_sum = 0;
            for(int j = 0; j < arr[0].length; j++){
                row_sum += arr[i][j];
            }
            if(row_sum > sum){
                max_sum_row = i;
                sum = row_sum;
            }
        }
        return max_sum_row;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{4,3,2,1}};
        System.out.println(rowWithMaxSum(arr));
    }
}
