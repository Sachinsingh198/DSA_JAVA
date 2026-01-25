package BinarySearchTree;

import BinaryTree.Node;

public class InorderSuccessor {
    Node successor(Node root){
        Node succ = root;
        if(root.right != null) succ = root.right;
        while(succ.left != null){
            succ = succ.left;
        }
        return succ;
    }
    public static void main(String[] args) {

    }
}
