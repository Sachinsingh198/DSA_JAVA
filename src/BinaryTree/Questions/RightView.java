package BinaryTree.Questions;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightView {

    public static ArrayList<Integer> rightViewUsingBfs(Node root){
        if(root == null) return null;
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Node node = q.remove();
                if(i == size - 1){
                    ans.add(node.val);
                }
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        return ans;
    }
    public static ArrayList<Integer> rightView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        view(root, 0, ans);
        return ans;
    }

    private static void view(Node root, int level, ArrayList<Integer> ans) {
        if(root == null)return;
        if(level >= ans.size()) ans.add(root.val);
        else ans.set(level, root.val);
        view(root.left, level + 1, ans);
        view(root.right, level + 1,ans);
    }

    public static void main(String[] args) {

    }
}
