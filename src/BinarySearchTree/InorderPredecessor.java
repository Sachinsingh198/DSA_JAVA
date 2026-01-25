package BinarySearchTree;

import BinaryTree.Node;

public class InorderPredecessor {
    Node predecessor(Node root, Node target){
        Node pred = null;
        Node curr = root;

        while (curr != null) {
            if (target.val > curr.val) {
                pred = curr;        // potential predecessor
                curr = curr.right;  // go right
            } else if (target.val < curr.val) {
                curr = curr.left;   // go left
            } else {
                // found the target
                break;
            }
        }

        // Case 1: target has left subtree → rightmost node in left subtree
        if (curr != null && curr.left != null) {
            Node temp = curr.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            pred = temp;
        }

        return pred;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.right = new Node(15);

        InorderPredecessor obj = new InorderPredecessor();
        Node target = root.left.right; // node with value 15
        Node result = obj.predecessor(root, target);
        System.out.println(result != null ? result.val : "null"); // should print 10
    }
}
