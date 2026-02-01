package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    int ele, freq;
    Pair(int ele, int freq){
        this.ele = ele;
        this.freq = freq;
    }

    public int compareTo(Pair p){
        if(this.freq == p.freq){
            return this.ele - p.ele;
        }
        return this.freq - p.freq;
    }
}
public class TopKFrequentElements {

    public ArrayList<Integer> topKFrequent(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : arr){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int key : map.keySet()){
            int freq = map.get(key);
            pq.add(new Pair(key, freq));
            if(pq.size() > k) pq.remove();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()){
            Pair top = pq.remove();
            ans.add(top.ele);
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {

    }
}
