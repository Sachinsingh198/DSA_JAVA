package BinarySearchTree;

import BinaryTree.Node;

import java.util.ArrayList;

public class KthSmallest {
    static int k2;
    static int ans;
    void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        k2--;
        if(k2 == 0) ans = root.val;
        inorder(root.right);
    }
    public int kthSmallest(Node root, int k) {
        k2 = k;
        ans = -1;
        inorder(root);
        return ans;

    }

    public static void main(String[] args) {

    }
}

