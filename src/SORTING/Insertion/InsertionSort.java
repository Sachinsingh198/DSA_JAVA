package SORTING.Insertion;

public class InsertionSort {

    public static void print(int[] arr){
        for(int el: arr){
            System.out.print(el + " ");
        }
        return;
    }
    public static void main(String[] args) {
        int[] arr = {4,1,7,3,9,1,0,8};
        int n = arr.length;

        for(int i = 1; i< n; i++){
            int j = i;
            while(j > 0 && arr[j] < arr[j - 1]){
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }

        print(arr);
    }
}
