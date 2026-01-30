package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStone {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int el : stones){
            pq.add(el);
        }
        while(pq.size() > 1){
            int y = pq.remove();
            int x = pq.remove();
            if(x == y) continue;
            else{
                y = y - x;
                pq.add(y);
            }

        }
        return pq.isEmpty() ? 0 : pq.remove();
    }
    public static void main(String[] args) {

    }
}
