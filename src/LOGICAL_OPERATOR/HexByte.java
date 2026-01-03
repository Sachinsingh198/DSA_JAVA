package LOGICAL_OPERATOR;
/*Masking sign extension*/

/**The signed right shift operator moves all bits of a number to the right. Here, the empty positions on the left are filled with the sign bit (the leftmost bit), preserving the number's sign (positive or negative).

 Behavior:

 For positive numbers: Vacant left bits are filled with 0.

 For negative numbers: Vacant left bits are filled with 1 (to maintain the negative value).

 Each shift effectively divides the number by
 2
 shift_count
 , rounding down towards negative infinity (integer division).

 Example (Positive number): Let’s take 16 in binary: 00000000 00000000 00000000 00010000 If we do 16 >> 2, the bits are shifted two positions to the right: 00000000 00000000 00000000 00000100 (which equals 4 in decimal). So:
 16
 ÷
 2
 2
 =
 4
 .

 Example (Negative number): Let’s take -16 in binary (two's complement representation): 11111111 11111111 11111111 11110000 If we do -16 >> 2, the bits are shifted two positions to the right: 11111111 11111111 11111111 11111100 (which equals -4 in decimal). So:
 −
 16
 ÷
 2
 2
 =
 −
 4
 .

 Key Points:

 Preserves the sign of the number (important for signed integers).

 Commonly used in tasks like dividing numbers by powers of two.*/
public class HexByte {
     static public void main(String[] args) {
        char[] hex = {
                '0', '1', '2', '3', '4', '5','6', '7',
                '8', '9', 'a', 'b', 'c', 'd','e', 'f'
         };

        byte b = (byte) 0xf1;
         System.out.println("b = 0x" + hex[(b >> 4) & 0x0f] + hex[b & 0x0f]);
    }
}
