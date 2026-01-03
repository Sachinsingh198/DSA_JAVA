package ARRAYS;

import java.util.Arrays;

public class ShalloDeepCopy {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
        int[] x = arr;// x is shallow copy of arr

        x[1] = 2;
        System.out.println(arr[1]);

        int[] deep = Arrays.copyOf(arr,arr.length);
        System.out.println(arr[0]);

        deep[0] = 45;
        System.out.println("arr[0] = deep[0] "+( arr[0] == deep[0]));
    }
}