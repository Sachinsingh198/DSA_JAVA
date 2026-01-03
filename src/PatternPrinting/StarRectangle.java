package PatternPrinting;

import java.util.Scanner;

public class StarRectangle {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int row = scr.nextInt();
        int col = scr.nextInt();

        for(int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
