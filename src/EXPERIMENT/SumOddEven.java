//Develop a java program to find the sum of odd and even numbers in an array.
package EXPERIMENT;
import java.util.Scanner;
public class SumOddEven {
    private static int evenSum(int[] arr) {
        int sum = 0;
        for(int el : arr){
            if(el % 2 == 0){
                sum += el;
            }
        }
        return sum;
    }

    private static int oddSum(int[] arr) {
        int sum = 0;
        for(int el : arr){
            if(el % 2 != 0){
                sum += el;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = scr.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " numbers: ");
        int i = 0;
        while(i < n){
            arr[i++] = scr.nextInt();
        }
        int sumEven = evenSum(arr);
        int sumOdd = oddSum(arr);
        System.out.println("Sum of even numbers in array: "+ sumEven);
        System.out.println("Sum of odd numbers in array: "+ sumOdd);
    }


}
