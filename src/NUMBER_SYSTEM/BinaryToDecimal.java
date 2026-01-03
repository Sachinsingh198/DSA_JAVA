package NUMBER_SYSTEM;
import java.util.Scanner;
import java.lang.Math;
public class BinaryToDecimal {

    public static int toDecimal(int binary) {
        int decimal = 0;
        int i = 1;
        while(binary != 0){
            int n = binary % 10;
            decimal += (n * i);
            binary /= 10;
            i *= 2;
        }
        return decimal;
    }
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int binary = scr.nextInt();
        int decimal = toDecimal(binary);
        System.out.println(decimal);
    }

}
