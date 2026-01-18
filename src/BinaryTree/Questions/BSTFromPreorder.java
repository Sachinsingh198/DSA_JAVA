
package BinaryTree.Questions;

import BinaryTree.Node;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Queue;

public class BSTFromPreorder {

    public Node Bst(int[] preorder, int size){
        int[] inorder = Arrays.copyOf(preorder, size);
        Arrays.sort(inorder);
        int n = preorder.length; // consider using 'size' for safety if size < n
        return build(0, n-1, 0, n-1, inorder, preorder);
    }

    public static Node build(int preLo, int preHi, int inLo, int inHi, int[] inorder, int[] preorder){
        if(preLo > preHi || inLo > inHi) return null;
        int val = preorder[preLo];
        Node root = new Node(val);
        int r = -1;
        for(int i = inLo; i <= inHi; i++){ // Locating root in inorder array
            if(inorder[i] == val){
                r = i;
                break;
            }
        }
        if (r == -1) return null; // guard in case of mismatch

        int count = r - inLo;  // number of elements in left subtree
        root.left  = build(preLo + 1, preLo + count, inLo, r - 1, inorder, preorder);
        root.right = build(preLo + count + 1, preHi, r + 1, inHi, inorder, preorder);

        return root;
    }

    // ---------- traversal helpers ----------
    static void printInorder(Node root){
        if(root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
    static void printPreorder(Node root){
        if(root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    static void printPostorder(Node root){
        if(root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.val + " ");
    }
    static void printLevelOrder(Node root){
        if(root == null){
            System.out.println("(empty)");
            return;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                Node cur = q.poll();
                System.out.print(cur.val + " ");
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            System.out.println(); // new line per level
        }
    }

    public static void main(String[] args) {
        BSTFromPreorder builder = new BSTFromPreorder();

        // Example 1: simple BST
        int[] pre1 = {8, 5, 1, 7, 10, 12};
        int size1 = pre1.length;
        Node root1 = builder.Bst(pre1, size1);

        System.out.println("=== Example 1 ===");
        System.out.print("Given Preorder: ");
        for (int x : pre1) System.out.print(x + " ");
        System.out.println();

        System.out.print("Constructed Preorder: ");
        printPreorder(root1); System.out.println();

        System.out.print("Constructed Inorder (should be sorted): ");
        printInorder(root1); System.out.println();

        System.out.print("Constructed Postorder: ");
        printPostorder(root1); System.out.println();

        System.out.println("Level Order (each line = level):");
        printLevelOrder(root1);

        // Example 2: with left-heavy part
        int[] pre2 = {20, 10, 5, 15, 30, 25, 35};
        int size2 = pre2.length;
        Node root2 = builder.Bst(pre2, size2);

        System.out.println("\n=== Example 2 ===");
        System.out.print("Given Preorder: ");
        for (int x : pre2) System.out.print(x + " ");
        System.out.println();

        System.out.print("Constructed Preorder: ");
        printPreorder(root2); System.out.println();

        System.out.print("Constructed Inorder (should be sorted): ");
        printInorder(root2); System.out.println();

        System.out.print("Constructed Postorder: ");
        printPostorder(root2); System.out.println();

        System.out.println("Level Order (each line = level):");
        printLevelOrder(root2);
    }
}
