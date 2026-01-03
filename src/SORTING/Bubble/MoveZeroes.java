package SORTING.Bubble;

public class MoveZeroes {
    public static void print(int[] arr){
        for(int el: arr){
            System.out.print(el + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1,0,-2,3,0,4,8,0,10,12};
        int n = arr.length;

        for(int i = 0; i< n- 1; i++){
            for(int j = 0; j< n - 1; j++){
                if(arr[j] == 0){
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        print(arr);
    }
}
