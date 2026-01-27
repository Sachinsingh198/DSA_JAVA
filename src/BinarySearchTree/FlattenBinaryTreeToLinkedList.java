package BinarySearchTree;

// NOTE: Make sure your Node class looks like this (or compatible):
// package BinaryTree;
// public class Node {
//     public int val;
//     public Node left, right;
//     public Node(int val) { this.val = val; }
// }

import BinaryTree.Node;

public class FlattenBinaryTreeToLinkedList {

    /**
     * ------------------------------------------------------------
     *  FLATTEN BINARY TREE TO LINKED LIST (MORRIS-STYLE)
     * ------------------------------------------------------------
     * Goal:
     *   Transform the tree into a "linked list" in-place following PREORDER:
     *   root -> left -> right
     *
     * Final structure:
     *   - Every node's left = null
     *   - Every node's right points to the next node in preorder sequence
     *
     * Why Morris idea works:
     *   For every node that has a left child:
     *     1) Find predecessor = rightmost node in left subtree
     *     2) Attach current's right subtree to predecessor.right
     *     3) Move left subtree to the right: curr.right = curr.left
     *     4) Nullify curr.left
     *   Then move curr = curr.right
     *
     * This avoids recursion and stack => O(1) extra space.
     *
     * Complexity:
     *   Time  : O(n)  (Each edge is rewired/traversed constant number of times)
     *   Space : O(1) extra (in-place, no stack/recursion)
     *
     * ------------------------------------------------------------
     * DRY RUN TREE USED IN main():
     *
     *           1
     *         /   \
     *        2     5
     *       / \     \
     *      3   4     6
     *
     * Preorder should be: 1, 2, 3, 4, 5, 6
     *
     * Step-by-step (key rewiring):
     *
     * curr = 1, curr.left exists (2)
     *   pred = rightmost of left subtree of 1:
     *      left subtree is rooted at 2, rightmost = 4
     *   pred.right = curr.right  => 4.right = 5
     *   curr.right = curr.left   => 1.right = 2
     *   curr.left = null         => 1.left = null
     *   move curr = curr.right   => curr = 2
     *
     * Tree now (conceptually along right chain):
     *   1 -> 2 (and 4 already points to 5)
     *
     * curr = 2, curr.left exists (3)
     *   pred = rightmost of left subtree of 2:
     *      left subtree rooted at 3, rightmost = 3
     *   pred.right = curr.right  => 3.right = 4
     *   curr.right = curr.left   => 2.right = 3
     *   curr.left = null         => 2.left = null
     *   move curr = curr.right   => curr = 3
     *
     * curr = 3, curr.left null => move curr = 3.right = 4
     * curr = 4, curr.left null => move curr = 4.right = 5
     * curr = 5, curr.left null => move curr = 5.right = 6
     * curr = 6, curr.left null => move curr = null STOP
     *
     * Final right-chain:
     *   1 -> 2 -> 3 -> 4 -> 5 -> 6
     * and all left pointers are null ✅
     * ------------------------------------------------------------
     */

    public static Node flattenUsingMorris(Node root) {
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) { // predecessor nikal sakte hain
                Node pred = curr.left;
                while (pred.right != null) pred = pred.right;

                pred.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
        return root;
    }

    // -------------------- Helpers for demo --------------------

    /** Print tree in preorder (for verification before flatten). */
    public static void printPreorder(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    /**
     * Print the flattened "linked list" along right pointers.
     * Expected after flatten: left pointers all null.
     */
    public static void printRightChain(Node root) {
        Node curr = root;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.left != null) {
                System.out.print("(LEFT_NOT_NULL!)"); // should not happen after correct flatten
            }
            curr = curr.right;
            if (curr != null) System.out.print(" -> ");
        }
        System.out.println();
    }

    /** Build the exact dry-run test tree:
     *
     *           1
     *         /   \
     *        2     5
     *       / \     \
     *      3   4     6
     */
    public static Node buildSampleTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        return root;
    }

    public static void main(String[] args) {
        // -------------------- TEST CASE RUN --------------------
        // Build tree
        Node root = buildSampleTree();

        System.out.println("Original Tree Preorder (should be 1 2 3 4 5 6):");
        printPreorder(root);
        System.out.println("\n");

        // Flatten
        flattenUsingMorris(root);

        System.out.println("After Flatten (Right chain should be 1 -> 2 -> 3 -> 4 -> 5 -> 6):");
        printRightChain(root);

        // Extra sanity: ensure no left pointers exist
        System.out.println("\nSanity Check: Left pointers should all be null.");
        Node curr = root;
        boolean ok = true;
        while (curr != null) {
            if (curr.left != null) {
                ok = false;
                break;
            }
            curr = curr.right;
        }
        System.out.println(ok ? "✅ PASS (All left are null)" : "❌ FAIL (Some left are not null)");
    }
}
