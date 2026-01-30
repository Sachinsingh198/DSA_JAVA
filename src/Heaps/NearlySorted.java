package Heaps;

import java.util.PriorityQueue;

public class NearlySorted {
    public void nearlySorted(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        for(int ele : arr){
            pq.add(ele);
            if(pq.size() > k){
                arr[index++] = pq.remove();
            }
        }
        while(!pq.isEmpty()) arr[index++] = pq.remove();
    }
    public static void main(String[] args) {

    }
}
