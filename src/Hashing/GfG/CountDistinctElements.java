package Hashing.GfG;

import java.util.HashSet;

public class CountDistinctElements {
    private static int distinct(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int el : arr){
            set.add(el);
        }
        return set.size();
    }
    public static void main(String[] args) {

    }
}
