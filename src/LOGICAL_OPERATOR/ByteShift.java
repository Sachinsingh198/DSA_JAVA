package LOGICAL_OPERATOR;
/*Left shifting by a byte value*/

/*The left shift operator moves all the bits of a number to the left by the specified number of positions. The vacant positions on the right are filled with 0.

Behavior:

For every shift, the number is effectively multiplied by
2
shift_count
        .

Negative numbers also follow the same rule, as this operator does not care about the sign bit.

Example: Let’s take 5 in binary: 00000000 00000000 00000000 00000101 If we do 5 << 2, the bits are shifted two positions to the left: 00000000 00000000 00000000 00010100 (which equals 20 in decimal).

In short:
        5
        ×
        2
        2
        =
        20
        .

Key Points:

If the left shift exceeds the bit size of the data type, overflow may occur (bits will be discarded).

Mostly used in tasks like multiplying numbers or handling binary data.
*/
public class ByteShift {
    /*Left Shifting as a quick way to multiply by 2*/
    public static class MultByTwo{
        int i ;
        int num = 0xFFFFFFE;
        MultByTwo() {
            for (i = 0; i < 4; i++) {
                num = num<<i;
                System.out.println(num);
            }
        }
    }
    public static void main(String[] args) {
        byte a = 64, b;
        int i;

        i = a << 2; // i = a * 2 ^ 2 (i.e.,  256)
        b = (byte) (a << 2);// b is 0 because after the shift , the low-order is now  zero. Its only 1 bit has been shifted out
        System.out.println("Original value of a: " + a);
        System.out.println("i and b: " + i + ' ' + b);

        System.out.println("\n\n******   Demonstration of Left Shifting as a quick way to multiply by 2 ******");
        MultByTwo obj = new MultByTwo();
    }
}
