package Hashing.GfG;

import java.util.HashMap;

public class ValidAnagram {
    public static boolean areAnagrams(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        HashMap<Character, Integer> freq = new HashMap<>();

        for(char ch : s1.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for(char ch : s2.toCharArray()){
            if(!freq.containsKey(ch)) return false;
            freq.put(ch, freq.get(ch) - 1);
            if(freq.get(ch) < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
