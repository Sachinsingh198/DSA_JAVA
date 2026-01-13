package BinaryTree.Questions;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class PathSumRootToLeaf {
    public static void dfs(Node root, int targetSum, List<Integer> path, List<List<Integer>> ans){
        if(root == null) return;
        path.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum){
            ans.add(new ArrayList<>(path));
        }
        else{
            dfs(root.left, targetSum - root.val, path, ans);
            dfs(root.right, targetSum - root.val, path, ans);
        }
        path.remove(path.size() - 1);
    }
    public List<List<Integer>> pathSum(Node root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
