package Heaps;


import java.util.*;

class MaxHeapComparator implements Comparator<Integer> {

    int x;

    MaxHeapComparator(int x) {
        this.x = x;
    }

    @Override
    public int compare(Integer a, Integer b) {

        int da = Math.abs(a - x);
        int db = Math.abs(b - x);

        // Larger distance = worse
        if (da != db) return db - da;

        // On tie: LARGER is worse
        return b - a;
    }
}

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(new MaxHeapComparator(x));

        for (int num : arr) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }

        List<Integer> temp = new ArrayList<>();

        while (!pq.isEmpty()) {
            temp.add(pq.poll());
        }

        // Final output must be ascending
        Collections.sort(temp);

        return temp;
    }

    public static void main(String[] args) {

    }
}
