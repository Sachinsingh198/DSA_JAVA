package BinaryTree.Traversal.Iterative;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.Stack;

public class Preorder {
    public ArrayList<Integer> preorder(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node curr = st.pop();
            ans.add(curr.val);
            if(curr.right != null) st.push(curr.right);
            if(curr.left != null) st.push(curr.left);
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
