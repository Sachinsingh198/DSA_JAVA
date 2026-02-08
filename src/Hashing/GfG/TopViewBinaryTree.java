package Hashing.GfG;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    Node node;
    int dist;
    Pair(Node node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

public class TopViewBinaryTree {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();// <Horizontal distance, node data>>
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int minDist = Integer.MAX_VALUE;
        int maxDist = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            Pair front = q.remove();
            Node node = front.node;
            int dist = front.dist;
            minDist = Math.min(dist, minDist);
            maxDist = Math.max(dist, maxDist);
            if(!map.containsKey(dist)) map.put(dist, node.val);
            if(node.left != null) q.add(new Pair(node.left, dist - 1));
            if(node.right != null) q.add(new Pair(node.right, dist + 1));
        }
        for(int i = minDist; i <=maxDist; i++){
            ans.add(map.get(i));
        }
        return ans;
    }
}
