package Hashing.GfG;

import java.util.HashMap;

public class MostFrequentCharacter {
    public char getMaxOccuringChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int maxFreq = 0;
        char ans = 'z';

        for(char ch : map.keySet()){
            int freq = map.get(ch);
            if(freq > maxFreq || (freq == maxFreq && ch < ans)) {
                maxFreq = freq;
                ans = ch;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
