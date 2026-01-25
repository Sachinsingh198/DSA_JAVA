package BinaryTree.Questions;

import BinaryTree.Node;

public class TreeFromInorderAndPostorder {
    public Node buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return build(0, n - 1, 0, n - 1, inorder, postorder);
    }

    public static Node build(int inlo, int inhi, int postlo, int posthi, int[] inorder, int[] postorder){
        if(postlo > posthi || inlo > inhi) return null;
        int val = postorder[posthi];
        Node root = new Node(val);
        int r = -1;
        for(int i = inlo; i <= inhi; i++){
            if(inorder[i] == val){
                r = i;
                break;
            }
        }
        int count = r - inlo;
        root.left = build(inlo, r - 1, postlo, postlo + count - 1, inorder, postorder);
        root.right = build(r + 1, inhi, postlo + count, posthi -1, inorder, postorder);
        return root;
    }
}
