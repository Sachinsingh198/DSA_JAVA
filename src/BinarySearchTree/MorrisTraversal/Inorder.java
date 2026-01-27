package BinarySearchTree.MorrisTraversal;

import BinaryTree.Node;

public class Inorder {

    /**
     * ------------------------------------------------------------
     *  INORDER TRAVERSAL USING MORRIS (O(1) EXTRA SPACE)
     * ------------------------------------------------------------
     * Inorder traversal = Left -> Root -> Right
     *
     * Standard inorder uses recursion (O(h) stack) or explicit stack.
     * Morris traversal avoids stack/recursion by temporarily creating
     * "threads" (temporary right pointers) to come back to a node.
     *
     * Key idea:
     *   For current node (curr):
     *   1) If curr.left is null:
     *        - visit curr (print it)
     *        - move curr = curr.right
     *
     *   2) Else curr.left exists:
     *        - Find predecessor (pred) = rightmost node in curr.left subtree
     *        - Two cases:
     *           a) pred.right == null:
     *                Create thread pred.right = curr
     *                Move curr = curr.left  (go left)
     *
     *           b) pred.right == curr:
     *                Thread already exists => left subtree done
     *                Remove thread pred.right = null
     *                Visit curr (print it)
     *                Move curr = curr.right
     *
     * Important:
     *   Morris traversal modifies the tree temporarily but restores it fully.
     *
     * Complexity:
     *   Time  : O(n)
     *          Each edge is traversed at most a constant number of times.
     *   Space : O(1) extra (no recursion/stack)
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
     * Inorder should be: 3 2 4 1 5 6
     *
     * DRY RUN (high-level thread operations):
     *
     * curr=1, left exists
     *   pred = rightmost in left subtree of 1 => pred=4
     *   pred.right is null => create thread 4.right=1, curr=2
     *
     * curr=2, left exists
     *   pred = rightmost in left subtree of 2 => pred=3
     *   pred.right is null => create thread 3.right=2, curr=3
     *
     * curr=3, left null => visit 3, curr=3.right => curr=2 (via thread)
     *
     * curr=2, left exists
     *   pred=3, pred.right == curr (thread exists)
     *   remove thread 3.right=null
     *   visit 2
     *   curr=2.right => curr=4
     *
     * curr=4, left null => visit 4
     *   curr=4.right => curr=1 (via thread from 4.right=1)
     *
     * curr=1, left exists
     *   pred=4, pred.right == curr (thread exists)
     *   remove thread 4.right=null
     *   visit 1
     *   curr=1.right => curr=5
     *
     * curr=5, left null => visit 5, curr=6
     * curr=6, left null => visit 6, curr=null stop
     *
     * Output: 3 2 4 1 5 6 ✅
     * ------------------------------------------------------------
     */
    public static void InorderMorris(Node root) {
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                // Find Predecessor (rightmost node in left subtree)
                Node pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) { // create thread (link)
                    pred.right = curr;
                    curr = curr.left;
                } else { // pred.right == curr => remove thread + visit
                    pred.right = null;
                    System.out.print(curr.val + " ");
                    curr = curr.right;
                }
            } else {
                // If no left child, visit and go right
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
    }

    // -------------------- Helpers for demo --------------------

    /** Build the same tree used in dry run:
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

    /** Standard recursive inorder (for expected output verification). */
    public static void inorderRecursive(Node root) {
        if (root == null) return;
        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }

    /**
     * Sanity check: Morris should restore the tree.
     * We verify by printing recursive inorder after Morris again.
     */
    public static void main(String[] args) {
        // -------------------- TEST CASE RUN --------------------
        Node root = buildSampleTree();

        System.out.println("Expected Inorder (Recursive):");
        inorderRecursive(root);
        System.out.println("\n");

        System.out.println("Morris Inorder Output:");
        InorderMorris(root);
        System.out.println("\n");

        // Tree should be restored (no threads left),
        // so recursive inorder should still print the same output.
        System.out.println("After Morris, Inorder again (Recursive) to verify tree restored:");
        inorderRecursive(root);
        System.out.println("\n");

        System.out.println("✅ If both recursive outputs match, Morris traversal restored the tree correctly.");
    }
}