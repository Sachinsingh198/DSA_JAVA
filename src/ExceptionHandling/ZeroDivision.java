package ExceptionHandling;

import java.util.Scanner;

public class ZeroDivision {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter the Numerator: ");
        int num = scr.nextInt();
        System.out.print("Enter the Denominator: ");
        int denum = scr.nextInt();
        try{
            System.out.println(num/denum);
        }
        catch(Exception e){
            System.out.println("Division by zero Exception");
        }
        finally{
            System.out.println("Finally get executed");
        }
    }
}
