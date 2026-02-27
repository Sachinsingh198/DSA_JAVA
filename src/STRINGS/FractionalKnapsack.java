package STRINGS;

public class FractionalKnapsack {

    public static int profit(int i, int C, int[] val, int[] wt){
        if(i == wt.length) return 0;
        int skip = profit(i + 1, C, val, wt);
        if(wt[i] > C) return skip;
        int take = val[i] + profit(i + 1, C-wt[i], val, wt);

        return Math.max(take , skip);
    }

    public static void main(String[] args) {
        int[] val = {5,3, 9, 16};
        int[] wt = {1,2,8,10};
        int C = 8;
        System.out.println(profit(0, C, val, wt));
    }
}
