package GRAPH.RaghavGarg.TopologicalSorting;

import java.util.*;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegrees = new int[n];
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n; i++) {
            for(int el : graph[i]) {
                adj.get(el).add(i);
                indegrees[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(indegrees[i] == 0) q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int front = q.remove();
            ans.add(front);
            for (int el : adj.get(front)) {
                indegrees[el]--;
                if(indegrees[el] == 0) q.add(el);
            }
        }
        Collections.sort(ans);
        return ans;

    }
}
