package BinarySearchTree;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.Collections;

public class BstToGst {

    public static void transformTree(Node root){
        ArrayList<Node> arr = new ArrayList<>();
        inorder(root, arr);
        Collections.reverse(arr);
        int sum = 0;
        for(int i = 0; i < arr.size(); i++){
            sum += arr.get(i).val;
            arr.get(i).val  = sum;

        }
    }

    private static void inorder(Node root, ArrayList<Node> arr) {
        if(root == null) return;
        inorder(root.left, arr);
        arr.add(root);
        inorder(root.right, arr);
    }

    public static void main(String[] args) {

    }
}
