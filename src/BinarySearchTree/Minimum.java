package BinarySearchTree;


import BinaryTree.Node;

public class Minimum {
    public static int minimum (Node root){
        if(root == null)return -1;
        Node temp = root;
        while(temp.left != null) temp = temp.left;
        return temp.val;
    }

    public static void main(String[] args) {
        // Manually build this BST:
        //         12
        //        /  \
        //       5    18
        //      / \     \
        //     2   9     20

        Node root = new Node(12);
        root.left = new Node(5);
        root.right = new Node(18);
        root.left.left = new Node(2);
        root.left.right = new Node(9);
        root.right.right = new Node(20);

        // Test 1: Regular BST
        int min1 = minimum(root);
        System.out.println("Minimum (expected 2): " + min1);

        // Test 2: Single-node BST
        Node single = new Node(42);
        int min2 = minimum(single);
        System.out.println("Minimum single-node (expected 42): " + min2);

        // Test 3: Left-skewed BST (strictly decreasing from root)
        //      10
        //      /
        //     5
        //    /
        //   1
        Node leftSkew = new Node(10);
        leftSkew.left = new Node(5);
        leftSkew.left.left = new Node(1);
        int min3 = minimum(leftSkew);
        System.out.println("Minimum left-skewed (expected 1): " + min3);

        // Test 4: Empty tree
        Node empty = null;
        int min4 = minimum(empty);
        System.out.println("Minimum empty (expected -1): " + min4);
    }

}
