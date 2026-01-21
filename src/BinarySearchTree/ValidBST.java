package BinarySearchTree;

import BinaryTree.Node;

import java.util.ArrayList;

public class ValidBST {
    void inorder(Node root, ArrayList<Integer> inorderList){
        if(root == null) return;
        inorder(root.left, inorderList);
        inorderList.add(root.val);
        inorder(root.right, inorderList);
    }
    public boolean isBST(Node root) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);

        for(int i = 0; i < inorderList.size() - 1; i++){
            if(inorderList.get(i) > inorderList.get(i + 1)) return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
