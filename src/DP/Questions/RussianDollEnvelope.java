package DP.Questions;

import java.util.Arrays;

public class RussianDollEnvelope  {
    public class Envelope implements Comparable<Envelope>{
        int w, h;
        Envelope(int w, int h){
            this.w = w;
            this.h = h;
        }
        public int compareTo(Envelope e){
            if(this.w == e.w) return e.h - this.h;
            return this.w - e.w;
        }

    }
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Envelope[] arr = new Envelope[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Envelope(envelopes[i][0], envelopes[i][1]);
        }
        Arrays.sort(arr); // sorted by width asc, height desc

        int[] dp = new int[n];
        Arrays.fill(dp, 1); // each envelope is at least length 1
        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j].h < arr[i].h) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
