package Arrays2D.ArrayList2D;

import java.util.ArrayList;

public class MatrixMultiplication {
    public static ArrayList<ArrayList<Integer>> matrixMultiplication(int[][] arr1, int[][] arr2){
        int n = arr1.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i< n; i++){
            ans.add(new ArrayList<>());
            for(int j = 0; j < n; j++){
                int sum = 0;
                for(int k = 0; k < n; k++){
                    sum += (arr1[i][k] * arr2[k][j]);
                }
                ans.get(i).add(sum);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] arr2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        ArrayList<ArrayList<Integer>> ans = matrixMultiplication(arr1,arr2);
        for(ArrayList<Integer> row: ans){
            for(int el: row){
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
