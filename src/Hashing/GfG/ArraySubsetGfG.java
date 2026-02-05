package Hashing.GfG;

import java.util.HashMap;

public class ArraySubsetGfG {
    public boolean isSubset(int a[], int b[]) {
        HashMap<Integer, Integer> set = new HashMap<>();
        HashMap<Integer, Integer> subset = new HashMap<>();

        for(int el : a){
            set.put(el, set.getOrDefault(el, 0) + 1);
        }
        for(int el : b){
            if(!set.containsKey(el)) return false;
            subset.put(el, subset.getOrDefault(el, 0) + 1);

        }

        for(int key : subset.keySet()){
            int freq = subset.get(key);
            int setFreq = set.get(key);
            if(setFreq < freq) return false;
        }

        return true;
    }
    public static void main(String[] args) {

    }
}
