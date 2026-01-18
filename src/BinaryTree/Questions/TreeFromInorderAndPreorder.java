package BinaryTree.Questions;

import BinaryTree.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeFromInorderAndPreorder {
    public static Node BuildTree(int[] inorder, int[] preorder){
        int n = inorder.length;
        return build(0, n-1, 0, n-1, inorder, preorder);
    }
    public static Node build(int preLo, int preHi, int inLo, int inHi, int[] inorder, int[] preorder){
        if(preLo > preHi || inLo > inHi) return null;
        int val = preorder[preLo];
        Node root = new Node(val);
        int r = -1;
        for(int i = inLo; i <= inHi; i++){//Locating root in inorder array
            if(inorder[i] == val){
                r = i;
                break;
            }
        }
        int count = r - inLo;  // number of elements in LST
        root.left = build(preLo + 1, preLo + count, inLo, r-1, inorder, preorder);
        root.right = build(preLo + count + 1, preHi, r + 1, inHi, inorder, preorder);

        return root;
    }

    // ---- helper traversals for verification ----
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
        // Example 1
        int[] inorder1  = {4, 2, 5, 1, 6, 3, 7};
        int[] preorder1 = {1, 2, 4, 5, 3, 6, 7};

        Node root1 = BuildTree(inorder1, preorder1);

        System.out.println("=== Example 1 ===");
        System.out.print("Preorder (expected: 1 2 4 5 3 6 7): ");
        printPreorder(root1); System.out.println();

        System.out.print("Inorder  (expected: 4 2 5 1 6 3 7): ");
        printInorder(root1); System.out.println();

        System.out.print("Postorder(expected: 4 5 2 6 7 3 1): ");
        printPostorder(root1); System.out.println();

        System.out.println("Level Order (each line is a level):");
        printLevelOrder(root1);

        // Example 2 (skewed / mixed shape)
        int[] inorder2  = {9, 3, 15, 20, 7};
        int[] preorder2 = {3, 9, 20, 15, 7};

        Node root2 = BuildTree(inorder2, preorder2);

        System.out.println("\n=== Example 2 ===");
        System.out.print("Preorder (expected: 3 9 20 15 7): ");
        printPreorder(root2); System.out.println();

        System.out.print("Inorder  (expected: 9 3 15 20 7): ");
        printInorder(root2); System.out.println();

        System.out.print("Postorder(expected: 9 15 7 20 3): ");
        printPostorder(root2); System.out.println();

        System.out.println("Level Order (each line is a level):");
        printLevelOrder(root2);
    }
}