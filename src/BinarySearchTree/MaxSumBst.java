package BinarySearchTree;
import BinaryTree.Node;
class QuadBtree{
        int max, min, sum;
boolean isBst;
    QuadBtree(int max, int min, int sum, boolean isBst){
    this.max = max;
    this.min = min;
    this.sum = sum;
    this.isBst = isBst;
}
}
public class MaxSumBst {
    static int maxSum;
    public int maxSumBST(Node root) {
        maxSum = 0;
        QuadBtree q = helper( root);
        return maxSum;
    }

    static QuadBtree helper(Node root){
        if(root == null)return new QuadBtree(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        QuadBtree lst = helper(root.left);
        QuadBtree rst = helper(root.right);
        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val, Math.min(lst.min, rst.min));
        int sum = root.val + lst.sum + rst.sum;
        boolean isBst = lst.isBst && rst.isBst && (lst.max < root.val) && (rst.min > root.val);
        if(isBst) maxSum = Math.max(sum, maxSum);
        return new QuadBtree(max, min, sum, isBst);
    }
    public static void main(String[] args) {

    }
}
