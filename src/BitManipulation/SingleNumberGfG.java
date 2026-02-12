package BitManipulation;

import java.util.HashMap;

public class SingleNumberGfG {
    int getSingle(int nums[]) {
        int xor = 0;
        for(int el : nums){
            xor = xor ^ el;
        }
        return xor;
    }
}
