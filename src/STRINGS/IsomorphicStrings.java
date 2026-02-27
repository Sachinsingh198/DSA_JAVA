package STRINGS;

import java.util.HashMap;

public class IsomorphicStrings {
    public boolean areIsomorphic(String s, String t) {
//        HashMap<Character, Integer> map1 = new HashMap<>();
//        HashMap<Character, Integer> map2 = new HashMap<>();
//        for(int i = 0; i < s1.length(); i++){
//            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
//        }
//        for(int i = 0; i < s2.length(); i++){
//            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
//        }
//
//        for(Character key : map1.keySet()){
//            int freq = map1.get(key);
//            if(map2.containsValue(freq))continue;
//            else return false;
//        }
//        return true;

        HashMap<Character, Character> hm = new HashMap<Character, Character>();
        for(int i=0; i < s.length(); i++){
            if(hm.containsKey(s.charAt(i)))
        }
    }
}
