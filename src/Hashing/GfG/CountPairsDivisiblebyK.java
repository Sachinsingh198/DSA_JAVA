package Hashing.GfG;

import java.util.HashMap;

public class CountPairsDivisiblebyK {
    public static long countKdivPairs(int arr[], int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int el : arr){
            int x = el % k;
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        long pairs = 0;

        long zeroCount = map.getOrDefault(0, 0);
        pairs += zeroCount * (zeroCount - 1 )/ 2;
        map.remove(0);
        if(k % 2 == 0 && map.containsKey(k/2)){
            long halfcount = map.get(k / 2);
            pairs += halfcount * (halfcount - 1)/2;
            map.remove(k / 2);
        }
        pairs *= 2;
        for(int key : map.keySet()){
            int rem = k - key;
            if(map.containsKey(rem)){
                pairs += ((long) map.get(key) * map.get(rem));
            }

        }
        pairs/=2;
        return  pairs;
    }
}
