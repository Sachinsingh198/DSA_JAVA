package SORTING.Selection;

public class KthSmallest {
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        int k = 3;
        int n = arr.length;

        for(int i = 0; i < k; i++){
            int smallest = Integer.MAX_VALUE;
            int idx = -1;
            boolean isSorted = true;

            for(int j = i; j< n; j++){
                if(arr[j] < smallest){
                    smallest = arr[j];
                    idx = j;
                    isSorted = false;
                }
            }
            if(isSorted) break;
            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;

        }

        System.out.println("Nth smallest element is : "+ arr[k - 1]);
    }
}
