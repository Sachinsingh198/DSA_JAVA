package BinaryTree.Questions;

import BinaryTree.Node;

import java.util.ArrayList;

public class SpecifiedSum {
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(root, arr, ans, sum);
        return ans;
    }

    private static void dfs(Node root, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans, int sum) {
        if(root == null) return;
        arr.add(root.val);
        if(sum == root.val) ans.add(new ArrayList<>(arr));
        dfs(root.left, arr, ans, sum - root.val);
        dfs(root.right, arr, ans, sum - root.val);

        arr.removeLast();
    }

    public static void main(String[] args) {

    }
}
