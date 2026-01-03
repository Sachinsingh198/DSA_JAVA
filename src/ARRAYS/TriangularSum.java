package ARRAYS;

public class TriangularSum {
    public static int triangularSum(int[] arr){
        if(arr.length == 1) return arr[0];
        int[] arr_dummy = new int[arr.length - 1];
        for(int i = 0; i < arr_dummy.length; i++){
            int sum = arr[i] + arr[i + 1];
            if(sum > 10) sum %= 10;
            arr_dummy[i] = sum;
        }
        return triangularSum(arr_dummy);

    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4 , 5};
        int sum =  triangularSum(arr);
        System.out.println(sum);
    }
}
