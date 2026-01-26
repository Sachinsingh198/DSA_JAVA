package BinarySearchTree.MorrisTraversal;

import BinaryTree.Node;

public class Inorder {
    public static void InorderMorris(Node root){
        Node curr = root;
        while(curr != null){
            if(curr.left != null){
                //Find Predecessor and do work
                Node pred = curr.left;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }
                if(pred.right == null) { // link
                    pred.right = curr;
                    curr = curr.left;
                }
                else{ // pred.right = curr;
                    pred.right = null;
                    System.out.print(curr.val + " ");
                    curr = curr.right;
                }
            }
            else{
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
    }
    public static void main(String[] args) {

    }
}
