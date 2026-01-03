package Greedy;

import java.util.Arrays;

public class AssignMiceToHoles {

    private static int minTime(int[] m, int[] h) {
        Arrays.sort(m);
        Arrays.sort(h);

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < m.length; i++){
            ans = Math.max(ans, Math.abs(m[i] - h[i]));
        }

        return ans;
    }
    public static void main(String[] args) {
         int[] m = {4,-4,2};
         int[] h = {4,0,5};

        System.out.println(minTime(m, h));
    }


}
