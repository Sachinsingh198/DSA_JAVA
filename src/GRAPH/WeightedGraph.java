package GRAPH;

import java.util.ArrayList;

public class WeightedGraph {
    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createWeightedGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,2, 2));

        graph[1].add(new Edge(1,2, 10));
        graph[1].add(new Edge(1,3, 0));

        graph[2].add(new Edge(2,0, 2));
        graph[2].add(new Edge(2,1, 10));
        graph[2].add(new Edge(2,3, -1));

        graph[3].add(new Edge(3,1, 0));
        graph[3].add(new Edge(3,2, -1));
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createWeightedGraph(graph);

        for(int i = 0; i< graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest + "->" + e.wt);
        }
    }
}
