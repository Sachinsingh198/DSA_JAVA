package EXPERIMENT;
import java.util.Scanner;
public class PrimeNumbers {

    private static boolean isPrime(int num){
        if(num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter the 1st number: ");
        int n1 = scr.nextInt();
        System.out.print("Enter the 2nd number: ");
        int n2 = scr.nextInt();
        for(int i = n1; i < n2; i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
    }

}
