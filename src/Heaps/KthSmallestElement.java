package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int kthSmallest(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int el : arr){ // n * log k
            pq.add(el); // log k
            if(pq.size() > k) pq.remove();
        }
        return pq.peek();

    }
    public static void main(String[] args) {

    }
}
