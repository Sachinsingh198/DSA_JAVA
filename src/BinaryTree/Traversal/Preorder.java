package BinaryTree.Traversal;

import BinaryTree.Node;

public class Preorder {
    private static void preorder(Node node){
        if(node == null) {
            return;
        };
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {

    }
}
