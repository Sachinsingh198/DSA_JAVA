package GRAPH;

import java.util.Arrays;

public class MinCostToConvertString {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int ALPHABET = 26;
        long INF = (long)1e15;

        // distance matrix
        long[][] dist = new long[ALPHABET][ALPHABET];
        for (int i = 0; i < ALPHABET; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // cost to self = 0
        }

        // apply given transformations
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Floyd-Warshall for all-pairs shortest paths
        for (int k = 0; k < ALPHABET; k++) {
            for (int i = 0; i < ALPHABET; i++) {
                for (int j = 0; j < ALPHABET; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // compute total cost
        long total = 0;
        for (int i = 0; i < source.length(); i++) {
            char s = source.charAt(i);
            char t = target.charAt(i);
            if (s == t) continue;
            long c = dist[s - 'a'][t - 'a'];
            if (c == INF) return -1; // impossible
            total += c;
        }

        return total;
    }
}
