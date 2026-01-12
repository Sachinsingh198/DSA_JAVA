package BinaryTree.Questions;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FlattenBTree {

    void preorder(Node root, ArrayList<Node> ans){
        if(root == null )return ;
        ans.add(root);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
    public void flatten(Node root) {
        if(root == null) return ;
        ArrayList<Node> ans = new ArrayList<>();
        preorder(root, ans);

        for(int i = 0; i < ans.size() - 1; i++){
            Node curr = ans.get(i);
            curr.left = null;
            curr.right = ans.get(i + 1);
        }
        if(!ans.isEmpty()){
            Node last = ans.get(ans.size() - 1);
            last.left = null;
            last.right = null;
        }
        return;
    }
    public static void main(String[] args) {

// Build a simple :
//        1
//      /   \
//     2     3
//    / \   /
//   4   5 6
//
// dist(4,5) = 2 (4 -> 2 -> 5)
// dist(4,6) = 4 (4 -> 2 -> 1 -> 3 -> 6)

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
    }
}
