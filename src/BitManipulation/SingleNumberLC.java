package BitManipulation;

import java.util.HashMap;

public class SingleNumberLC {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int el : nums){
                xor = xor ^ el;
        }
        return xor;
    }
}
