package BinarySearchTree;

import BinaryTree.Node;

public class LCABst {
    public Node lowestCommonAncestor(Node root, Node n1, Node n2) {
        if(root == null) return null;
        if(root.val > n1.val && root.val > n2.val){
            return lowestCommonAncestor(root.left, n1, n2);
        }
        else if(root.val < n1.val && root.val < n2.val){
            return lowestCommonAncestor(root.right, n1, n2);
        }
        else return root;
    }
}
