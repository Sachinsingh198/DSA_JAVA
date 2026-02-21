package ARRAYS;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);  // sort ascending
        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {
            int papersWithAtLeastThisManyCitations = n - i;
            if (citations[i] >= papersWithAtLeastThisManyCitations) {
                h = papersWithAtLeastThisManyCitations;
                break; // once condition is met, that's the max h
            }
        }

        return h;
    }
}
