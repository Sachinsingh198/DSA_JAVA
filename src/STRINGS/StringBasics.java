package STRINGS;

import java.util.Scanner;

public class StringBasics {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String s = scr.nextLine();//Take the complete sentence , even after entering spaces
        System.out.println(s);
        String t = scr.next();//did'nt take string after spaces
        System.out.println(t);
    }
}
