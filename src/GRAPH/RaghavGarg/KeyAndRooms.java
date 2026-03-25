package GRAPH.RaghavGarg;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeyAndRooms {

    // Using Bfs
    public void Bfs(int i, List<List<Integer>> adj, boolean[] vis){
        int n = adj.size();
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while(!q.isEmpty()){
            int front = q.remove();
            for(int el : adj.get(front)){
                if(!vis[el]){
                    q.add(el);
                    vis[el] = true;
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();

        boolean[] vis = new boolean[n];
        vis[0] = true;
        Bfs(0, adj, vis);
        for(boolean el : vis) if (!el) return false;
        return true;
    }


    //Using DFS
    private void dfs(int start, List<List<Integer>> adj, boolean[] vis) {
        vis[start] = true;
        for(int el : adj.get(start)){
            if(!vis[el]) dfs(el, adj, vis);
        }
    }
    public boolean canVisitAllRoomsDfs(List<List<Integer>> adj) {
        int n = adj.size();

        boolean[] vis = new boolean[n];
        vis[0] = true;
        dfs(0, adj, vis);
        for(boolean el : vis) if (!el) return false;
        return true;
    }


}
