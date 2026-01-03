package NUMBER_SYSTEM;
import java.util.Scanner;
public class DecimalToBinary {
    public static int toBinary(int decimal) {
        int binary = 0;
        int i = 1;
        while(decimal != 0){
            int parity = decimal % 2;
            binary += (parity * i);
            i *= 10;
            decimal /= 2;
        }
        return binary;
    }
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int decimal = scr.nextInt();
        int binary = toBinary(decimal);
        System.out.println(binary);
    }
}
