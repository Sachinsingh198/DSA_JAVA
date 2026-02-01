package Heaps;

import BinaryTree.Node;

public class IsBinaryTreeHeap {

    static int s;

    public boolean isHeap(Node tree) {
        s = size(tree);
        return isMaxHeap(tree) && isCBT(tree, 1);
    }

    public static boolean isMaxHeap(Node root) {
        if (root == null) return true;

        if (root.left != null && root.val <= root.left.val) return false;
        if (root.right != null && root.val <= root.right.val) return false;

        return isMaxHeap(root.left) && isMaxHeap(root.right);
    }

    public static boolean isCBT(Node root, int idx) {
        if (root == null) return true;
        if (idx > s) return false;
        return isCBT(root.left, 2 * idx) && isCBT(root.right, 2 * idx + 1);
    }

    public static int size(Node root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public static void main(String[] args) {

    }
}
