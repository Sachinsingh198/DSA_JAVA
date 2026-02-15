package BitManipulation;

import java.util.ArrayList;

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        int n = arr.length;
        int m = 1 << n;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; i++){
            ArrayList<Integer> a = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if((i >> j) % 2 == 1) a.add(arr[j]);
            }
            ans.add(a);
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
