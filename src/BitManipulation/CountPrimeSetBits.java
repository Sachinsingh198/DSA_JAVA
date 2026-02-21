package BitManipulation;

import java.util.Arrays;
import java.util.HashSet;

public class CountPrimeSetBits {
    public int countPrimeSetBits(int left, int right) {
        HashSet<Integer> hset = new HashSet<>(
                Arrays.asList(2,3,5,7,11,13,17,19,23,29,31)
        );
        int ans = 0;
        for(int i = left; i <= right; i++){
            int setBits  = Integer.bitCount(i);
            if(hset.contains(setBits)) ans++;
        }
        return ans;
    }
}
