package BinaryTree.Traversal.Iterative;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PostOrder {
    public static ArrayList<Integer> postorder(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.empty()) {
            Node curr = st.pop();
            ans.add(curr.val);
            if (curr.left != null) st.push(curr.left);
            if (curr.right != null) st.push(curr.right);
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node (2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;

        ArrayList<Integer> ans = postorder(a);
        for(Integer el : ans){
            System.out.print(el + " ");
        }
        System.out.println();
    }
}
