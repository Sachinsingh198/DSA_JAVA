package Hashing.GfG;
import java.util.HashMap;
public class PairsWithDiffK {
    int countPairs(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int el : arr){
            map.put(el, map.getOrDefault(el, 0) + 1);
        }
        int pairs = 0;
        for(int el : map.keySet()){
            int rem1 = el - k;
            int rem2 = el + k;
            if(map.containsKey(rem1)) pairs += (map.get(el) * map.get(rem1));
            if(map.containsKey(rem2)) pairs += (map.get(el) * map.get(rem2));
        }
        pairs/=2;
        return pairs;
    }
    public static void main(String[] args) {

    }
}
