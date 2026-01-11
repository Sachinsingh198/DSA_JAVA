package BinaryTree.Questions;

import BinaryTree.Node;

public class LCA {
    public static Node lowestCommonAncestor(Node root, int p, int q){
        if(root == null) return null;
        if(root.val == p || root.val == q) return root;
        boolean pLiesInLeft = exists(root.left, p);
        boolean qLiesInLeft = exists(root.right, q);
        if(pLiesInLeft && qLiesInLeft) return lowestCommonAncestor(root.left, p, q);
        if(!pLiesInLeft && !qLiesInLeft) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }

    private static boolean exists(Node root, int val) {
        if(root == null )return false;
        if(root.val == val) return true;
        return exists(root.left, val) || exists(root.right, val);
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

        Node lca = lowestCommonAncestor(a, 6, 9);
        System.out.println(lca.val);
    }
}
