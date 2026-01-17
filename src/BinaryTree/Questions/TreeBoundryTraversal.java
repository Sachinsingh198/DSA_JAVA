package BinaryTree.Questions;

import BinaryTree.Node;

import java.util.ArrayList;

public class TreeBoundryTraversal {
    private static ArrayList<Integer> boundryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        leftBoundry(root, ans);
        leafNodes(root, ans);
        rightBoundry(root, ans);
        return ans;
    }

    private static void rightBoundry(Node root, ArrayList<Integer> ans) {
        if(root == null) return;
        if(root.left != null && root.right == null) return;
        if(root.right != null) rightBoundry(root.right, ans);
        else rightBoundry(root.left, ans);
        ans.add(root.val);
    }

    private static void leafNodes(Node root, ArrayList<Integer> ans) {
        if(root == null) return;
        if(root.left == null && root.right == null) ans.add(root.val);
        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
    }

    private static void leftBoundry(Node root, ArrayList<Integer> ans) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        ans.add(root.val);
        if(root.left != null) leftBoundry(root.left, ans);
        else leftBoundry(root.right, ans);
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node (2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;

        boundryTraversal(a);
    }
}
