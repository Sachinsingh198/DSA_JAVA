package ARRAYS;

import java.util.ArrayList;
import java.util.HashSet;

public class MissingElementInRange {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int min = low;
        int max = high;
        for(int el : arr){

            set.add(el);
        }
        for(int i = min; i <= max; i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}
