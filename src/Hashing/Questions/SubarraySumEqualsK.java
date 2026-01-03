package Hashing.Questions;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySumEqualsK {
    private static int subarrays(int[] arr, int k) {
        int[] prefix = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int ans  = 0;
        int sum  = 0;
        for(int j = 0; j < arr.length; j++){
            sum += arr[j];
            if(map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum) + 1);
            }
            else{
                map.put(sum,1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {10,2,-2,-20,10};
        int k = -10;

        System.out.println(subarrays(arr, k));

    }


}
