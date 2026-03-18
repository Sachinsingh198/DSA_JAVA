package DP.Questions;


import BinaryTree.Node;

import java.util.HashMap;
import java.util.Map;

public class DiameterBST {
    static Map<Node, Integer> dp;
    public int levels(BinaryTree.Node root){
        if(root == null) return 0;
        if(dp.containsKey(root)) return dp.get(root);
        int leftLevels = levels(root.left);
        int rightLevels = levels(root.right);
        dp.put(root,1 + Math.max(leftLevels, rightLevels));
        return dp.get(root);
    }
    public int diameter(Node root) {
        if(root == null) return 0;
        int myDia = levels(root.left) + levels(root.right);
        int left  = diameter(root.left);
        int right = diameter(root.right);
        return Math.max(myDia, Math.max(left, right));
    }
    public int diameterOfBinary(Node root) {
        dp = new HashMap<>();
        return diameter(root);
    }
}
