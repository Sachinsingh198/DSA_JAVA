package Hashing.Questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class IntersectionOfTwoArrays {
    private static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int el : arr1){
            set.add(el);
        }
        for(int el : arr2){
            if(set.contains(el)){
                res.add(el);
                set.remove(el);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr1 = {7, 3 ,9, 2, 5, 4};
        int[] arr2 = {6,3,9,2,9,4};

        ArrayList<Integer> intersect = intersection(arr1, arr2);
        for(int el : intersect){
            System.out.print(el  + " ");
        }
        System.out.println();;
        System.out.println(intersect.size());
    }


}
