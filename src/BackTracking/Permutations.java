package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private static  void helper(int[] nums, List<Integer> ds, boolean[] isValid,List<List<Integer>> ans){
        if(ds.size() == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i = 0;  i < ds.size(); i++){
                list.add(ds.get(i));
            }
            ans.add(list);
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!isValid[i]){
                ds.add(nums[i]);
                isValid[i] = true;
                helper(nums, ds, isValid, ans);
                isValid[i] = false;
                ds.remove(ds.size() - 1);
            }
        }
    }
    private static List<List<Integer>> premute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds  = new ArrayList<>();
        boolean[] isValid = new boolean[nums.length];
        helper(nums, ds, isValid, ans);
        return ans;

    }
    private static void printp(String str, String t,List<String> l){
        if(str.equals("")){
            l.add(t);
            return;
        }
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i + 1 );
            String rem = left + right;
            printp(rem, t + ch, l);
        }
    }
    public static void main(String[] args) {
        String str = "abc";

        List<String> l = new ArrayList<>();
        printp(str, "", l);
        for(String s : l){
            System.out.println(s);
        }


    }
}
