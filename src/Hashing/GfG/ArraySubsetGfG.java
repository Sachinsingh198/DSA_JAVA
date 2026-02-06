package Hashing.GfG;

import java.util.HashMap;

public class ArraySubsetGfG {
    // Using Two Maps
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

    // Using 1 map
    public boolean isSubset2(int a[], int b[]){
        HashMap<Integer, Integer> aMap = new HashMap<>();
        for(int el : a){
            aMap.put(el, aMap.getOrDefault(el, 0) + 1);
        }
        for(int el : b){
           if(!aMap.containsKey(el) || aMap.get(el) == 0) return false;
           aMap.put(el, aMap.get(el) - 1);
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
