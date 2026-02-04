package Hashing.GfG;

import java.util.HashSet;

public class TwoSum {
    boolean twoSum(int[] arr, int target){
        HashSet<Integer> set = new HashSet<>();
        for(int el : arr){
            int rem = target - el;
            if(set.contains(rem)) return true;
            set.add(el);
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
