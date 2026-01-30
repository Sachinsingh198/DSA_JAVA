package Heaps;

import java.util.PriorityQueue;

public class MinCostOfRopes {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int el : arr){
            pq.add(el);
        }
        int totalCost = 0;
        while(pq.size() > 1){
            int x = pq.remove();
            int y = pq.remove();
            int cost = x + y;
            totalCost += cost;
            pq.add(cost);
        }
        return totalCost;
    }
    public static void main(String[] args) {

    }
}
