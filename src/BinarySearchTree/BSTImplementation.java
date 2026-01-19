package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BSTImplementation {

    // If you don't already have BinaryTree.Node, uncomment this:

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }


    // ------------------ BST Core Operations ------------------

    // Insert a value into the BST; returns the (possibly new) root
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) root.left = insert(root.left, val);
        else if (val > root.val) root.right = insert(root.right, val);
        // If duplicates are allowed, decide a side (e.g., go right):
        // else root.right = insert(root.right, val);
        return root;
    }

    // Build a BST from an array of values in order
    public static Node buildBST(int[] values) {
        Node root = null;
        if (values == null) return null;
        for (int v : values) {
            root = insert(root, v);
        }
        return root;
    }

    // Check if a key exists in BST
    public static boolean contains(Node root, int key) {
        Node cur = root;
        while (cur != null) {
            if (key == cur.val) return true;
            cur = (key < cur.val) ? cur.left : cur.right;
        }
        return false;
    }

    // Delete a key from BST; returns the (possibly new) root
    public static Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {
            // Found node to delete
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Two children: replace with inorder successor (min in right subtree)
            Node succ = minNode(root.right);
            root.val = succ.val;
            root.right = delete(root.right, succ.val);
        }
        return root;
    }

    public static Node minNode(Node node) {
        if (node == null) return null;
        while (node.left != null) node = node.left;
        return node;
    }

    public static Node maxNode(Node node) {
        if (node == null) return null;
        while (node.right != null) node = node.right;
        return node;
    }

    // Validate BST (strictly increasing inorder)
    public static boolean isValidBST(Node root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(Node node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBST(node.left, min, node.val) &&
                isValidBST(node.right, node.val, max);
    }

    // Floor: greatest value <= key (null if none)
    public static Integer floor(Node root, int key) {
        Integer ans = null;
        Node cur = root;
        while (cur != null) {
            if (cur.val == key) return cur.val;
            if (cur.val < key) { ans = cur.val; cur = cur.right; }
            else cur = cur.left;
        }
        return ans;
    }

    // Ceil: smallest value >= key (null if none)
    public static Integer ceil(Node root, int key) {
        Integer ans = null;
        Node cur = root;
        while (cur != null) {
            if (cur.val == key) return cur.val;
            if (cur.val > key) { ans = cur.val; cur = cur.left; }
            else cur = cur.right;
        }
        return ans;
    }

    // k-th smallest (1-indexed). Throws if k invalid.
    public static int kthSmallest(Node root, int k) {
        Stack<Node> st = new Stack<>();
        Node cur = root;
        int count = 0;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if (++count == k) return cur.val;
            cur = cur.right;
        }
        throw new NoSuchElementException("k is larger than size of BST.");
    }

    // Sum values in [low, high] leveraging BST pruning
    public static int rangeSumBST(Node root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return rangeSumBST(root.right, low, high);
        if (root.val > high) return rangeSumBST(root.left, low, high);
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    // ------------------ Traversals & Utilities (same as your Binary Tree) ------------------

    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    public static int size(Node root) {
        return (root == null) ? 0 : (1 + size(root.left) + size(root.right));
    }

    public static int sum(Node root) {
        return (root == null) ? 0 : (root.val + sum(root.left) + sum(root.right));
    }

    public static int product(Node root) {
        return (root == null) ? 1 : (root.val * product(root.left) * product(root.right));
    }

    public static int max(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(max(root.left), max(root.right)));
    }

    // Height (levels): empty tree -> 0
    public static int level(Node root) {
        return (root == null) ? 0 : (1 + Math.max(level(root.left), level(root.right)));
    }

    // ------------------ Root-to-Leaf Path Sum (fixed ArrayList backtracking) ------------------

    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int targetSum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        dfsPaths(root, path, ans, targetSum);
        return ans;
    }

    private static void dfsPaths(Node root, ArrayList<Integer> path,
                                 ArrayList<ArrayList<Integer>> ans, int sumLeft) {
        if (root == null) return;

        // choose
        path.add(root.val);

        // leaf
        if (root.left == null && root.right == null) {
            if (sumLeft - root.val == 0) {
                ans.add(new ArrayList<>(path));
            }
            // backtrack
            path.remove(path.size() - 1); // FIX: ArrayList has no removeLast()
            return;
        }

        // explore
        dfsPaths(root.left, path, ans, sumLeft - root.val);
        dfsPaths(root.right, path, ans, sumLeft - root.val);

        // un-choose
        path.remove(path.size() - 1); // FIX
    }

    // ------------------ Demo ------------------

    public static void main(String[] args) {
        int[] vals = { 8, 5, 1, 7, 10, 12, 9, 3, 6 };
        Node root = buildBST(vals);

        System.out.println("Inorder (sorted):");
        inorder(root); System.out.println();

        System.out.println("Preorder:");
        preorder(root); System.out.println();

        System.out.println("Postorder:");
        postOrder(root); System.out.println();

        System.out.println("Size: " + size(root));
        System.out.println("Sum: " + sum(root));
        System.out.println("Product: " + product(root));
        System.out.println("Max: " + max(root));
        System.out.println("Height(levels): " + level(root));

        System.out.println("Contains 7? " + contains(root, 7));
        System.out.println("Contains 2? " + contains(root, 2));

        System.out.println("Min: " + minNode(root).val + ", Max: " + maxNode(root).val);
        System.out.println("Floor(11): " + floor(root, 11));
        System.out.println("Ceil(11): " + ceil(root, 11));
        System.out.println("k=3 smallest: " + kthSmallest(root, 3));
        System.out.println("Is valid BST? " + isValidBST(root));

        int low = 5, high = 10;
        System.out.println("RangeSumBST [" + low + "," + high + "] = " + rangeSumBST(root, low, high));

        System.out.println("Root-to-leaf paths summing to 22:");
        ArrayList<ArrayList<Integer>> paths = printPaths(root, 22);
        for (List<Integer> p : paths) {
            System.out.println(p);
        }

        // Delete a node and show updated inorder
        root = delete(root, 8);
        System.out.println("Inorder after deleting 8:");
        inorder(root); System.out.println();
    }
}
