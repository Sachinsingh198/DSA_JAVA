package Heaps;

import BinaryTree.Node;

import java.util.ArrayList;

public class BstToSpecialMaxHeap {
    static int idx = 0;
    public static void convertToMaxHeapUtil(Node root) {
        ArrayList<Integer> in = new ArrayList<>();
        inorder(root, in);
        postorder(root, in);
    }

    private static void postorder(Node root, ArrayList<Integer> in) {
        if(root == null);
        postorder(root.left, in);
        postorder(root.right, in);
        root.val = in.get(idx++);
    }

    private static void inorder(Node root, ArrayList<Integer> in){
        if(root == null) return;
        inorder(root.left, in);
        in.add(root.val);
        inorder(root.right, in);
    }
    public static void main(String[] args) {

    }
}
