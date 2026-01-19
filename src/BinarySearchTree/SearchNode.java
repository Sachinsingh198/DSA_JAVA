
package BinarySearchTree;

import BinaryTree.Node;

public class SearchNode {
    public Node searchBST(Node root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        return (root.val > val) ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public static void main(String[] args) {
        // Build this BST:
        //          8
        //        /   \
        //       3     10
        //      / \      \
        //     1   6      14
        //        / \     /
        //       4   7   13

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);

        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        SearchNode searcher = new SearchNode();

        int[] queries = {6, 14, 2, 8, 13, 20};
        for (int q : queries) {
            Node res = searcher.searchBST(root, q);
            if (res != null) {
                System.out.println("Found node with value: " + res.val);
            } else {
                System.out.println("Value " + q + " not found in BST");
            }
        }
    }
}

