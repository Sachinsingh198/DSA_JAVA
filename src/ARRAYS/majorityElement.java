package ARRAYS;
import java.util.*;
public class majorityElement {

    private static int majority_element(Vector<Integer> v) {// for n/2 + 1 elements
        int n = v.size();
        int count = 1;
        int target = v.elementAt(0);
        for(int i = 1; i< n; i++){
            if(count == 0) target = v.elementAt(i);
            if(v.elementAt(i) == target) count++;
            else {
                count--;
            }
        }
        return target;
    }

    private static Vector<Integer> majority_element3(Vector<Integer> v) {
        int element1 = v.elementAt(0);
        int count1 = 1;
        int element2 = 0;
        int count2 = 0;
        for(int i = 0; i< v.size(); i++){
            if(element1 == v.elementAt(i)){
                count1++;
            }
            else if(element2 == v.elementAt(i)){
                count2++;
            }
            else if(count1 == 0){
                element1 = v.elementAt(i);
                count1 = 1;
            }
            else if(count2 == 0){
                element2 = v.elementAt(i);
                count1 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        //Iterate and find that the element1 and element2 has the count greater the n/3 or not
        count1  = count2 = 0;
        for(int i = 0; i< v.size(); i++){
            if(v.elementAt(i) == element1) count1++;
            else if(v.elementAt(i) == element2) count2++;
        }
        Vector<Integer> vec = new Vector<Integer>();
        if(count1 > v.size()/3){
            vec.addElement(count1);
        }
        if(count2 > v.size()/3){
            vec.addElement(count2);
        }
        return vec;
    }
    public static void main(String[] args){
        Vector<Integer> v = new Vector<Integer>(10);
        System.out.println("Initial size of arr: " + v.size());
        v.addElement(2);
        v.addElement(24);
        v.addElement(26);
        v.addElement(23);
        v.addElement(24);
        v.addElement(4);
        System.out.println("Final size of arr: " + v.size());

        for(int elem : v){
            System.out.print(elem + " ");
        }
        System.out.println();
        int majority = majority_element(v);
        System.out.println(majority);
        Vector<Integer> majority3 = majority_element3(v);
    }
}