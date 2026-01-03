package Arrays2D.ArrayList2D;

import java.util.ArrayList;

public class ArrayList_2D {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3); a.add(5); a.add(7); a.add(8);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(3); b.add(5); b.add(7); b.add(8);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(3); c.add(5); c.add(7); c.add(8);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(a); arr.add(b); arr.add(c);
        System.out.println(arr);

        for(int i = 0; i< arr.size(); i++){
            for(int j = 0; j < arr.get(i).size(); j++){
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(ArrayList<Integer> row: arr){
            for(int el: row){
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

}
