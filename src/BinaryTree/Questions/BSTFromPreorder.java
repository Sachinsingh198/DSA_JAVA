package BinaryTree.Questions;

import BinaryTree.Node;

import java.util.Arrays;

public class BSTFromPreorder {

    public Node Bst(int[] preorder, int size){
        int[] inorder = Arrays.copyOf(preorder, size);
        Arrays.sort(inorder);
        int n = preorder.length;
        return build(0, n-1, 0, n-1, inorder, preorder);
    }
    public static Node build(int preLo, int preHi, int inLo, int inHi, int[] inorder, int[] preorder){
        if(preLo > preHi || inLo > inHi) return null;
        int val = preorder[preLo];
        Node root = new Node(val);
        int r = 0;
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

    public static void main(String[] args) {

    }
}
