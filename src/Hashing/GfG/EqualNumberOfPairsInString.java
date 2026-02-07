package Hashing.GfG;

import java.util.HashMap;

public class EqualNumberOfPairsInString {
    long equalPairs(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        long ans = 0;
        for(Character c : map.keySet()){
            ans += ((long) map.get(c) *map.get(c));
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
