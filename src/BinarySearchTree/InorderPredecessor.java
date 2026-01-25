package BinarySearchTree;

import BinaryTree.Node;

public class InorderPredecessor {
    Node predecessor(Node root){
        Node pred = root;
        if(root.left != null) pred = root.left;
        while(pred.right != null){
            pred = pred.right;
        }
        return pred;
    }
    public static void main(String[] args) {

    }
}
