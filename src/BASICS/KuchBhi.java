package BASICS;

import java.util.Scanner;


public class KuchBhi {

    public static void func(){
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter Marks of Science: ");
        int n1 = scr.nextInt();
        if(n1 > 100 || n1 < 0){
            System.out.println("Invalid marks!");
            func();
        }
        System.out.print("Enter Marks of Math's: ");
        int n2 = scr.nextInt();
        if(n2 > 100 || n2 < 0){
            System.out.println("Invalid marks!");
            func();
        }
        System.out.print("Enter Marks of English: ");
        int n3 = scr.nextInt();
        if(n3 > 100 || n3 < 0){
            System.out.println("Invalid marks!");
            func();
        }
        System.out.print("Enter Marks of Social Science: ");
        int n4 = scr.nextInt();
        if(n4 > 100 || n4 < 0){
            System.out.println("Invalid marks!");
            func();
        }
        System.out.print("Enter Marks of Hindi: ");
        int n5 = scr.nextInt();
        if(n5 > 100 || n5 < 0){
            System.out.println("Invalid marks!");
            func();
        }
        int average ;
        average = (n1 + n2 + n3 + n4 + n5)/5;
        if(average > 90){
            System.out.println("Grade : A");
        }
        else if(average > 70 ){
            System.out.println("Grade : B");
        }
        else if(average > 60 ){
            System.out.println("Grade : C");
        }
        else if(average > 40){
            System.out.println("Grade : D");
        }
        else {
            System.out.println("Fail!");
        }
        return;
    }
    public static void main(String[] args) {
        func();
    }
}
