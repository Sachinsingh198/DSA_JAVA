package SORTING.Selection;

public class SelectionSort {

      public static void print(int[] arr){
        for(int el: arr){
            System.out.print(el + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1,0,-2,3,0,4,8,0,10,12};
        int n = arr.length;

//        for(int i = 0; i< n - 1; i++){
//            int smallest = Integer.MAX_VALUE, idx = -1;
//            Boolean isSorted = true;
//            for(int j = i; j< n; j++){
//                if(arr[j] < smallest){
//                    smallest = arr[j];
//                    idx = j;
//                    isSorted = false;
//                }
//            }
//            if(isSorted == true) break;
//            int temp = arr[idx];
//            arr[idx] = arr[i];
//            arr[i] = temp;
//        }

        for(int i = n - 1; i >= 0; i--){
            int largest = Integer.MIN_VALUE;
            int idx = -1;

            for(int j = i; j >= 0; j--){
                if(arr[j] > largest){
                    largest = arr[j];
                    idx = j;
                }
            }
            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
        }

        print(arr);
    }
}
