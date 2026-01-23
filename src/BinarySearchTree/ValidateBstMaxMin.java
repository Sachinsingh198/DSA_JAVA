package BinarySearchTree;

import BinaryTree.Node;
class Triplet {
    int max, min;
    boolean isBst;
    Triplet(int max, int min, boolean isBst){
        this.max = max;
        this.min = min;
        this.isBst = isBst;
    }
}

public class ValidateBstMaxMin {
    static boolean flag;
    public boolean isBST(Node root) {
        return maxMin(root).isBst;
    }
    Triplet maxMin(Node root){
        if(root == null) return new Triplet(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        Triplet lst = maxMin(root.left);
        Triplet rst = maxMin(root.right);
        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val , Math.min(lst.min, rst.min));

        boolean isBst =lst.isBst && rst.isBst && (lst.max < root.val) && (rst.min > root.val);
        return new Triplet(max, min, isBst);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
    }
}
