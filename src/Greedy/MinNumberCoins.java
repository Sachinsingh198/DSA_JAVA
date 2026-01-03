package Greedy;

import java.util.ArrayList;

public class MinNumberCoins {
    private static ArrayList<Integer> minCoins(int n) {
        int[] currency = {2000, 500, 200, 100, 50, 20, 10, 5,2,1};
        ArrayList<Integer> ans = new ArrayList<>();
        int notes = 0, i = 0;

        while(n>0){
            notes = n / currency[i];
            while(notes > 0){
                ans.add(currency[i]);
                notes--;
            }
            n %= currency[i];
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 43;
        System.out.println(minCoins(n));
    }
}
