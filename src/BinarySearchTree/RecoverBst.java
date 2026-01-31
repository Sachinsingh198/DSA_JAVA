package BinarySearchTree;

import BinaryTree.Node;

import java.util.ArrayList;

public class RecoverBst {
    void inorder(Node root, ArrayList<Node> in ){
        if(root == null) return;
        inorder(root.left, in);
        in.add(root);
        inorder(root.right, in);
    }
    public void recover(Node root) {
        ArrayList<Node> in = new ArrayList<>();
        inorder(root, in);

        Node node1 = null;
        Node node2 = null;

        for(int i = 0; i < in.size() - 1; i++){
            if (in.get(i).val > in.get(i + 1).val) {
                if (node1 == null) node1 = in.get(i); // first inversion 
                node2 = in.get(i + 1); // last inversion 
            }
        }

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;

    }
    public static void main(String[] args) {
        
    }
}
