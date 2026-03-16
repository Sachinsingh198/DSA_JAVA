package DP.Questions;

import BinaryTree.Node;

public class DiameterBST {
    static int dia ;
    public int levels(Node root){
        if(root == null) return 0;
        int leftLevels = levels(root.left);
        int rightLevels = levels(root.right);
        int path  = leftLevels + rightLevels;
        dia = Math.max(dia, path);
        return 1 + Math.max(leftLevels, rightLevels);
    }
    public int diameterOfBinaryTree(Node root) {
        dia = 0;
        levels(root);
        return dia;
    }
}
