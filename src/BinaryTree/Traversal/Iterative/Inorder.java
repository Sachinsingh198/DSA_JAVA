package BinaryTree.Traversal.Iterative;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.Stack;

public class Inorder {
    public static ArrayList<Integer> inorder(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(!st.empty() || curr != null){
            if(curr != null) {
                if(curr.left != null){
                    st.push(curr);
                    curr = curr.left;
                }
                else{
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
            else{
                Node top = st.pop();
                ans.add(top.val);
                curr = top.right;
            }
        }

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

        ArrayList<Integer> ans = inorder(a);
        for(Integer el : ans){
            System.out.print(el + " ");
        }
        System.out.println();
    }
}
