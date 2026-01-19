
package BinarySearchTree;

import BinaryTree.Node;

public class InsertInBst {
    void attach(Node root, int key){
        if (root == null) return;          // NOTE: no-op if root is null
        if (root.val == key) return;       // ignore duplicates

        if (root.val < key){
            if (root.right == null){
                root.right = new Node(key);
            } else {
                attach(root.right, key);
            }
        } else {
            if (root.left == null){
                root.left = new Node(key);
            } else {
                attach(root.left, key);
            }
        }
    }

    Node insert(Node root, int key){
        // With current design, this won't create a new root if root == null
        attach(root, key);
        return root;
    }

    // --- helper just for demo/verification ---
    private static void printInorder(Node root){
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        InsertInBst bst = new InsertInBst();

        // Build BST with an explicit root first (required by current insert design)
        Node root = new Node(8);
        int[] keys = {3, 10, 1, 6, 14, 4, 7, 13, 8}; // includes duplicate '8' (ignored)
        for (int k : keys) {
            root = bst.insert(root, k);
        }

        System.out.print("Inorder traversal of BST (should be sorted, dup ignored): ");
        printInorder(root);
        System.out.println();

        // Search visually by printing structure (optional)
        // Demonstrate attempting to insert into a null root
        Node root2 = null;
        root2 = bst.insert(root2, 5); // no effect; root2 stays null due to current insert/attach
        System.out.println("After insert into null root, root2 is " + (root2 == null ? "null" : "non-null"));

        // Proper way with current design: create the root first
        root2 = new Node(5);
        bst.insert(root2, 2);
        bst.insert(root2, 9);
        bst.insert(root2, 1);
        bst.insert(root2, 3);

        System.out.print("Inorder traversal of root2: ");
        printInorder(root2);
        System.out.println();
    }
}
