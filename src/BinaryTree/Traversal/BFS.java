package BinaryTree.Traversal;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node front = queue.remove();
            System.out.print(front.val + " ");
            if(front.left != null) queue.add(front.left);
            if(front.right != null) queue.add(front.right);
        }
        System.out.println();
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

        bfs(a);
    }
}
