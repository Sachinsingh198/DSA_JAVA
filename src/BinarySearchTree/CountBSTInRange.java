
package BinarySearchTree;

import BinaryTree.Node;

public class CountBSTInRange {

    int getCount(Node root, int l, int h) {
        if (root == null) return 0;
        if (root.val < l) return getCount(root.right, l, h);
        else if (root.val > h) return getCount(root.left, l, h);
        else {
            return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
        }
    }

    public int rangeSumBST(Node root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return rangeSumBST(root.right, low, high);
        else if (root.val > high) return rangeSumBST(root.left, low, high);
        else {
            return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
        }
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

        CountBSTInRange helper = new CountBSTInRange();

        // Test ranges
        int[][] ranges = {
                {1, 7},    // covers left subtree mostly
                {4, 10},   // mid range including root
                {11, 15},  // right-most values
                {2, 2},    // single value absent
                {8, 8},    // exactly the root
                {1, 100}   // entire tree range
        };

        for (int[] r : ranges) {
            int l = r[0], h = r[1];
            int count = helper.getCount(root, l, h);
            int sum   = helper.rangeSumBST(root, l, h);
            System.out.println("Range [" + l + ", " + h + "]: count = " + count + ", sum = " + sum);
        }
    }
}
