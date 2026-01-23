package BinarySearchTree;
import BinaryTree.Node;

class Quad{
    int max, min, size;
    boolean isBst;
    Quad(int max, int min, int size, boolean isBst){
        this.max = max;
        this.min = min;
        this.size = size;
        this.isBst = isBst;
    }
}

public class LargestBst {
    static int maxSize;
    public static int  largestBst(Node root){
        maxSize = 0;
        helper(root);
        return maxSize;
    }
    static Quad helper(Node root){
        if(root == null)return new Quad(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        Quad lst = helper(root.left);
        Quad rst = helper(root.right);
        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val, Math.min(lst.min, rst.min));
        int size = 1 + lst.size + rst.size;
        boolean isBst = lst.isBst && rst.isBst && (lst.max < root.val) && (rst.min > root.val);
        if(isBst) maxSize = Math.max(size, maxSize);
        return new Quad(max, min, size, isBst);
    }


    public static void main(String[] args) {

        Node root = new Node(8);
    }
}
