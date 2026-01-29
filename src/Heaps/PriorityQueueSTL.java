package Heaps;

import java.util.PriorityQueue;

public class PriorityQueueSTL {
    public static void main(String[] args) {
        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(30);
        System.out.println(pq.peek());
    }
}
