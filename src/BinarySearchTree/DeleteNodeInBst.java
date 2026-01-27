package BinarySearchTree;

import BinaryTree.Node;

public class DeleteNodeInBst {

    /**
     * ============================================================
     *  DELETE NODE IN BST
     * ============================================================
     *
     * BST property:
     *   left subtree values < root.val < right subtree values
     *
     * To delete a node with value = target:
     *
     * 1) Search:
     *      - if target < root.val => go left
     *      - if target > root.val => go right
     *      - else found node to delete
     *
     * 2) Delete cases when found:
     *      Case A: Leaf node (no children) => return null
     *      Case B: One child => return the child (bypass current)
     *      Case C: Two children =>
     *          You can replace node with:
     *              - Inorder Predecessor (max in left subtree), OR
     *              - Inorder Successor   (min in right subtree)
     *
     *  Predecessor approach:
     *      pred = rightmost in left subtree
     *      remove pred from left subtree
     *      attach pred.left = updated left subtree
     *      attach pred.right = original right subtree
     *      return pred as new root of this subtree
     *
     *  Successor approach:
     *      succ = leftmost in right subtree
     *      remove succ from right subtree
     *      attach succ.left = original left subtree
     *      attach succ.right = updated right subtree
     *      return succ as new root
     *
     * ------------------------------------------------------------
     * Complexity:
     *   Time  : O(h) average, O(n) worst (skewed tree)
     *   Space : O(h) recursion stack
     * ------------------------------------------------------------
     *
     * DRY RUN EXAMPLE (used in main):
     *
     * Insert: 50, 30, 70, 20, 40, 60, 80
     *
     *            50
     *          /    \
     *        30      70
     *       / \     /  \
     *     20  40   60  80
     *
     * Delete target = 50 (two children case)
     *
     * Using Predecessor:
     *   pred = max of left subtree = 40
     *   delete 40 from left subtree
     *   pred.left = updated left subtree (root 30 with right removed)
     *   pred.right = original right subtree (70...)
     *   return pred (40) as new root
     *
     * Result:
     *            40
     *          /    \
     *        30      70
     *       /       /  \
     *     20       60  80
     *
     * Using Successor:
     *   succ = min of right subtree = 60
     *   delete 60 from right subtree
     *   succ.left = original left subtree (30...)
     *   succ.right = updated right subtree (70 without 60)
     *   return succ (60) as new root
     *
     * Result:
     *            60
     *          /    \
     *        30      70
     *       / \       \
     *     20  40      80
     * ============================================================
     */

    // -------------------- PREDECESSOR APPROACH --------------------
    public static Node deleteUsingPredecessor(Node root, int target) {
        if (root == null) return null;

        if (target < root.val) {
            root.left = deleteUsingPredecessor(root.left, target);
        } else if (target > root.val) {
            root.right = deleteUsingPredecessor(root.right, target);
        } else {
            // Found node to delete

            // Case 1: Leaf
            if (root.left == null && root.right == null) return null;

            // Case 2: One child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Two children => use predecessor (max in left)
            Node pred = root.left;
            while (pred.right != null) pred = pred.right;

            // Remove predecessor from left subtree
            root.left = deleteUsingPredecessor(root.left, pred.val);

            // Attach children to predecessor
            pred.left = root.left;
            pred.right = root.right;

            return pred;
        }
        return root;
    }

    // -------------------- SUCCESSOR APPROACH --------------------
    public static Node deleteUsingSuccessor(Node root, int target) {
        if (root == null) return null;

        if (target < root.val) {
            root.left = deleteUsingSuccessor(root.left, target);
        } else if (target > root.val) {
            root.right = deleteUsingSuccessor(root.right, target);
        } else {
            // Found node to delete

            // Case 1: Leaf
            if (root.left == null && root.right == null) return null;

            // Case 2: One child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Two children => use successor (min in right)
            Node succ = root.right;
            while (succ.left != null) succ = succ.left;

            // Remove successor from right subtree
            root.right = deleteUsingSuccessor(root.right, succ.val);

            // Attach children to successor
            succ.left = root.left;
            succ.right = root.right;

            return succ;
        }
        return root;
    }

    // -------------------- Helpers (BST build + print + copy) --------------------

    /** Insert into BST (iterative/recursive both fine; using recursion). */
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    /** Inorder traversal prints sorted order for BST (good verification). */
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    /** Deep copy so we can test predecessor and successor on same original tree. */
    public static Node cloneTree(Node root) {
        if (root == null) return null;
        Node copy = new Node(root.val);
        copy.left = cloneTree(root.left);
        copy.right = cloneTree(root.right);
        return copy;
    }

    /** Build the dry-run BST from notes: 50, 30, 70, 20, 40, 60, 80 */
    public static Node buildSampleBST() {
        int[] vals = {50, 30, 70, 20, 40, 60, 80};
        Node root = null;
        for (int v : vals) root = insert(root, v);
        return root;
    }

    // -------------------- main() with testcase run --------------------
    public static void main(String[] args) {
        Node original = buildSampleBST();

        System.out.println("Original BST (Inorder):");
        inorder(original);
        System.out.println("\n");

        int target = 50;
        System.out.println("Deleting target = " + target);
        System.out.println("----------------------------------------");

        // Test predecessor approach
        Node rootPred = cloneTree(original);
        rootPred = deleteUsingPredecessor(rootPred, target);
        System.out.println("After deleteUsingPredecessor (Inorder):");
        inorder(rootPred);
        System.out.println("\nExpected structure root becomes predecessor (40) for this sample.\n");

        // Test successor approach
        Node rootSucc = cloneTree(original);
        rootSucc = deleteUsingSuccessor(rootSucc, target);
        System.out.println("After deleteUsingSuccessor (Inorder):");
        inorder(rootSucc);
        System.out.println("\nExpected structure root becomes successor (60) for this sample.\n");

        // Additional quick tests
        System.out.println("Extra Tests:");
        int[] extraDeletes = {20, 70, 999}; // leaf, internal node, not present
        for (int del : extraDeletes) {
            Node test = cloneTree(original);
            test = deleteUsingPredecessor(test, del);
            System.out.print("Delete " + del + " (pred approach) inorder => ");
            inorder(test);
            System.out.println();
        }

        System.out.println("\n✅ Tip: Inorder should always remain sorted after deletion.");
    }
}