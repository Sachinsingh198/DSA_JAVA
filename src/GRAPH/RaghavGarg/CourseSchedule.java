package GRAPH.RaghavGarg;

import java.util.ArrayList;
import java.util.List;

// using dfs
public class CourseSchedule {

    static boolean ans;

    private void dfs(int i, List<List<Integer>> adj, boolean[] vis, boolean[] path) {
        vis[i] = true;
        path[i] = true;
        for(int el : adj.get(i)) {
            if(path[el]){
                ans = false;
                return;
            }
            dfs(el, adj, vis, path);
        }
        path[i] = false;
    }
    public boolean canFinsih(int n, int[][] pre) {
        ans = true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 1; i <= n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < pre.length; i++){
            int a = pre[i][0], b = pre[i][1];
            adj.get(b).add(a);
        }
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];

        dfs(0, adj, vis, path);
        return ans;
    }


}
