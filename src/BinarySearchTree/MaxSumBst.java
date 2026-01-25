package BinarySearchTree;
import BinaryTree.Node;
class QuadBTree{
    int max, min, size, sum;
    QuadBTree(int max, int min, int size, int sum){
        this.max = max;
        this.min = min;
        this.size = size;
        this.sum = sum;
    }
}
public class MaxSumBst {
    public static QuadBTree maxMinSizeSum(Node root){
        QuadBTree lst = maxMinSizeSum(root.left);
        QuadBTree rst = maxMinSizeSum(root.right);
        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val, Math.min(lst.min, rst.min));
        int size = 1 + lst.size + rst.size;
        int sum = root.val + lst.sum + rst.sum;
        return new  QuadBTree(max, min, size, sum);
    }
    public static void main(String[] args) {

    }
}
