package GRAPH.Traversal;

import java.util.ArrayList;

public class CycleDetection {
    public static class Edge{
        int src, dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    private static void createGraph(ArrayList<Edge>[] graph) {
        for(int i = 0; i< graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3 ));

        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,2));
    }

    public static boolean isCycleDetected(ArrayList<Edge>[] graph, boolean[] vis, int curr, boolean[] rec_stack){
        vis[curr] = true;
        rec_stack[curr] = true;
        for (int i = 0; i< graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(rec_stack[e.dest]){
                return true;
            }
            else if(!vis[e.dest]){
                if(isCycleDetected(graph, vis, e.dest, rec_stack)){
                    return true;
                }
            }
        }
        rec_stack[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        boolean[] vis = new boolean[V];
        boolean[] arr = new boolean[V];
        for(int i = 0; i< graph.length; i++){
            if(!vis[i]){
                boolean isCycle = isCycleDetected(graph, vis, 0, arr);
                if(isCycle)
                    System.out.println(isCycle);
                break;
            }

        }

    }
}
