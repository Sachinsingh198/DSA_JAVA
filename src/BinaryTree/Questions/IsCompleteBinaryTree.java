package BinaryTree.Questions;

import BinaryTree.Node;

public class IsCompleteBinaryTree {

    static int s;
    public boolean isCompleteTree(Node root) {
        s = size(root);
        return isCBT(root, 1);
    }
    public static boolean isCBT(Node root, int idx) {
        if (root == null) return true;
        if (idx > s) return false;
        return isCBT(root.left, 2 * idx) && isCBT(root.right, 2 * idx + 1);
    }
    int size(Node root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

}
