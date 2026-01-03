package ARRAYS;
import java.util.Scanner;
public class Array2D {

    public static void printArray(int[] arr){
        for(int el: arr){
            System.out.print(el + " ");
        }
        System.out.println();
    }
    public static void swap(int n, int m){
        int temp = n;
        n = m;
        m = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Array: ");
        int n  = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< arr.length; i++){
            System.out.print("Enter the element at index " + i + ": ");
            arr[i] = sc.nextInt();
        }
        printArray(arr);

        // trying to copy arr in anather arrray

        int[] arr2 = arr; // a copy of a refernce of arr created which is assigned to arr2 or a shallow copy of the array 'arr' created

        int[] arr3 = {12,34,56,78};
        ;
        printArray(arr2);
        printArray(arr);
        System.out.println(arr2 == arr3);
        System.out.println(arr.equals(arr3));

    }
}
