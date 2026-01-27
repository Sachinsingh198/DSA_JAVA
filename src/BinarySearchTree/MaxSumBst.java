package BinarySearchTree;

import BinaryTree.Node;

class QuadBtree {
    int max, min, sum;
    boolean isBst;

    QuadBtree(int max, int min, int sum, boolean isBst) {
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.isBst = isBst;
    }
}

public class MaxSumBst {

    /**
     * ============================================================
     *  MAX SUM BST IN A BINARY TREE (POSTORDER DP)
     * ============================================================
     *
     * Problem:
     *  Find the maximum sum of all nodes among all subtrees that are BSTs.
     *  If no BST subtree gives positive sum, answer is 0 (as per LC problem).
     *
     * ------------------------------------------------------------
     * INTUITION (Why Quad helps)
     * ------------------------------------------------------------
     * For each node, to determine whether the subtree rooted at that node
     * is a BST, we need:
     *   1) left subtree must be BST
     *   2) right subtree must be BST
     *   3) max in left subtree < root.val
     *   4) min in right subtree > root.val
     *
     * So for every subtree, we return a "Quad":
     *   - max value in subtree
     *   - min value in subtree
     *   - sum of subtree
     *   - isBst (whether subtree is BST)
     *
     * Then, at root:
     *   isBst = left.isBst && right.isBst
     *           && left.max < root.val
     *           && right.min > root.val
     *
     * If isBst = true, update global maxSum = max(maxSum, sum).
     *
     * ------------------------------------------------------------
     * BASE CASE (Null node)
     * ------------------------------------------------------------
     * For null:
     *   max = -infinity  (Integer.MIN_VALUE)
     *   min = +infinity  (Integer.MAX_VALUE)
     *   sum = 0
     *   isBst = true
     *
     * Why? So it doesn't block parent BST checks:
     *   left.max < root.val is always true if left is null
     *   right.min > root.val is always true if right is null
     *
     * ------------------------------------------------------------
     * COMPLEXITY
     * ------------------------------------------------------------
     * Time  : O(n)   (each node processed exactly once)
     * Space : O(h)   (recursion stack; h = tree height)
     *          worst O(n), balanced O(log n)
     *
     * ------------------------------------------------------------
     * DRY RUN EXAMPLE (Same one used in main Test 1)
     *
     *            1
     *          /   \
     *         4     3
     *        / \   / \
     *       2   4 2   5
     *
     * BST subtrees:
     *  - Leaf nodes are BST: sums = 2,4,2,5
     *  - Subtree rooted at left 4 with children (2,4):
     *       left.max=2 < 4 and right.min=4 > 4 ? NO (4 > 4 false)
     *       so NOT BST.
     *  - Subtree rooted at right 3 with children (2,5):
     *       left.max=2 < 3 and right.min=5 > 3 => BST
     *       sum = 3+2+5 = 10
     *  - Whole tree rooted at 1 is not BST since left subtree not BST, etc.
     *
     * Answer = 10
     * ============================================================
     */

    static int maxSum;

    public int maxSumBST(Node root) {
        maxSum = 0;       // IMPORTANT: reset for each call
        helper(root);
        return maxSum;
    }

    static QuadBtree helper(Node root) {
        if (root == null) {
            return new QuadBtree(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        }

        QuadBtree lst = helper(root.left);
        QuadBtree rst = helper(root.right);

        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val, Math.min(lst.min, rst.min));
        int sum = root.val + lst.sum + rst.sum;

        boolean isBst = lst.isBst && rst.isBst && (lst.max < root.val) && (rst.min > root.val);

        if (isBst) maxSum = Math.max(sum, maxSum);

        return new QuadBtree(max, min, sum, isBst);
    }

    // -------------------- Helpers for demo --------------------

    /** Utility: Inorder print (just to visualize tree). */
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    /** Test 1 (used in dry run notes above):
     *
     *            1
     *          /   \
     *         4     3
     *        / \   / \
     *       2   4 2   5
     *
     * Expected maxSumBST = 10 (subtree rooted at 3 is BST)
     */
    public static Node buildTest1() {
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(3);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right.left = new Node(2);
        root.right.right = new Node(5);

        return root;
    }

    /** Test 2: Entire tree is a BST
     *
     *        5
     *      /   \
     *     3     8
     *    / \   / \
     *   2  4  6  10
     *
     * Expected: sum of all nodes = 5+3+8+2+4+6+10 = 38
     */
    public static Node buildTest2() {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        return root;
    }

    /** Test 3: All negative values
     *
     *      -4
     *     /  \
     *   -2   -5
     *
     * In LC version, answer should be 0 (choose empty / no positive sum BST)
     */
    public static Node buildTest3() {
        Node root = new Node(-4);
        root.left = new Node(-2);
        root.right = new Node(-5);
        return root;
    }

    /** Test 4: Mixed, where best BST is a leaf or small subtree
     *
     *        10
     *       /  \
     *      5    15
     *          /  \
     *         6    20
     *
     * Note: subtree rooted at 15 is NOT BST because 6 is on right-left (<15)
     * Best BST could be (5) or (6) or (20) or (10 with 5?) depending structure
     * Here: Leaf 20 gives sum 20, which is maximum.
     */
    public static Node buildTest4() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(6);
        root.right.right = new Node(20);
        return root;
    }

    public static void runTest(String name, Node root, Integer expectedOrNull) {
        MaxSumBst solver = new MaxSumBst();
        int ans = solver.maxSumBST(root);

        System.out.println("==================================================");
        System.out.println("TEST: " + name);
        System.out.print("Inorder view: ");
        inorder(root);
        System.out.println();

        System.out.println("MaxSumBST Output: " + ans);
        if (expectedOrNull != null) {
            System.out.println("Expected Output : " + expectedOrNull + (ans == expectedOrNull ? " ✅" : " ❌"));
        } else {
            System.out.println("(No fixed expected provided; this is a behavioral test)");
        }
        System.out.println("==================================================\n");
    }

    public static void main(String[] args) {
        // Test 1: matches dry run notes
        runTest("Test 1 (dry-run tree; best BST sum = 10)", buildTest1(), 10);

        // Test 2: whole tree is BST
        runTest("Test 2 (entire tree is BST; sum = 38)", buildTest2(), 38);

        // Test 3: all negative => expected 0 (as per common problem statement)
        runTest("Test 3 (all negative; answer should be 0)", buildTest3(), 0);

        // Test 4: mixed invalid BST at 15, best leaf 20
        runTest("Test 4 (best BST likely leaf 20)", buildTest4(), 20);

        // Edge case: empty tree
        runTest("Edge case: null tree", null, 0);
    }
}