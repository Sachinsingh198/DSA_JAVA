package GRAPH.RaghavGarg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    static boolean ans;

    private void bfs(int i, int[][] adj, int[] visited) {
        visited[i] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int front = q.remove();
            int color = visited[front];

            for (int el : adj[front]){
                if(visited[el] == visited[front]){
                    ans = false;
                    return;
                }
                if(visited[el] ==-1){
                    visited[el] = 1- color;
                    q.add(el);
                }
            }
        }
    }
    public boolean isBipartite(int[][] adj) {
        int n = adj.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        ans = true;
        for(int i = 0; i <n; i++){
            if(!ans) return false;
            if(visited[i] == -1) bfs(i, adj, visited);
        }

        return ans;
    }


}
