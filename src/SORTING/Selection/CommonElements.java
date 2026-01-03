package SORTING.Selection;

import java.util.ArrayList;
import java.util.Arrays;

public class CommonElements {
    public static ArrayList<Integer> commonElements(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int m = a.length, n = b.length;
        ArrayList<Integer> common = new ArrayList<>();


        int i = 0, j = 0;
        while(i < m && j < n){
            if(a[i] == b[j]){
                common.add(a[i]);
                i++;
                j++;
            }
            else if(a[i] > b[j]) j++;
            else if(a[i] < b[j]) i++;
        }
        return common;
    }
    public static void main(String[] args) {
        int[] a = {3,1,2,1,1,4,5,5};
        int[] b = {6,1,1,4,4,2,8};

        ArrayList<Integer> common = commonElements(a,b);
        for(Integer el: common){
            System.out.print(el + " ");
        }
    }
}
