package Hashing.GfG;
import java.util.HashSet;
public class PairsWithDiffK {
    int countPairs(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int el : arr){
            int rem = el - k;
            if(set.contains(rem)) count++;
            set.add(el);
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
