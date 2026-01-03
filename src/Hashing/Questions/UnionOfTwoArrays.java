package Hashing.Questions;

import java.util.HashSet;

public class UnionOfTwoArrays {
    private static Object[] UnionArrays(int[] arr1, int[] arr2) {
        HashSet<Integer> union = new HashSet<>();
        for(int el : arr1){
            union.add(el);
        }
        for(int el : arr2){
            union.add(el);
        }
        return union.toArray();
    }
    public static void main(String[] args) {
        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6,3,9,2,9,4};

        Object[] union = UnionArrays(arr1, arr2);
        for(Object el : union){
            System.out.print(el + " ");
        }
        System.out.println();
        System.out.println(union.length);
    }

}
