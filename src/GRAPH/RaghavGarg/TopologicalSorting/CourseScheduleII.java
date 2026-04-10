package GRAPH.RaghavGarg.TopologicalSorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] pre) {
        int n = pre.length;
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        Boolean[] visited = new Boolean[n];

        for (int i = 1; i <= n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < pre.length; i++){
            int a = pre[i][0];
            int b = pre[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }

        // kahn's algo
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
                visited[i] = true;
            }
        }

        while(!q.isEmpty()){
            int front = q.remove();
            ans.add(front);
            for(int el: adj.get(front)){
                indegree[el]--;
                if(indegree[el] == 0){
                    q.add(el);
                    visited[el] = true;
                }
            }
        }

        int[] ans2 = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            ans2[i] = ans.get(i);
        }

        return (ans.size() != n) ? new int[0] : ans2;
    }
}
