package Arrays2D.ArrayList2D;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> pascalTriangle(int n){

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i< n; i++){
            ans.add(new ArrayList<>());
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) ans.get(i).add(1);
                else{
                    int val = ans.get(i - 1).get(j) + ans.get(i - 1).get(j -1);
                    ans.get(i).add(val);
                }
            }
        }
        return ans;
    }

    public static List<Integer> getRow(int rowIndex){
        List<List<Integer>> triangle = pascalTriangle(rowIndex + 1);
        return triangle.get(rowIndex);
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> pascal = pascalTriangle(n);

        for(List<Integer> row: pascal){
            for(int el: row){
                System.out.print(el + " ");
            }
            System.out.println();
        }
        List<Integer> l = getRow(4);
        for(int el: l){
            System.out.print(el + " ");
        }
        System.out.println();
    }
}
