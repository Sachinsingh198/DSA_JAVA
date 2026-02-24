package Hashing.Questions;

import javax.naming.ldap.HasControls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UnionOfArrays {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int el : a){
            set.add(el);
        }
        for(int el : b) set.add(el);
        for(int el : set) ans.add(el);
        return ans;
    }
}
