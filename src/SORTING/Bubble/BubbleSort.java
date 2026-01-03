package SORTING.Bubble;

public class BubbleSort {

    public static void print(int[] arr){
        for(int el: arr){
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5,-2,6,7,2,0,7,2};
        int n = arr.length;

        //Bubble Sort optimized
//        for(int i = 0; i< n - 1; i++){
//            int swaps = 0;
//            for(int j = 0; j< n - 1 - i; j++){
//                if(arr[j] > arr[j+1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                    swaps++;
//                }
//            }
//            if(swaps == 0) break;
//        }

        for(int i = 0; i < n - 1; i++){
            int swaps = 0;
            Boolean isSorted = true;
            for(int j = 0; j< n - 1 - i; j++){
                if(arr[j] < arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    isSorted = false;
                }
            }
            if(isSorted)
                break;
        }
        System.out.println();
        print(arr);
    }
}
