package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
class Triplet implements Comparable<Triplet>{
    int dist, x, y;
    Triplet(int dist, int x, int y){
        this.dist = dist;
        this.x = x;
        this.y = y;
    }

    public int compareTo(Triplet t){
        return this.dist - t.dist;
    }
}
public class KClosestPoints {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            int dist = x*x + y*y;

            pq.add(new Triplet(dist, x, y));
            if(pq.size() > k) pq.remove();
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < k; i++){
            Triplet top = pq.remove();
            ArrayList<Integer> el = new ArrayList<>();
            el.add(top.x);
            el.add(top.y);
            ans.add(el);
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
