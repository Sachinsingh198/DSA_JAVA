package BinarySearchTree;

import BinaryTree.Node;

public class InorderSuccessor {
    Node successor(Node root, Node target){
        Node succ = null;
        Node curr = root;

        while (curr != null) {
            if (target.val < curr.val) {
                succ = curr;        // potential successor
                curr = curr.left;   // go left
            } else if (target.val > curr.val) {
                curr = curr.right;  // go right
            } else {
                // found the target
                break;
            }
        }

        // Case 1: target has right subtree → leftmost node in right subtree
        if (curr != null && curr.right != null) {
            Node temp = curr.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            succ = temp;
        }

        return succ;
    }

    public static void main(String[] args) {
        // Example usage
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.right = new Node(15);

        InorderSuccessor obj = new InorderSuccessor();
        Node target = root.left; // node with value 10
        Node result = obj.successor(root, target);
        System.out.println(result != null ? result.val : "null"); // should print 15
    }
}
