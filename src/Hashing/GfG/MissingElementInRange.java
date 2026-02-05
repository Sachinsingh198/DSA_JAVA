package Hashing.GfG;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MissingElementInRange {

    //GfG
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

    //Leetcode
    public List<Integer> findMissingElements(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int el : arr){
            max = Math.max(max, el);
            min = Math.min(min, el);
            set.add(el);
        }
        for(int i = min; i <= max; i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
