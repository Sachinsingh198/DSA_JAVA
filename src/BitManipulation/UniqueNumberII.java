package BitManipulation;

import java.util.Arrays;

public class UniqueNumberII {
    public int[] singleNum(int[] arr) {
        int xor = 0;
        for(int el : arr){
            xor ^= el;
        }
        int mask = (xor & (xor - 1)) ^ xor;

        int b1 = 0, b2 = 0;
        for(int el: arr){
            if((el & mask) != 0) b1 ^= el;
            else b2 ^= el;
        }
        int[] ans = {b1, b2};
        Arrays.sort(ans);
        return ans;
    }
    public static void main(String[] args) {

    }
}
