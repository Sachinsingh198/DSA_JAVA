package DP.Questions;

import BinaryTree.Node;

public class BinaryTreeMaxPathSum {
    static int maxSum;
    public int lineSum(Node root){
        if(root == null) return 0;
        int leftLineSum = lineSum(root.left);
        int rightLineSum = lineSum(root.right);
        int pathSum = root.val;
        if(leftLineSum >= 0) pathSum += leftLineSum;
        if(rightLineSum >= 0) pathSum += rightLineSum;
        maxSum = Math.max(maxSum, pathSum);
        return root.val + Math.max(0, Math.max(leftLineSum, rightLineSum));
    }
    public int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        lineSum(root);
        return maxSum;
    }
}
