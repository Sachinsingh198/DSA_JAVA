package BinarySearchTree;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.Collections;

public class BstToGst {
    static int sum;
    public static Node transformTree(Node root){
        ArrayList<Node> arr = new ArrayList<>();
        inorder(root, arr);
        Collections.reverse(arr);
        int sum = 0;
        for(int i = 0; i < arr.size(); i++){
            sum += arr.get(i).val;
            arr.get(i).val  = sum;

        }
        return root;
    }

    public static Node transformTreeMemoryEfficeint(Node root){
        sum = 0;
        reverseInorder(root);
        return root;
    }

    private static void reverseInorder(Node root) {
        if(root == null) return;
        reverseInorder(root.right);
        sum += root.val;
        root.val = sum;
        reverseInorder(root.left);

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
