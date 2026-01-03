package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {

    public static void helper(String ans, String s, int idx, List<String> lst){
        if(idx == s.length()){
            if (ans.length() != 0) lst.add(ans);
            return ;
        }
        char ch = s.charAt(idx);
        helper(ans + ch, s, idx + 1, lst); // pick
        helper(ans,s, idx + 1,lst);
    }

    public static List<String> subsets(String s){
        List<String> lst = new ArrayList<>();
        helper("", s, 0, lst);
        Collections.sort(lst);
        return lst;
    }



    public static void printSubsets(String ans, String s, int idx){
        if(idx == s.length()){
            System.out.print(ans + " ");
            return;
        }
        char ch = s.charAt(idx);
        printSubsets(ans + ch, s, idx+1); // pick
        printSubsets(ans, s, idx+1);
    }
    public static void main(String[] args) {
        String s = "abc";
        printSubsets("", s, 0);
        System.out.println();
        List<String >lst = subsets(s);
        for(String el: lst){
            System.out.print(el + " ");
        }
    }
}
