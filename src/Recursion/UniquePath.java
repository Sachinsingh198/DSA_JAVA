package Recursion;

public class UniquePath {
    public static int helper(int cr, int cc, int lr, int lc){
        if(cr == lr && cc == lc) return 1;
        if(cr > lr || cc > lc) return 0;
        int right = helper(cr, cc + 1, lr, lc);
        int left = helper(cr + 1, cc, lr, lc);
        return left + right;
    }

    public static int uniquePath(int m, int n){
        return helper(0,0, m - 1, n - 1);
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][4];
        System.out.println(uniquePath(3,2));
    }
}
