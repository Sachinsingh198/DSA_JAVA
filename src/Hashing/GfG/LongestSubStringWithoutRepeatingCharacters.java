package Hashing.GfG;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0, maxLen = 1;
        while(j < s.length()){
            char ch = s.charAt(j);
            if(!set.contains(ch)){
                set.add(ch);
                j++;
            }
            else {
                int length = j - i;
                maxLen = Math.max(maxLen, length);
                while(s.charAt(i) != s.charAt(j)){
                    set.remove(s.charAt(i++));

                }
                i++;
                j++;
            }
        }
        int length = j - i;
        maxLen = Math.max(maxLen, length);
        return maxLen;
    }
    public static void main(String[] args) {

    }
}
