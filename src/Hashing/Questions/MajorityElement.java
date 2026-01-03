package Hashing.Questions;

import java.util.ArrayList;
import java.util.HashMap;

public class MajorityElement {
    private static ArrayList<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int el : nums){
            if(map.containsKey(el)){
                map.put(el, map.get(el) + 1);
            }
            else map.put(el, 1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > n / 3){
                ans.add(key);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,0};
        ArrayList<Integer> majority = majorityElement(nums);
        for(int el : majority){
            System.out.print(el + " ");
        }
        System.out.println();
    }
}
