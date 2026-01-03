package GRAPH.Traversal;
//BFS: Breadth First Search
/*
//=> Go to Immediate neighbors first
// => Indirect level order traversal
// => Queue data structure is Used in this type of Search Technique
// => Time Complexity = O(V + E)
*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs{
    public static class Edge{
        int src, dest;

        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i< graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6,5));

    }



    public static void bfs(ArrayList<Edge>[] graph, boolean[] visited, int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        while(!que.isEmpty()){
            int curr = que.remove();
            if(!visited[curr]){
                System.out.print(curr + " ");
                for(int i = 0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    que.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 7;
        //        /*
//            1 --- 3
//         /       | \
//        0        |  5 -- 6
//        \        | /
//         2------4
//         */
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.print("Print neighbours of 4: ");
        for(int i = 0; i < graph[4].size(); i++){
            Edge e = graph[4].get(i);
            System.out.print(e.dest + " ");
        }
        System.out.println();

        boolean[] vis = new boolean[V];
        for(int i = 0; i< V; i++){
            if(vis[i] == false){
                bfs(graph, vis, i);
            }
        }
    }
}