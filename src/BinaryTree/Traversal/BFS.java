package BinaryTree.Traversal;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    Node node;
    int level;
    Pair (Node node, int level){
        this.node = node;
        this.level = level;
    }
}

public class BFS {
    public static void bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node front = queue.remove();
            System.out.println(front.val + " ");
            if(front.left != null) queue.add(front.left);
            if(front.right != null) queue.add(front.right);
        }
        System.out.println();
    }

    public static void levelOrderBfs(Node root){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int currLevel = 0;

        while(!q.isEmpty()){
            Pair front = q.remove();
            Node node = front.node;
            int level = front.level;
            if(front.level != currLevel){
                currLevel++;
                System.out.println();
            }
            System.out.print(node.val + " ");
            if(node.left != null) q.add(new Pair(node.left, level + 1));
            if(node.right != null) q.add(new Pair(node.right, level + 1));
        }
    }
    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        levelOrderBfs(a);
    }
}
