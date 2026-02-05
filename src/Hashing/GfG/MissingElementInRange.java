package Hashing.GfG;


import java.util.ArrayList;
import java.util.HashSet;

public class MissingElementInRange {
    public static ArrayList<Integer> missingRange(int[] arr, int low, int high){
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int el : arr){
            set.add(el);
        }
        for(int i = low; i <= high; i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
