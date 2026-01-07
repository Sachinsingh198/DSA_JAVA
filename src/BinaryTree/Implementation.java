package BinaryTree;

import java.util.ArrayList;

public class Implementation {
    private static void preorder(Node node){
        if(node == null) {
            return;
        };
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node){
        if(node == null) {
            return;
        };
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    private static void postOrder(Node node){
        if(node == null) {
            return;
        };
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    private static int size(Node root){
        return (root == null) ? 0 : (1 + size(root.left) + size(root.right));
    }

    private static int sum(Node root){
        return (root == null) ? 0 : (root.val + sum(root.left) + sum(root.right));
    }

    private static int product(Node root){
        return (root == null) ? 1 : (root.val * product(root.left) * product(root.right));
    }

    private static int max(Node root){
        return (root == null) ? (Integer.MIN_VALUE) : (Math.max((Math.max(root.val, max(root.left))), Math.max(root.val, max(root.right))));
    }

    private static int level(Node root){
        return (root == null) ? 0 : 1 + Math.max(level(root.right), level(root.left));
    }



    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(root, arr, ans, sum);
        return ans;
    }

    private static void dfs(Node root, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans, int sum) {
        if (root == null) return;

        // choose
        arr.add(root.val);

        // If it's a leaf, check sum once and add exactly one copy if it matches
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                ans.add(new ArrayList<>(arr));
            }
            // backtrack and return
            arr.remove(arr.size() - 1);
            return;
        }

        // explore
        dfs(root.left, arr, ans, sum - root.val);
        dfs(root.right, arr, ans, sum - root.val);

        // unchoose (backtrack)
        arr.remove(arr.size() - 1);
    }


    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);



        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        preorder(a);System.out.println();
        inorder(a);System.out.println();
        postOrder(a);System.out.println();

        ArrayList<ArrayList<Integer>> ans = printPaths(a, 9);
        for(ArrayList<Integer> arr : ans){
            for(Integer el: arr){
                System.out.print(el + " ");
            }
            System.out.println();
        }
//        System.out.println();
//        System.out.println(size(a));
//        System.out.println(sum(a));
//        System.out.println(product(a));
//        System.out.println(max(a));
//        System.out.println(level(a));

    }
}
